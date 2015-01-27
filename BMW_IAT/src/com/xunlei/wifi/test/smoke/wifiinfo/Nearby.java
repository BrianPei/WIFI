package com.xunlei.wifi.test.smoke.wifiinfo;

import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Nearby extends BaseCase {
	@Test(summary = "获取附近wifi列表", expectedResults = "获取成功", index = 1)
	public void testNearby_1() {
		g_user.setHttpParam("lon", Constant.LON_XUNLEI);
		g_user.setHttpParam("lat", Constant.LAT_XUNLEI);
		g_user.setHttpParam("radius", "1000");
		JSONObject result = g_user.getJsonResp(Constant.WIFIINFO_NEARBY);
		assertNotNull(result.getJSONArray("wifiList"));
	}
}
