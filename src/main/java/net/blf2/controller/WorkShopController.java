package net.blf2.controller;

import net.blf2.dao.IUserDao;
import net.blf2.dao.IWorkShop;
import net.blf2.entity.UserInfo;
import net.blf2.entity.WorkShop;
import net.blf2.util.Consts;
import net.blf2.util.LoginUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by blf2 on 17-6-26.
 */
@Controller
@RequestMapping("/WorkShop")
public class WorkShopController {
    @Resource
    private IWorkShop workShopDao;
    @Resource
    private UserController userController;
    @Resource
    private IUserDao userDao;

    @RequestMapping("/toWorkShop")
    public ModelAndView toWorkShop(){
        if(!LoginUtil.hasLogin()){
            return userController.returnByViewName("index");
        }
        return userController.returnByViewName("cjmanage");
    }
    @RequestMapping(value = "/updateWorkShop",method = RequestMethod.POST)
    public ModelAndView updateWorkShop(WorkShop workShop,ModelAndView model){
        if(!LoginUtil.hasLogin()){
            return userController.returnByViewName("index");
        }
        try {
            workShopDao.updateWorkShop(workShop);
        }catch (Exception ex){
            ex.printStackTrace();
            model.addObject(Consts.OP_MESSAGE,"数据库错误");
            return userController.returnByViewName("cjmanage",model);
        }
        model.addObject(Consts.OP_MESSAGE,"成功");
        return userController.returnByViewName("cjmanage",model);
    }
    @RequestMapping(value = "/delete")
    public ModelAndView deleteWorkShop(@RequestParam("workShopNum")String workShopNum,ModelAndView model){
        if(!LoginUtil.hasLogin()){
            return userController.returnByViewName("index");
        }
        try {
            workShopDao.deleteWorkShopByWorkShopNum(workShopNum);
        }catch (Exception ex){
            ex.printStackTrace();
            model.addObject(Consts.OP_MESSAGE,"数据库错误");
            return userController.returnByViewName("cjmanage",model);
        }
        model.addObject(Consts.OP_MESSAGE,"成功");
        return userController.returnByViewName("cjmanage",model);
    }
    @RequestMapping(value = "/addWorkShop",method = RequestMethod.POST)
    public ModelAndView addWorkShop(WorkShop workShop,ModelAndView model){
        if(!LoginUtil.hasLogin()){
            return userController.returnByViewName("index");
        }
        try {
            workShopDao.insertWorkShop(workShop);
        }catch (Exception ex){
            ex.printStackTrace();
            model.addObject(Consts.OP_MESSAGE,"数据库错误");
            return userController.returnByViewName("cjmanage",model);
        }
        model.addObject(Consts.OP_MESSAGE,"成功");
        return userController.returnByViewName("cjmanage",model);
    }
    @RequestMapping(value = "/members")
    public ModelAndView members(@RequestParam("workShopNum") String workShopNum,ModelAndView model){
        if(!LoginUtil.hasLogin()){
            return userController.returnByViewName("index");
        }
        List<UserInfo> userInfoList = userDao.queryUserInfoByWorkShopNum(workShopNum);
        model.addObject(Consts.USER_ALL,userInfoList);
        return userController.returnByViewName("members",model);
    }
}
