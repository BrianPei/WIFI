package com.xunlei.wifi.test.testcase.ofw;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Cmcc_logout extends BaseCase{
	@Test(summary = "客户端通知下线CMCC", expectedResults = "下线CMCC成功", index = 1)
	public void test_cmcc_logout1() {
		//入参
		g_user.setHttpParam("sessionId", "1421290503859");
		g_user.setHttpParam("duration", "100");
		//调用
		JSONObject result = g_user.postJsonResp(Constant.OFW_CMCC_LOGOUT);
		//验证
		assertEquals(result.getInt("result"),0);
	}
}
