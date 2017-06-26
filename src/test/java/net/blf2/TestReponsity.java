package net.blf2;

import net.blf2.dao.IReponsity;
import net.blf2.entity.ReponsityIo;
import net.blf2.util.Consts;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.logging.java.SimpleFormatter;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by blf2 on 17-6-26.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan(basePackages = "net.blf2.dao")
public class TestReponsity {
    @Resource
    private IReponsity reponsityDao;
    @Test
    public void testReponsity(){
        ReponsityIo reponsityIo1 = new ReponsityIo();
        reponsityIo1.setReponsityNum("20170625001");
        reponsityIo1.setCurrentAdminId("13110572081");
        reponsityIo1.setCurrentAdminName("blf2");
        reponsityIo1.setIoPersonId("13110572082");
        reponsityIo1.setIoPersonName("王若谷");
        reponsityIo1.setMaterialsName("链条");
        reponsityIo1.setMaterialsOp(Consts.INPUT);
        reponsityIo1.setMeasurementUnit("条");
        reponsityIo1.setPricePerUnit(25.0);
        reponsityIo1.setMeasurementNum(20.0);
        reponsityIo1.setTotalCost(reponsityIo1.getMeasurementNum()*reponsityIo1.getPricePerUnit());
        reponsityIo1.setOperateDateTime(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
        
        try {
            reponsityDao.insertReponsity(reponsityIo1);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        ReponsityIo queryReponsity = reponsityDao.queryReponsityByNum(reponsityIo1.getReponsityNum());
        Assert.assertNotNull(queryReponsity);
        Assert.assertEquals(queryReponsity.getCurrentAdminName(),reponsityIo1.getCurrentAdminName());
        
        reponsityIo1.setMaterialsName("三脚架");
        try {
            reponsityDao.updateReponsity(reponsityIo1);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        queryReponsity = reponsityDao.queryReponsityByNum(reponsityIo1.getReponsityNum());
        Assert.assertNotNull(queryReponsity);
        Assert.assertEquals(queryReponsity.getMaterialsName(),reponsityIo1.getMaterialsName());

        ReponsityIo reponsityIo2 = new ReponsityIo();
        reponsityIo2.setReponsityNum("20170625002");
        reponsityIo2.setCurrentAdminId("13110572083");
        reponsityIo2.setCurrentAdminName("毛启超");
        reponsityIo2.setIoPersonId("13110572082");
        reponsityIo2.setIoPersonName("王若谷");
        reponsityIo2.setMaterialsName("链条");
        reponsityIo2.setMaterialsOp(Consts.INPUT);
        reponsityIo2.setMeasurementUnit("条");
        reponsityIo2.setPricePerUnit(25.0);
        reponsityIo2.setMeasurementNum(20.0);
        reponsityIo2.setTotalCost(reponsityIo2.getMeasurementNum()*reponsityIo2.getPricePerUnit());
        reponsityIo2.setOperateDateTime(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));

        reponsityDao.insertReponsity(reponsityIo2);
        List<ReponsityIo> reponsityIoList = reponsityDao.queryReponsityAll();
        Assert.assertNotNull(reponsityIoList);
        Assert.assertEquals(reponsityIoList.size(),2);
        System.out.println(reponsityIoList);
    }
}
