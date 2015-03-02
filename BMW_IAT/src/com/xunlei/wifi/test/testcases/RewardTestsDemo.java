package com.xunlei.wifi.test.testcases;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.scene.Reward;

public class RewardTestsDemo extends BaseCase {
	@Test(summary = "用户提现并验证", expectedResults = "提现成功", index = 1)
	public void rewardTest_1() {
		// 获取奖金情况，确认有奖金余额
		JSONObject bonusObject = Reward.getBonus(g_user);
		int bonusValue = bonusObject.getInt("deposit");
		assertTrue("用户奖金余额为0", bonusValue > 0);
		// 提现
		int encashExpect = 100;
		JSONObject encashResult = Reward.performEncash(g_user, encashExpect);
		// 验证接口返回值为0即成功
		assertEquals("提现不成功", encashResult.getInt("result"), 0);
		// 验证提现金额正确
		int encashActual = encashResult.getInt("change");
		assertEquals("提现结果中金额不正确", encashExpect, encashActual);
		// 验证最新的提现详情正确
		JSONObject encashDetail = Reward.getLatestEncashDetail(g_user);
		assertEquals("提现详情中UID不正确", encashDetail.getString("userId"),
				g_user.getUid());
		int encashValue = encashDetail.getInt("change");
		assertEquals("提现详情中金额不正确", encashExpect, encashValue);
	}
}
