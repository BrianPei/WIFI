package com.xunlei.wifi.test.smoke.wifiinfo;

import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class UpdateDict extends BaseCase{
	@Test(summary = "更新密码字典", expectedResults = "更新成功", index = 1)
	public void testUpdateDict_1() {
		g_user.setHttpParam("version", "1421065936");
		JSONObject result = g_user.getJsonResp(Constant.WIFIINFO_UPDATEDICT);
		assertNotNull(result);
	}
}
