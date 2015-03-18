package com.xunlei.wifi.test.smoke.wifiinfo;

import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Share extends BaseCase{
	@Test(summary = "主动分享一个wifi", expectedResults = "分享成功", index = 1)
	public void testShare_1() {
		//ssid=test
		/*g_user.setHttpParam("ssid", "test");
		g_user.setHttpParam("bssids", "08:57:00:4D:77:2C,08:57:00:4D:77:2D,08:57:00:4D:77:2E,08:57:00:4D:77:2F");
		g_user.setHttpParam("password", "65079001");
		//g_user.setHttpParam("lon", "116.4605484");
		//g_user.setHttpParam("lat", "39.93012619");
		g_user.setHttpParam("type", "1");
		JSONObject result = g_user.getJsonResp(Constant.WIFIINFO_SHARE);
		assertNotNull(result);	
		*/ 

		g_user.setHttpParam("ssid", "XL_Laptop1");
		g_user.setHttpParam("bssids", "74:91:1a:20:36:3D");
		g_user.setHttpParam("password", "xunleioffice");
		g_user.setHttpParam("lon", "1.12");
		g_user.setHttpParam("lat", "2.23");
		g_user.setHttpParam("type", "1");
		JSONObject result = g_user.getJsonResp(Constant.WIFIINFO_SHARE);
		assertNotNull(result);	
		
	}
	
	/*@Test(summary = "偷偷上传一个wifi", expectedResults = "上传成功", index = 2)
	public void testShare_2() {
		g_user.setHttpParam("ssid", "bossmanman");
		g_user.setHttpParam("bssids", "D0:AE:EC:95:85:22");
		g_user.setHttpParam("password", "123456456789");
		g_user.setHttpParam("type", "2");
		JSONObject result = g_user.getJsonResp(Constant.WIFIINFO_SHARE);
		assertNotNull(result);
	}
	*/
}
