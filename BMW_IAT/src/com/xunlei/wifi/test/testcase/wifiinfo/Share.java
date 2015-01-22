package com.xunlei.wifi.test.testcase.wifiinfo;

import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Share extends BaseCase{
	@Test(summary = "分享一个wifi", expectedResults = "分享成功", index = 1)
	public void testShare_1() {
		g_user.setHttpParam("bssids", "74:91:1a:60:34:78");
		g_user.setHttpParam("password", "123456");
		g_user.setHttpParam("type", "1");
		JSONObject result = g_user.getJsonResp(Constant.WIFIINFO_SHARE);
		assertNotNull(result);
	}
}
