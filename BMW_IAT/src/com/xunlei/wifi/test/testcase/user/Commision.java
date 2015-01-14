package com.xunlei.wifi.test.testcase.user;

import static org.junit.Assert.*;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Commision extends BaseCase {
	@Test(summary = "获取当前用户提成列表", expectedResults = "获取成功", index = 1)
	public void testCommision() {
		JSONObject result = g_user.getJsonResp(Constant.USER_COMMISION);
		assertNotNull(result);
	}
}
