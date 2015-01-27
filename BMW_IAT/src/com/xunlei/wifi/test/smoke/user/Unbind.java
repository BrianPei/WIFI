package com.xunlei.wifi.test.smoke.user;

import static org.junit.Assert.assertEquals;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.model.User;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Unbind extends BaseCase {
	@Test(summary = "解绑QQ帐号", expectedResults = "解绑成功", index = 1)
	public void testUnbind_1() {
		g_user.setHttpParam("extUserId", Constant.OPENID_QQ_TEST2);
		g_user.setHttpParam("platform", "qq");
		JSONObject result = g_user.postJsonResp(Constant.USER_UNBIND);
		assertEquals(0, result.getInt("result"));
	}

	@Test(summary = "解绑微信帐号", expectedResults = "解绑成功", index = 2)
	public void testUnbind_2() {
		User user = new User(Constant.OPENID_QQ_TEST,
				Constant.USERNAME_QQ_TEST, "qq");

		user.setHttpParam("extUserId", Constant.OPENID_TEST2);
		user.setHttpParam("platform", "weixin");
		JSONObject result = user.postJsonResp(Constant.USER_UNBIND);
		assertEquals(0, result.getInt("result"));
	}
}
