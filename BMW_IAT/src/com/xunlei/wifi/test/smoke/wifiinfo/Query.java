package com.xunlei.wifi.test.smoke.wifiinfo;

import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Query extends BaseCase {
	@Test(summary = "根据bssid获取wifi信息", expectedResults = "获取成功", index = 1)
	public void testQuery_1() {
		g_user.setHttpParam("bssidList", "00:00:03:fc:a6:0c,00:01:42:60:00:8c,00:01:a9:01:c7:9c,00:01:41:80:ed:e8,08:57:00:4D:77:2C");
		JSONObject result = g_user.getJsonResp(Constant.WIFIINFO_QUERY);
		assertNotNull(result.getJSONArray("wifiInfoList"));
	}
}
