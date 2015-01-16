package com.xunlei.wifi.test.testcase.wifiinfo;

import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Query extends BaseCase {
	@Test(summary = "根据bssid获取wifi信息", expectedResults = "获取成功", index = 1)
	public void testQuery_1() {
		g_user.setHttpParam("bssidList", "[\"74:91:1a:60:34:78\"]");
		JSONObject result = g_user.getJsonResp(Constant.WIFIINFO_QUERY);
		assertNotNull(result.getJSONArray("wifiInfoList"));
	}
}
