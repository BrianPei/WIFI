package com.xunlei.wifi.test.testcase.user;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.model.User;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Login extends BaseCase {
	@Test(summary = "微信登录", expectedResults = "登录成功", index = 1)
	public void testLogin_1() {
		User user = new User();

		user.setHttpParam("extUserId", "oGsKmswsHSifPDfcEdBu6i_bW9hM");
		user.setHttpParam("extUserName", "aixiaoeye");
		user.setHttpParam("platform", "weixin");
		JSONObject result = user.postJsonResp(Constant.USER_LOGINBYTHIRD);
		
		assertNotNull(result);
	}
}
