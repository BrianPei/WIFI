package com.xunlei.wifi.test.scene;


import net.sf.json.JSONObject;

import com.xunlei.wifi.test.modules.base.BaseCase;
import com.xunlei.wifi.test.modules.utils.Constant;
import com.xunlei.wifi.test.modules.model.User;

public class config_New extends BaseCase{

	/*
	 * 获得通用配置信息
	 * @param user
	 * @param return
	 * 
	 */
	public static JSONObject getconfig(User user){
		
		JSONObject result = user.getJsonResp(Constant.CONFIG_CONFIG);
		return result;
	} 
}
