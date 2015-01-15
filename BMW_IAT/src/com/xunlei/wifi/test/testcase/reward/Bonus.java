package com.xunlei.wifi.test.testcase.reward;

import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Bonus extends BaseCase {
	@Test(summary = "获取当前用户奖金情况", expectedResults = "获取成功", index = 1)
	public void testBonus() {
		g_user.setHttpParam("dump", "reward.bonus");
		JSONObject result = g_user.getJsonResp(Constant.REWARD_BONUS);
		assertNotNull(result.getInt("deposit"));
		assertNotNull(result.getInt("encashed"));
		assertNotNull(result.getLong("userCount"));
	}
}
