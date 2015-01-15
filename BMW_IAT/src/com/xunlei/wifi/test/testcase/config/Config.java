package com.xunlei.wifi.test.testcase.config;

import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Config extends BaseCase{
	@Test(summary = "获取客户端通用配置", expectedResults = "获取成功", index = 1)
	public void testConfig() {
		JSONObject result = g_user.getJsonResp(Constant.CONFIG_CONFIG);
		assertNotNull(result);
	}
}
