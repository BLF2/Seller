package net.blf2.util;

import net.blf2.entity.UserInfo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

/**
 * Created by blf2 on 17-6-21.
 */
public class LoginUtil {
    private static HttpSession httpSession = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getSession();
    public static UserInfo getCurrentUser(){
        return (UserInfo)httpSession.getAttribute(Consts.CURRENT_USER);
    }
    public static boolean hasLogin(){
        return LoginUtil.getCurrentUser() != null;
    }
    public static void logIn(UserInfo userInfo){
        httpSession.setAttribute(Consts.CURRENT_USER,userInfo);
    }
    public static void logOut(){
        httpSession.removeAttribute(Consts.CURRENT_USER);
    }
}
