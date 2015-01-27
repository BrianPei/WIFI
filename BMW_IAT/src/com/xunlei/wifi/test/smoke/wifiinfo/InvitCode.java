package com.xunlei.wifi.test.smoke.wifiinfo;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class InvitCode extends BaseCase{
	@Test(summary = "获取邀请码", expectedResults = "获取成功", index = 1)
	public void testInvitCode_1() {
		JSONObject result = g_user.getJsonResp(Constant.WIFIINFO_INVITCODE);
		assertNotNull(result.getString("code"));
	}
}
