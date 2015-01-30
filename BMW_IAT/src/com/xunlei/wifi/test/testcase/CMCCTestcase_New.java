package com.xunlei.wifi.test.testcase;

import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;
import static org.junit.Assert.*;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.scene.Ofw;

public class CMCCTestcase_New extends BaseCase{
		//获得CMCC时长
		@Test(summary="获得CMCC时长卡->登陆->登出流程成功",expectedResults="流程可以跑成功",index=1)
		public void CMCCTestcase_New1(){
			JSONObject getbalanceValue=Ofw.getbalance(g_user);
			assertNotNull(getbalanceValue);
			
		//进行CMCC登录
		long sessionId=System.currentTimeMillis();
		int duration=120000;
		JSONObject performLoginValue=Ofw.performLogin(g_user, sessionId, duration);
		assertEquals("CMCC登录失败", performLoginValue.getInt("result"), 0);
		
		//客户端通知下线CMCC
		int duration1=60000;
		JSONObject performLogoutValue=Ofw.performLogout(g_user, sessionId, duration1);
		assertNotNull(performLogoutValue);
		assertEquals("CMCC登出失败", performLoginValue.getInt("result"), 0);
		}
		
		@Test(summary="客户端尝试获取CMCC奖励时长",expectedResults="获得成功",index=2)
		public void CMCCTestcase_New2(){
			JSONObject tryRechargeValue=Ofw.tryRecharge(g_user);
			assertNotNull(tryRechargeValue);

		}
	
}
