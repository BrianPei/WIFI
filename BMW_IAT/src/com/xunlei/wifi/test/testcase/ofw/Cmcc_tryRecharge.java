package com.xunlei.wifi.test.testcase.ofw;

import static org.junit.Assert.*;
import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Cmcc_tryRecharge extends BaseCase {
	@Test(summary = "客户端尝试获取CMCC时长", expectedResults = "获取CMCC时长成功", index = 1)
	public void test_cmcc_tryrecharge1() {
	
		//调用
		JSONObject result = g_user.postJsonResp(Constant.OFW_CMCC_TRYRECHARGE);
		//验证
		assertEquals(result.getInt("result"),1); //0是获取到时长，1是未获取到时长
	}
}
