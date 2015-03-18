package com.xunlei.wifi.test.smoke.wifiinfo;

import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class CheckShareList extends BaseCase {
	@Test(summary = "获取指定wifi分享状态列表", expectedResults = "获取成功", index = 1)
	public void testCheckShareList_1() {
		g_user.setHttpParam("bssids", "08:57:00:4D:77:2c");
		JSONObject result = g_user.getJsonResp(Constant.WIFIINFO_CHECKSHARELIST);
		//assertNotNull(result.getJSONArray("shareWifis"));
		assertNotNull(result);
	}
}
