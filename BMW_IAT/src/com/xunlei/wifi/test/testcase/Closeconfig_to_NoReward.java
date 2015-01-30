package com.xunlei.wifi.test.testcase;

import net.sf.json.JSONObject;

import org.junit.Test;
import static org.junit.Assert.*;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;
import com.xunlei.wifi.test.scene.Reward_New;
import com.xunlei.wifi.test.scene.config_New;
import com.xunlei.wifi.test.scene.wifiinfo_New;

	/*雷锋领取金页总开关关闭
	 *共享wifi领现金活动关闭、共享无法得现金
	 *共享wifi得时长活动关闭、共享无法得时长
	 *拉取总开关、共享wifi领现金/时长活动配置，确认关闭
	 */

public class Closeconfig_to_NoReward extends BaseCase{
	@Test(summary="雷锋领取金页总开关关闭、无法提现",expectedResults="无法提现",index=1)
	
	//雷锋领取金页总开关关闭,无法提现
	public void Closeconfig_to_NoRewardtest1(){
		int encashExpected=100;
		JSONObject failtoencash= Reward_New.performEncash(g_user, encashExpected);
		int failtoencashValue=failtoencash.getInt("result");
		assertTrue("提现成功",failtoencashValue!=0);
	}
	
	@Test(summary="共享wifi领现金活动关闭、共享无法得现金",expectedResults="无法得现金",index=2)
	public void Closeconfig_to_NoRewardtest2(){
	//共享wifi领现金活动关闭、共享无法得现金
		String bssids=Constant.WIFI_BSSID;
		String password=Constant.WIFI_PASSWARD;
		int type=Constant.WIFI_TPYE; 
		String ssid=Constant.WIFI_SSID;
		int hasReward=1;// 1:有奖励,0:没有奖励
		int rewardType=1;//1是现金奖励，2是CMCC时长奖励
		JSONObject sharewifi =wifiinfo_New.performSharewifi(g_user, bssids, password, type,ssid,
				hasReward, rewardType);
	 assertTrue("共享wifi得现金不成功", sharewifi!=null);
	}
	
	@Test(summary="共享wifi领时长活动关闭、共享无法得时长",expectedResults="无法得时长",index=3)
	public void Closeconfig_to_NoRewardtest3(){
	//共享wifi领现金活动关闭、共享无法得时长
		String bssids=Constant.WIFI_BSSID;
		String password=Constant.WIFI_PASSWARD;
		int type=Constant.WIFI_TPYE; 
		String ssid=Constant.WIFI_SSID;
		int hasReward=1;// 1:有奖励,0:没有奖励
		int rewardType=2;//1是现金奖励，2是CMCC时长奖励
		JSONObject sharewifi =wifiinfo_New.performSharewifi(g_user, bssids, password, type,ssid,
				hasReward, rewardType);
		assertTrue("共享wifi得时长不成功", sharewifi!=null);
	}
	
	@Test(summary="拉取总开关、共享wifi领现金/时长活动配置，确认关闭",expectedResults="确认已关闭",index=4)
	public void Closeconfig_to_NoRewardtest4(){
	//拉取总开关和共享wifi领现金配置，确认已经关闭
		JSONObject checkconfig_off =Reward_New.getconfig(g_user);
		assertEquals("雷锋领取金页总开关开启", checkconfig_off.getInt("status"), 0);
		assertEquals("共享wifi领现金活动开启", checkconfig_off.getJSONArray("missionConfigList").getJSONObject(1).getInt("missionStatus"), 0);
		
	//拉取共享wifi得时长配置，确认已关闭
		JSONObject checkconfig_off1 =config_New.getconfig(g_user);
		assertEquals("共享wifi领时长活动开启", checkconfig_off1.getInt("win_time_switch"), 1);
	}
	
	
}


