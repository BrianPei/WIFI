package com.xunlei.wifi.test.smoke.user;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Reg extends BaseCase {
	@Test(summary = "临时用户注册", expectedResults = "注册成功", index = 1)
	public void testReg_1() {
		g_user.setHttpParam("type", "0");
		JSONObject result = g_user.getJsonResp(Constant.USER_REG);
		assertTrue(result.getInt("userId") > 0);
	}
}
