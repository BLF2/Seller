package net.blf2.dao;

import net.blf2.entity.UserInfo;

import java.util.List;

/**
 * Created by blf2 on 17-6-24.
 */
public interface IUserDao {
    void insertUserInfo(UserInfo userInfo);
    void deleteUserInfoByUserId(String userId);
    void updateUserInfo(UserInfo userInfo);
    UserInfo queryUserInfoByUserId(String userId);
    List<UserInfo> queryUserInfoAll();
    List<UserInfo> queryUserInfoByWorkShopNum(String workShopNum);
}
