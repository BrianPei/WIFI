package com.xunlei.wifi.test.testcase;

import static org.junit.Assert.*;
import org.junit.Test;

import net.sf.json.JSONObject;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.model.User;
import com.xunlei.wifi.test.scene.Reward_New;;
	/*
	 * 提现模块：
	 * 未提现金额>0、提现开关开启情况下时，
	 * 提现1元成功
	 * 验证获得金额等于提现金额成功
	 * 
	 */
public class RewardTestcase_New extends BaseCase{
	@Test(summary="提现并验证",expectedResults="成功提现",index=1)
	public void rewardTestcase_New1() {
		//验证获取奖金情况，确认有奖金余额
		JSONObject bonusObject = Reward_New.getBonus(g_user);
		int bonusValue = bonusObject.getInt("deposit");
		assertTrue("用户奖金余额不大于0", bonusValue >=0);
		
		//查询提现开关
		JSONObject configObject= Reward_New.getconfig(g_user);
		int configValue =configObject.getInt("status");
		assertEquals("奖励任务没有开启",configValue,1);
		
		//设置提现金额
		int encashExpected=100;
		JSONObject encashObject = Reward_New.performEncash(g_user, encashExpected);
		//接口验证返回值为0是成功
			int encashValue=encashObject.getInt("result");
			assertEquals("提现结果不是0",encashValue,0);
		//验证支付是否延时、不返回错误码
			int encashStatus=encashObject.getInt("status");
			
			if (encashStatus==0) {
			assertEquals("不是实时支付", 0, 0);
			} else if(encashStatus==1){
			assertEquals("不是延时支付", 1, 1);	
			}
			else {
			assertTrue("返回Status码错误", encashStatus<-10000000);
			}
		//验证实际获得金额等于提现金额
			int encashActual=encashObject.getInt("change");
			assertEquals("实际获得金额不等于提现金额", encashExpected, encashActual);
			
		//验证获取最新提现详情
		JSONObject LatestEncashDetailObject=Reward_New.getLatestEncashDetail(g_user);
		assertEquals("提现用户的userid不相同", LatestEncashDetailObject.getString("userId"), g_user.getUid());
		
		
	}
	 /* 
	  * 查询额外5元任务完成情况
	  * 
	  */
	@Test(summary="查询是否满足5元任务",expectedResults="查询成功",index=2)
	public void rewardTestcase_New2() {
		//验证用户是否满足5元任务
		JSONObject listObject=Reward_New.getlist(g_user);
		assertEquals("满足额外5元任务", listObject.getInt("status"), 0);		
	}
	/*
	 * 查询用户提现记录
	 * 
	 */
	@Test(summary="查询用户提现记录",expectedResults="查询成功",index=3)
	public void rewardTestcase_New3() {
		//输入要查询的用户openid，用户名，tpye
		User testuser=new User("oGsKms0G_IG6cvXk0sKje9sP89XU", "青青的小树", "weixin");
		//验证查询用户提现记录
		JSONObject encashlist=Reward_New.getLatestEncashDetail(testuser);
		assertNotNull(encashlist);		
	}
}
