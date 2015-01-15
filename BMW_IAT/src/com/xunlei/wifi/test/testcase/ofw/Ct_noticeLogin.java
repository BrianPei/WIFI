package com.xunlei.wifi.test.testcase.ofw;

import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Ct_noticeLogin extends BaseCase{
	@Test(summary = "用户使用时长卡登陆上网后，客户端通知服务端该状态", expectedResults = "服务端成功收到状态", index = 1)
	public void test_Ct_noticeLogin1() {
		//入参
		g_user.setHttpParam("userId", "220069");	
		//调用
		JSONObject result = g_user.postJsonResp(Constant.OFW_CT_NOTICELOGIN);
		//验证
		assertNotNull(result);
	}
}
