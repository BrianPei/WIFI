package com.xunlei.wifi.test.smoke.wifiinfo;

import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Collect extends BaseCase{
	@Test(summary = "获取后台收集密码接口", expectedResults = "获取成功", index = 1)
	public void testCollect_1() {
		g_user.setHttpParam("wifiinfo", "[{\"ssid\":\"test1\",\"bssid\":\"08:57:00:4D:77:2C\",\"password\":\"65079002\",\"encryptType\":\"WPA2 PSK\"}]");
		JSONObject result = g_user.getJsonResp(Constant.WIFIINFO_COLLECT);
		assertNotNull(result);
	}
}
