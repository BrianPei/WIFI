package com.xunlei.wifi.test.testcase;

import net.sf.json.JSONObject;
import static org.junit.Assert.*;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.scene.Ofw;

public class ChinaNetTestcase_New extends BaseCase {
	// 初次申请卡获取ChinaNet时长卡
	@Test(summary = "初次申请卡时，获得chinaNet时长卡->登陆->登出流程成功", expectedResults = "流程可以跑成功", index = 1)
	public void ChinaNetTestcase_New1() {
		JSONObject getcardValue = Ofw.getCard_Newcard(g_user);
		assertNotNull(getcardValue);

		// 用户使用时长卡登录上网后，客户端通知服务端登陆状态
		String userId = Ofw.getCard_Newcard(g_user).getString("userId");
		String cardId = Ofw.getCard_Newcard(g_user).getString("cardId");
		JSONObject noticeLoginValue = Ofw.noticeLogin(g_user, userId, cardId);
		assertEquals("通知服务端登陆失败", noticeLoginValue.getInt("result"), 0);

		// 用户正常登出，或者申请后一段时间没有使用该卡，或者异常情况下断网了，客户端重新连上网后，通知服务端登出状态
		String userId1 = Ofw.getCard_Newcard(g_user).getString("userId");
		String cardId1 = Ofw.getCard_Newcard(g_user).getString("cardId");
		JSONObject noticeLogoutValue = Ofw.noticeLogout(g_user, userId1,
				cardId1);
		assertEquals("通知服务端登出失败", noticeLogoutValue.getInt("result"), 0);
	}

	// 卡余额不足时、换卡、获取ChinaNet时长卡
	@Test(summary = "卡余额不足时、换卡，获得chinaNet时长卡->登陆->登出流程成功", expectedResults = "流程可以跑成功", index = 2)
	public void ChinaNetTestcase_New2() {
		JSONObject getcardValue = Ofw.getCard_changecard(g_user);
		assertNotNull(getcardValue);

		// 用户使用时长卡登录上网后，客户端通知服务端登陆状态
		String userId = Ofw.getCard_changecard(g_user).getString("userId");
		String cardId = Ofw.getCard_changecard(g_user).getString("cardId");
		JSONObject noticeLoginValue = Ofw.noticeLogin(g_user, userId, cardId);
		assertEquals("通知服务端登陆失败", noticeLoginValue.getInt("result"), 0);

		// 用户正常登出，或者申请后一段时间没有使用该卡，或者异常情况下断网了，客户端重新连上网后，通知服务端登出状态
		String userId1 = Ofw.getCard_changecard(g_user).getString("userId");
		String cardId1 = Ofw.getCard_changecard(g_user).getString("cardId");
		JSONObject noticeLogoutValue = Ofw.noticeLogout(g_user, userId1,
				cardId1);
		assertEquals("通知服务端登出失败", noticeLogoutValue.getInt("result"), 0);
	}

}
