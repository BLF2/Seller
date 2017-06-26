package net.blf2;

import net.blf2.dao.IUserDao;
import net.blf2.entity.UserInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import javax.validation.constraints.AssertFalse;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@MapperScan(basePackages = "net.blf2.dao")
public class SellerApplicationTests {
	@Resource
	private IUserDao userDao;
	@Test
	public void testUserDao(){
		UserInfo userInfo1 = new UserInfo();
		userInfo1.setUserId("1001");
		userInfo1.setUserName("曹冲");
		userInfo1.setUserPswd("123456");
		userInfo1.setUserRole("admin");
		userInfo1.setBelongTo("cj001");

		try {
			userDao.insertUserInfo(userInfo1);
		}catch (Exception ex){
			ex.printStackTrace();
		}
		UserInfo queryUser = userDao.queryUserInfoByUserId(userInfo1.getUserId());
		Assert.assertNotEquals(queryUser,null);
		Assert.assertEquals(queryUser.getUserName(),userInfo1.getUserName());
		Assert.assertEquals(queryUser.getUserPswd(),userInfo1.getUserPswd());

		userInfo1.setUserPswd("1234567");
		try {
			userDao.updateUserInfo(userInfo1);
		}catch (Exception ex){
			ex.printStackTrace();
		}
		queryUser = userDao.queryUserInfoByUserId(userInfo1.getUserId());
		Assert.assertNotNull(queryUser);
		Assert.assertEquals(userInfo1.getUserPswd(),queryUser.getUserPswd());

		UserInfo userInfo2 = new UserInfo();
		userInfo2.setUserId("1002");
		userInfo2.setUserName("曹聪");
		userInfo2.setUserPswd("123456");
		userInfo2.setUserRole("monitor");
		userInfo2.setBelongTo("cj002");
		List<UserInfo> userInfoList = null;
		try {
			userDao.insertUserInfo(userInfo2);
			userInfoList = userDao.queryUserInfoAll();
		}catch (Exception ex){
			ex.printStackTrace();
		}
		Assert.assertNotNull(userInfoList);
		Assert.assertEquals(userInfoList.size(),2);
		System.out.println(userInfoList);
	}

}
