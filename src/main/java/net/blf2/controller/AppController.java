package net.blf2.controller;

import net.blf2.dao.IUserDao;
import net.blf2.entity.UserInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * Created by blf2 on 17-6-26.
 */
@Controller
public class AppController {
    @Resource
    private IUserDao userDao;
    @RequestMapping("/")
    public String toIndex(){
        UserInfo userInfo = userDao.queryUserInfoByUserId("13110572081");
        if(userInfo == null){
            userInfo = new UserInfo();
            userInfo.setUserId("13110572081");
            userInfo.setUserPswd("123456");
            userInfo.setUserRole("admin");
            userInfo.setUserName("blf2");
            userInfo.setBelongTo("cj001");
            userDao.insertUserInfo(userInfo);
        }
        return "index";
    }
}
