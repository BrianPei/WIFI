package com.xunlei.wifi.test.testcase.wifiinfo;

import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class ShareCount extends BaseCase {
	@Test(summary = "获取当前用户分享wifi信息", expectedResults = "获取成功", index = 1)
	public void testShareCount_1() {
		g_user.setHttpParam("shareUserId", "220062");
		JSONObject result = g_user.getJsonResp(Constant.WIFIINFO_SHARECOUNT);
		assertNotNull(result.getInt("count"));
	}
}
