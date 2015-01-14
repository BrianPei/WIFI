package com.xunlei.wifi.test.testcase.wifiinfo;

import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Mine extends BaseCase{
	@Test(summary = "获取当前用户wifi分享列表", expectedResults = "获取成功", index = 1)
	public void testMine() {
		g_user.setHttpParam("page", "0");
		g_user.setHttpParam("count", "10");
		JSONObject result = g_user.postJsonResp(Constant.WIFIINFO_MINE);
		assertNotNull(result);
	}
}
