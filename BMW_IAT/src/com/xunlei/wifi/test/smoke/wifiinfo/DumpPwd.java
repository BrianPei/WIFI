package com.xunlei.wifi.test.smoke.wifiinfo;

import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class DumpPwd extends BaseCase{
	@Test(summary = "批量失效密码请求", expectedResults = "请求成功", index = 1)
	public void testdumpPwd_1() {
		//ssid=test
		g_user.setHttpParam("bssids","08:57:00:4D:77:2C");
		g_user.setHttpParam("password", "65079001");
		JSONObject result = g_user.getJsonResp(Constant.WIFIINFO_DUMPPWD);
		assertNotNull(result);
	}
}
