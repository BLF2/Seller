package net.blf2;

import net.blf2.dao.IWorkShop;
import net.blf2.entity.WorkShop;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by blf2 on 17-6-25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan(basePackages = "net.blf2.dao")
public class TestWorkShop {
    @Resource
    private IWorkShop workShopDao;

    @Test
    public void testWorkShop(){
        WorkShop workShop1 = new WorkShop();
        workShop1.setWorkShopAdmin("曹冲");
        workShop1.setWorkShopName("一号车间");
        workShop1.setWorkShopNum("cj001");
        workShop1.setWorkShopDesc("主要装配自行车");
        try {
            workShopDao.insertWorkShop(workShop1);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        WorkShop queryWorkShop = workShopDao.queryWorkShopByWorkShopNum(workShop1.getWorkShopNum());
        Assert.assertNotNull(queryWorkShop);
        Assert.assertEquals(queryWorkShop.getWorkShopAdmin(),workShop1.getWorkShopAdmin());
        Assert.assertEquals(queryWorkShop.getWorkShopName(),workShop1.getWorkShopName());

        workShop1.setWorkShopName("001号车间");
        workShopDao.updateWorkShop(workShop1);
        queryWorkShop = workShopDao.queryWorkShopByWorkShopNum(workShop1.getWorkShopNum());
        Assert.assertNotNull(queryWorkShop);
        Assert.assertEquals(queryWorkShop.getWorkShopName(),workShop1.getWorkShopName());

        WorkShop workShop2 = new WorkShop();
        workShop2.setWorkShopAdmin("曹冲");
        workShop2.setWorkShopName("一号车间");
        workShop2.setWorkShopNum("cj002");
        workShop2.setWorkShopDesc("主要装配自行车");

        workShopDao.insertWorkShop(workShop2);
        List<WorkShop> workShopList = workShopDao.queryWorkShopAll();
        Assert.assertNotNull(workShopList);
        Assert.assertEquals(workShopList.size(),2);
        System.out.println(workShopList);
    }
}
