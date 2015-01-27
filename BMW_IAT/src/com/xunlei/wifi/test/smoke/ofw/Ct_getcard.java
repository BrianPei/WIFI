package com.xunlei.wifi.test.smoke.ofw;

import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Ct_getcard extends BaseCase{
	@Test(summary = "客户端请求时长卡-新申请卡", expectedResults = "申请卡成功", index = 1)
	public void test_ct_getcard1() {		
		//入参
		g_user.setHttpParam("status", "0");		
		//调用
		JSONObject result = g_user.postJsonResp(Constant.OFW_CT_GETCARD);
		//验证
		assertNotNull(result);
	}
	
	@Test(summary = "客户端请求时长卡-余额不足时重新申请", expectedResults = "申请卡成功", index = 2)
	public void test_ct_getcard2() {		
		//入参
		g_user.setHttpParam("status", "1");		
		//调用
		JSONObject result = g_user.postJsonResp(Constant.OFW_CT_GETCARD);
		//验证
		assertNotNull(result);
	}
}
