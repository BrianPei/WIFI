package com.xunlei.wifi.test.testcase;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.model.User;
import com.xunlei.wifi.test.modules.utils.Constant;
import com.xunlei.wifi.test.scene.wifiinfo_New;

/*
 * 共享wifi模块：
 * 共享wifi得现金
 * 共享wifi得时长
 * 额外奖励
 * 激活奖励
 * 下线提成
 * 一级代理提成
 */
public class WifiinfoTestcase_New extends BaseCase {
	@Test(summary = "共享wifi获得奖励", expectedResults = "获得奖励成功", index = 1)
	public void wifiinfoTestcase_New1() {

		// 共享一个wifi可领取到0.5元现金
		String bssids = Constant.WIFI_BSSID;
		String password = Constant.WIFI_PASSWARD;
		int type = 1;
		String ssid = Constant.WIFI_SSID;// 输入wifi的ssid
		int hasReward = 1;// 1:有奖励,0:没有奖励
		int rewardType = 1;// 1是现金奖励，2是CMCC时长奖励
		JSONObject sharewifi = wifiinfo_New.performSharewifi(g_user, bssids,
				password, type, ssid, hasReward, rewardType);
		assertNotNull("共享wifi不成功", sharewifi);

	}

	@Test(summary = "共享10个wifi获得奖励", expectedResults = "获得奖励成功", index = 2)
	public void wifiinfoTestcase_New2() {
		// 共享10个wifi后可领取5元
		int missionId = 4;
		JSONObject Extra_rewardValue = wifiinfo_New.preformExtra_reward(g_user,
				missionId);
		assertEquals("额外奖励提交结果不成功", Extra_rewardValue.getInt("result"), 0);
	}

	@Test(summary = "共享wifi获得时长", expectedResults = "获得奖励成功", index = 3)
	public void wifiinfoTestcase_New3() {

		// 共享一个wifi可领取到60分钟时长
		String bssids = Constant.WIFI_BSSID;
		String password = Constant.WIFI_PASSWARD;
		int type = 1;
		String ssid = Constant.WIFI_SSID;// 输入wifi的ssid
		int hasReward = 1;// 1:有奖励,0:没有奖励
		int rewardType = 2;// 1是现金奖励，2是CMCC时长奖励
		JSONObject sharewifi = wifiinfo_New.performSharewifi(g_user, bssids,
				password, type, ssid, hasReward, rewardType);
		assertNotNull("共享wifi不成功", sharewifi);

	}

	@Test(summary = "查询新用户激活获得奖励", expectedResults = "获得奖励成功", index = 3)
	public void wifiinfoTestcase_New4() {

		// 激活奖励获取0.5元
		int missionId = 1;
		JSONObject active_RewardValue = wifiinfo_New.preformActive_reward(
				g_user, missionId);
		assertEquals("激活奖励提交结果不成功", active_RewardValue.getInt("result"), 0);
	}

	@Test(summary = "查询发展下线提成奖励", expectedResults = "获得奖励成功", index = 4)
	public void wifiinfoTestcase_New5() {

		// 发展下线提成奖励5%
		int missionId = 5;
		JSONObject percentageValue = wifiinfo_New.preform_reward_percentage(
				g_user, missionId);
		assertEquals("下线奖励提交结果不成功", percentageValue.getInt("result"), 0);

	}

	@Test(summary = "查询一级代理发展提成奖励", expectedResults = "获得奖励成功", index = 5)
	public void wifiinfoTestcase_New6() {
		// 一级代理发展下线提成
		int missionId1 = 6;
		JSONObject partner_percentageValue = wifiinfo_New
				.preform_reward_partner_percentage(g_user, missionId1);
		assertEquals("一级代理奖励提交结果不成功", partner_percentageValue.getInt("result"),
				0);
	}

	@Test(summary = "黑名单用户不能共享成功", expectedResults = "不能共享成功", index = 6)
	public void wifiinfoTestcase_New7() {
		User blacklistuser = new User(Constant.OPENID_BLACKLIST,
				Constant.USERNAME_BLACKLIST, Constant.PLATFORM_BLACKLIST);// 输入黑名单用户Openid、用户名、platform
		String bssids = Constant.WIFI_BSSID;
		String password = Constant.WIFI_PASSWARD;
		int type = Constant.WIFI_TPYE;
		String ssid = Constant.WIFI_SSID;// 输入wifi的ssid
		int hasReward = 1;// 1:有奖励,0:没有奖励
		int rewardType = 1;// 1是现金奖励，2是CMCC时长奖励
		JSONObject sharewifi = wifiinfo_New.performSharewifi(blacklistuser,
				bssids, password, type, ssid, hasReward, rewardType);
		assertEquals("共享wifi成功", sharewifi.getInt("code"), 3);
	}

}
