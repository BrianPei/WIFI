package com.xunlei.wifi.test.testcase.reward;

import static org.junit.Assert.assertEquals;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Submit extends BaseCase{
	@Test(summary = "当前用户完成任务", expectedResults = "任务成功", index = 1)
	public void testSubmit() {
		g_user.setHttpParam("missionId", "1");
		JSONObject result = g_user.getJsonResp(Constant.REWARD_SUBMIT);
		assertEquals(result.getInt("result"), 0);
		assertEquals(result.getInt("missionId"), 1);
	}
}
