package com.xunlei.wifi.test.smoke.wifiinfo;

import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Customdict extends BaseCase{
	@Test(summary = "破解，获取个性化的密码字典", expectedResults = "获取成功", index = 1)
	public void testcustomdict_1() {
		g_user.setHttpParam("bssid", "08:57:00:4D:77:2C");
		g_user.setHttpParam("ssid", "test");
		g_user.setHttpParam("lon", "116.4604721069336");
		g_user.setHttpParam("lat", "39.93004608154297");
		JSONObject result = g_user.getJsonResp(Constant.WIFIINFO_CUSTOMDICT);
		assertNotNull(result);
	}
}
