package com.xunlei.wifi.test.scene;

import net.sf.json.JSONObject;
import com.xunlei.wifi.test.modules.model.User;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Ofw {
	public static JSONObject getCard(User user) {
		user.setHttpParam("status", "1");		
		JSONObject result = user.postJsonResp(Constant.OFW_CT_GETCARD);
		return result;
	}
}
