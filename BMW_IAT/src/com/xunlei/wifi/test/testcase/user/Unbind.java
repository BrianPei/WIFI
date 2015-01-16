package com.xunlei.wifi.test.testcase.user;

import static org.junit.Assert.assertEquals;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Unbind extends BaseCase {
	@Test(summary = "解绑微信帐号", expectedResults = "不能解绑主帐号", index = 1)
	public void testUnbind_1() {
		g_user.setHttpParam("extUserId", "oGsKms0G_IG6cvXk0sKje9sP89XU");
		g_user.setHttpParam("platform", "weixin");
		JSONObject result = g_user.postJsonResp(Constant.USER_UNBIND);
		assertEquals(1022, result.getInt("code"));
	}
	
	@Test(summary = "解绑QQ帐号", expectedResults = "未绑定过，无法解绑", index = 2)
	public void testUnbind_2() {
		g_user.setHttpParam("extUserId", "8C9F18F0F0301568472F943123C396CD");
		g_user.setHttpParam("platform", "qq");
		JSONObject result = g_user.postJsonResp(Constant.USER_UNBIND);
		assertEquals(1023, result.getInt("code"));
	}
}
