package com.xunlei.wifi.test.smoke.user;

import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Invited extends BaseCase{
	@Test(summary = "输入邀请码", expectedResults = "验证成功", index = 1)
	public void testInvite() {
		g_user.setHttpParam("inviteCode", "123456");
		JSONObject result = g_user.getJsonResp(Constant.USER_INVITED);
		assertNotNull(result);
	}
}
