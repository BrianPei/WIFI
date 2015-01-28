package com.xunlei.wifi.test.testcase;

import net.sf.json.JSONObject;

import org.junit.Test;
import static org.junit.Assert.*;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.scene.Reward_New;
import com.xunlei.wifi.test.scene.wifiinfo_New;

	/*雷锋领取金页总开关关闭
	 *共享wifi领现金活动关闭、共享无法得现金
	 *共享wifi得时长活动关闭、共享无法得时长
	 */

public class Closeconfig_to_NoReward extends BaseCase{
	@Test(summary="雷锋领取金页总开关关闭、无法提现",expectedResults="无法提现",index=1)
	
	//雷锋领取金页总开关关闭,无法提现
	public void Closeconfig_toNoRewardtest1(){
		int encashExpected=100;
		JSONObject failtoencash= Reward_New.performEncash(g_user, encashExpected);
		int failtoencashValue=failtoencash.getInt("result");
		assertTrue("提现成功",failtoencashValue!=0);
	}
	@Test(summary="共享wifi领现金活动关闭、共享无法得现金",expectedResults="无法得现金",index=2)
	public void Closeconfig_toNoRewardtest2(){
	//共享wifi领现金活动关闭、共享无法得现金
		String bssids="74:91:1a:60:34:80";
		String password="123456";
		int type=1; 
		int hasReward=1;// 1:有奖励,0:没有奖励
		int rewardType=1;//1是现金奖励，2是CMCC时长奖励
		JSONObject sharewifi =wifiinfo_New.performSharewifi(g_user, bssids, password, type,
				hasReward, rewardType);
	 assertTrue("共享wifi得现金不成功", sharewifi!=null);
	}
	
	@Test(summary="共享wifi领时长活动关闭、共享无法得时长",expectedResults="无法得时长",index=2)
	public void Closeconfig_toNoRewardtest3(){
	//共享wifi领现金活动关闭、共享无法得时长
		String bssids="74:91:1a:60:34:80";
		String password="123456";
		int type=1; 
		int hasReward=1;// 1:有奖励,0:没有奖励
		int rewardType=2;//1是现金奖励，2是CMCC时长奖励
		JSONObject sharewifi =wifiinfo_New.performSharewifi(g_user, bssids, password, type,
				hasReward, rewardType);
	 assertTrue("共享wifi得时长不成功", sharewifi!=null);
	}
}

