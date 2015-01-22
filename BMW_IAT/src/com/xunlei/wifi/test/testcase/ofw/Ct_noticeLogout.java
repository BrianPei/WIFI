package com.xunlei.wifi.test.testcase.ofw;

import static org.junit.Assert.assertEquals;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Ct_noticeLogout extends BaseCase {
	@Test(summary = "用户正常登出，或者申请后一段时间没有使用该卡，或者异常情况下断网了，客户端重新连上网后，通知服务端该状态", expectedResults = "服务端成功收到状态", index = 1)
	public void test_Ct_noticeLogout1() {
		//入参
		g_user.setHttpParam("userId", "220069");	
		//调用
		JSONObject result = g_user.postJsonResp(Constant.OFW_CT_NOTICELOGOUT);
		//验证
		assertEquals(result.getInt("result"),0);
	}
}
