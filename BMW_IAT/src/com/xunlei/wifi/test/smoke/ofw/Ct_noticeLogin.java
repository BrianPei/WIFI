package com.xunlei.wifi.test.smoke.ofw;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;
import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;
import com.xunlei.wifi.test.scene.Ofw;

public class Ct_noticeLogin extends BaseCase{
	@Test(summary = "用户使用时长卡登陆上网后，客户端通知服务端该状态", expectedResults = "服务端成功收到状态", index = 1)
	public void test_Ct_noticeLogin1() {
		String userId=Ofw.getCard(g_user).getString("userId");
		g_user.setHttpParam("userId",userId);	
		//调用
		JSONObject result = g_user.postJsonResp(Constant.OFW_CT_NOTICELOGIN);
		//验证,0是服务端成功收到状态，-1是服务端没有收到状态
		assertEquals(result.getInt("result"),-1);
	}
}
