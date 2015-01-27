package com.xunlei.wifi.test.smoke.user;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Ignore;
import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.model.User;
import com.xunlei.wifi.test.modules.utils.Constant;

public class LoginByThird extends BaseCase {
	@Test(summary = "微信登录", expectedResults = "登录成功", index = 1)
	public void testLoginByThird_1() {
		User user = new User();
		// 入参
		user.setHttpParam("extUserId", "oGsKms0G_IG6cvXk0sKje9sP89XU");
		user.setHttpParam("extUserName", "青青的小树");
		user.setHttpParam("platform", "weixin");
		// 调用
		JSONObject result = user.postJsonResp(Constant.USER_LOGINBYTHIRD);
		// 验证
		assertEquals(220062, result.getInt("userId"));
		assertEquals(1, result.getInt("tag"));
	}

	@Test(summary = "QQ登录", expectedResults = "登录成功", index = 2)
	public void testLoginByThird_2() {
		User user = new User();

		user.setHttpParam("extUserId", Constant.OPENID_QQ_TEST);
		user.setHttpParam("extUserName", Constant.USERNAME_QQ_TEST);
		user.setHttpParam("platform", "qq");
		JSONObject result = user.postJsonResp(Constant.USER_LOGINBYTHIRD);
		assertEquals(220112, result.getInt("userId"));
		assertEquals(1, result.getInt("tag"));
	}

	@Test(summary = "微信注册", expectedResults = "注册成功", index = 3)
	@Ignore
	public void testLoginByThird_3() {
		User user = new User();

		user.setHttpParam("extUserId", Constant.USERID_TEST);
		user.setHttpParam("extUserName", "青青的小树");
		user.setHttpParam("platform", "weixin");
		JSONObject result = user.postJsonResp(Constant.USER_LOGINBYTHIRD);
		assertTrue(result.getInt("userId") > 0);
		assertEquals(0, result.getInt("tag"));
	}

	@Test(summary = "QQ注册", expectedResults = "注册成功", index = 4)
	@Ignore
	public void testLoginByThird_4() {
		User user = new User();

		user.setHttpParam("extUserId", "8C9F18F0F0301568472F943123C396CD");
		user.setHttpParam("extUserName", "下雨天");
		user.setHttpParam("platform", "qq");
		JSONObject result = user.postJsonResp(Constant.USER_LOGINBYTHIRD);
		assertTrue(result.getInt("userId") > 0);
		assertEquals(0, result.getInt("tag"));
	}
}
