package com.xunlei.wifi.test.testcase.reward;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Config extends BaseCase {
	@Test(summary = "获取奖励任务配置", expectedResults = "获取成功", index = 1)
	public void testConfig() {
		g_user.setHttpParam("dump", "reward.config");
		JSONObject result = g_user.getJsonResp(Constant.REWARD_CONFIG);
		assertEquals(result.getInt("status"), 1);
	}
}
