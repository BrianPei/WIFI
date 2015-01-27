package com.xunlei.wifi.test.smoke.reward;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class List extends BaseCase{
	@Test(summary = "获取当前用户完成任务的情况", expectedResults = "获取成功", index = 1)
	public void testList() {
		g_user.setHttpParam("dump", "reward.list");
		JSONObject result = g_user.getJsonResp(Constant.REWARD_LIST);
		assertNotNull(result.getJSONArray("missionStatusList"));
	}
}
