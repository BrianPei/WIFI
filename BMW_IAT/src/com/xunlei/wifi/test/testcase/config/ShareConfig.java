package com.xunlei.wifi.test.testcase.config;

import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class ShareConfig extends BaseCase{
	@Test(summary = "获取分享内容配置", expectedResults = "获取成功", index = 1)
	public void testShareConfig() {
		JSONObject result = g_user.getJsonResp(Constant.CONFIG_SHARECONFIG);
		assertNotNull(result.getJSONArray("configList"));
	}
}
