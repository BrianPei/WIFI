package com.xunlei.wifi.test.testcase.reward;

import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class EncashDetail extends BaseCase {
	@Test(summary = "获取当前用户提现详情", expectedResults = "获取成功", index = 1)
	public void testEncashDetail() {
		g_user.setHttpParam("count", "0");
		g_user.setHttpParam("actionId", "0");
		JSONObject result = g_user.getJsonResp(Constant.REWARD_ENCASHDETAIL);
		assertNotNull(result.getJSONArray("encashDetailList"));
	}
}
