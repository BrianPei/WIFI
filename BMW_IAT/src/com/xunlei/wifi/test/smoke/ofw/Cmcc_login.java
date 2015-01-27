package com.xunlei.wifi.test.smoke.ofw;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Cmcc_login extends BaseCase {
	@Test(summary = "客户端通知登陆CMCC", expectedResults = "登陆CMCC成功", index = 1)
	public void test_cmcc_login1() {
		//入参
		g_user.setHttpParam("sessionId", "1421307666333");
		g_user.setHttpParam("duration", "100");
		//调用
		JSONObject result = g_user.postJsonResp(Constant.OFW_CMCC_LOGIN);
		//验证
		assertTrue(result.getInt("result")>=0);
	}
}
