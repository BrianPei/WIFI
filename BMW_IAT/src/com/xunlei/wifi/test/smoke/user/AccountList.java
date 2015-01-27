package com.xunlei.wifi.test.smoke.user;

import static org.junit.Assert.assertNotNull;
import net.sf.json.JSONObject;

import org.junit.Test;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;

public class AccountList extends BaseCase {
	@Test(summary = "获取当前用户绑定的第三方帐号列表", expectedResults = "获取成功", index = 1)
	public void testAccountList() {
		JSONObject result = g_user.getJsonResp(Constant.USER_ACCOUNTLIST);
		assertNotNull(result);
	}
}
