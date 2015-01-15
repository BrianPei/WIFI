package com.xunlei.wifi.test.testcase.ofw;


import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Cmcc_balance extends BaseCase{
	@Test(summary = "客户端申请用户剩余CMCC时长", expectedResults = "客户端获得用户剩余CMCC时长", index = 1)
	public void test_cmcc_balance1() {
	
		//调用
		JSONObject result = g_user.postJsonResp(Constant.OFW_CMCC_BALANCE);
		//验证
		assertTrue(result.getInt("balance")>=0);
		assertTrue(result.getInt("todayBalance")>=0);
		
	}
}
