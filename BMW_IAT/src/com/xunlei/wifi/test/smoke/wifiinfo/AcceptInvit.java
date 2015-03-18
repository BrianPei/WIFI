package com.xunlei.wifi.test.smoke.wifiinfo;

import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class AcceptInvit extends BaseCase{
	@Test(summary = "输入邀请码", expectedResults = "成功输入", index = 1)
	public void testAcceptInvite_1() {
		g_user.setHttpParam("invitCode", "5gk4");
		JSONObject result = g_user.getJsonResp(Constant.WIFIINFO_ACCEPTINVIT);
		assertNotNull(result.getString("code"));
	}
}
