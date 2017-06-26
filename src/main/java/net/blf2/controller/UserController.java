package net.blf2.controller;

import net.blf2.dao.IReponsity;
import net.blf2.dao.IUserDao;
import net.blf2.dao.IWorkShop;
import net.blf2.entity.ReponsityIo;
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
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by blf2 on 17-6-21.
 */
@Controller
@RequestMapping("/User")
public class UserController {
    @Resource
    private IUserDao userDao;
    @Resource
    private IWorkShop workShopDao;
    @Resource
    private IReponsity reponsityDao;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView login(@RequestParam("userId")String userId,@RequestParam("userPswd")String userPswd,
                              ModelAndView model){
        UserInfo userInfo = userDao.queryUserInfoByUserId(userId);
        if(userInfo == null){
            model.addObject(Consts.OP_MESSAGE,"用户名不存在");
            return returnByViewName("index",model);
        }
        if(!userPswd.equals(userInfo.getUserPswd())){
            model.addObject(Consts.OP_MESSAGE,"用户名和密码不匹配");
            return returnByViewName("index",model);
        }
        LoginUtil.logIn(userInfo);
        return returnByViewName("main");
    }
    @RequestMapping("/logout")
    public ModelAndView logOut(ModelAndView model){
        if(LoginUtil.hasLogin())
            LoginUtil.logOut();
        return returnByViewName("index");

    }
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public ModelAndView toIndex(){
        return returnByViewName("index");
    }
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST)
    public ModelAndView updateUser(UserInfo userInfo,ModelAndView model){
        if(!LoginUtil.hasLogin()){
            return returnByViewName("index");
        }
        try {
            userDao.updateUserInfo(userInfo);
        }catch (Exception ex){
            ex.printStackTrace();
            model.addObject(Consts.OP_MESSAGE,"数据库出错");
            return returnByViewName("main",model);
        }
        model.addObject(Consts.OP_MESSAGE,"成功");
        return returnByViewName("main",model);
    }
    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public ModelAndView addUser(UserInfo userInfo,ModelAndView model){
        if(!LoginUtil.hasLogin()){
            return returnByViewName("index");
        }
        try {
            userDao.insertUserInfo(userInfo);
        }catch (Exception ex){
            ex.printStackTrace();
            model.addObject(Consts.OP_MESSAGE,"数据库出错");
            return returnByViewName("main",model);
        }
        model.addObject(Consts.OP_MESSAGE,"成功");
        return returnByViewName("main",model);
    }
    @RequestMapping("/toMain")
    public ModelAndView toMain(){
        if(!LoginUtil.hasLogin())
            return returnByViewName("index");
        return returnByViewName("main");
    }

    @RequestMapping("/delete")
    public ModelAndView deleteUser(@RequestParam("userId") String userId,ModelAndView model){
        if(!LoginUtil.hasLogin())
            return returnByViewName("index");
        try {
            userDao.deleteUserInfoByUserId(userId);
        }catch (Exception ex){
            ex.printStackTrace();
            model.addObject(Consts.OP_MESSAGE,"数据库出错");
            return returnByViewName("main",model);
        }
        model.addObject(Consts.OP_MESSAGE,"成功");
        return returnByViewName("main",model);
    }


    public ModelAndView returnByViewName(@NotNull String viewName, ModelAndView model){
        if(model == null)
            model = new ModelAndView();
        if("main".equals(viewName)){
            List<UserInfo> userInfoList = userDao.queryUserInfoAll();
            model.addObject(Consts.USER_ALL,userInfoList);
        }else if("cjmanage".equals(viewName)){
            List<WorkShop> workShopList = workShopDao.queryWorkShopAll();
            model.addObject(Consts.WORK_SHOP_ALL,workShopList);
        }else if("reponsity".equals(viewName)){
            List<ReponsityIo> reponsityIoList = reponsityDao.queryReponsityAll();
            model.addObject(Consts.REPONSITY_IO_ALL,reponsityIoList);
        }
        model.setViewName(viewName);
        return model;
    }

    public ModelAndView returnByViewName(String viewName){
        return this.returnByViewName(viewName,null);
    }

    public ModelAndView returnError(String errorMessage){
        ModelAndView model = new ModelAndView();
        model.setViewName("error");
        model.addObject(Consts.ERROR_MESSAGE,errorMessage);
        return model;
    }
}
