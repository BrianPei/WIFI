package com.xunlei.wifi.test.smoke.push;

import net.sf.json.JSONObject;
import static org.junit.Assert.*;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class binding extends BaseCase{
	@Test(summary = "设备绑定小米", expectedResults = "绑定成功", index = 1)
	public void testbinding() {
		g_user.setHttpParam("regId", "123456");//暂时没有regId
		JSONObject result = g_user.getJsonResp(Constant.PUSH_BINDING);
		//设备绑定小米成功
		assertNotNull(result);
	}
}
