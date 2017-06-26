package net.blf2.controller;

import net.blf2.dao.IReponsity;
import net.blf2.entity.ReponsityIo;
import net.blf2.util.Consts;
import net.blf2.util.LoginUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by blf2 on 17-6-26.
 */
@Controller
@RequestMapping("/Repon")
public class ReponsityController {
    @Resource
    private IReponsity reponsityDao;
    @Resource
    private UserController userController;

    @RequestMapping("/toRepon")
    public ModelAndView toRepon(){
        if(!LoginUtil.hasLogin())
            return userController.returnByViewName("index");
        return userController.returnByViewName("reponsity");
    }
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ModelAndView update(ReponsityIo reponsityIo,ModelAndView model){
        if(!LoginUtil.hasLogin())
            return userController.returnByViewName("index");
        reponsityIo.setTotalCost(reponsityIo.getPricePerUnit()*reponsityIo.getMeasurementNum());
        reponsityIo.setOperateDateTime(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
        try {
            reponsityDao.updateReponsity(reponsityIo);
        }catch (Exception ex){
            ex.printStackTrace();
            model.addObject(Consts.OP_MESSAGE,"数据库出错");
            return userController.returnByViewName("reponsity",model);
        }
        model.addObject(Consts.OP_MESSAGE,"成功");
        return userController.returnByViewName("reponsity",model);
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ModelAndView add(ReponsityIo reponsityIo,ModelAndView model){
        if(!LoginUtil.hasLogin())
            return userController.returnByViewName("index");
        reponsityIo.setTotalCost(reponsityIo.getPricePerUnit()*reponsityIo.getMeasurementNum());
        reponsityIo.setOperateDateTime(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
        try {
            reponsityDao.insertReponsity(reponsityIo);
        }catch (Exception ex){
            ex.printStackTrace();
            model.addObject(Consts.OP_MESSAGE,"数据库出错");
            return userController.returnByViewName("reponsity",model);
        }
        model.addObject(Consts.OP_MESSAGE,"成功");
        return userController.returnByViewName("reponsity",model);
    }
    @RequestMapping("/delete")
    public ModelAndView delete(@RequestParam("reponsityNum")String reponsityNum,ModelAndView model){
        if(!LoginUtil.hasLogin())
            return userController.returnByViewName("index");
        try {
            reponsityDao.deleteReponsityByNum(reponsityNum);
        }catch (Exception ex){
            ex.printStackTrace();
            model.addObject(Consts.OP_MESSAGE,"数据库出错");
            return userController.returnByViewName("reponsity",model);
        }
        model.addObject(Consts.OP_MESSAGE,"成功");
        return userController.returnByViewName("reponsity",model);
    }
}
