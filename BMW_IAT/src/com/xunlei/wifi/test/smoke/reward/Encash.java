package com.xunlei.wifi.test.smoke.reward;

import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Encash extends BaseCase{
	@Test(summary = "当前用户提现", expectedResults = "", index = 1)
	public void testEncash() {
		g_user.setHttpParam("amount", "1");
		JSONObject result = g_user.getJsonResp(Constant.REWARD_ENCASH);
		assertNotNull(result.getInt("result"));
		assertNotNull(result.getInt("status"));
	}
}
