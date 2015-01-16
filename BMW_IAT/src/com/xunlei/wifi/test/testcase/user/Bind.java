package com.xunlei.wifi.test.testcase.user;

import static org.junit.Assert.assertEquals;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Bind extends BaseCase{
	@Test(summary = "绑定QQ帐号", expectedResults = "", index = 1)
	public void testBind_1() {
		g_user.setHttpParam("extUserId", "8C9F18F0F0301568472F943123C396CD");
		g_user.setHttpParam("platform", "qq");
		JSONObject result = g_user.postJsonResp(Constant.USER_BIND);
		assertEquals(0, result.getInt("result"));
	}
}
