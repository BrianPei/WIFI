package com.xunlei.wifi.test.smoke.user;

import static org.junit.Assert.assertEquals;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.model.User;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Bind extends BaseCase{
	@Test(summary = "绑定QQ帐号", expectedResults = "绑定成功", index = 1)
	public void testBind_1() {
		g_user.setHttpParam("extUserId", Constant.OPENID_QQ_TEST2);
		g_user.setHttpParam("platform", "qq");
		JSONObject result = g_user.postJsonResp(Constant.USER_BIND);
		assertEquals(0, result.getInt("result"));
	}
	
	@Test(summary = "绑定微信帐号", expectedResults = "绑定成功", index = 2)
	public void testBind_2() {
		User user = new User(Constant.OPENID_QQ_TEST, Constant.USERNAME_QQ_TEST,"qq");
		
		user.setHttpParam("extUserId", Constant.OPENID_TEST2);
		user.setHttpParam("platform", "weixin");
		JSONObject result = user.postJsonResp(Constant.USER_BIND);
		assertEquals(0, result.getInt("result"));
	}
}
