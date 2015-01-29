package com.xunlei.wifi.test.scene;


import com.xunlei.wifi.test.modules.utils.Constant;

import net.sf.json.JSONObject;
import com.xunlei.wifi.test.modules.model.User;


public class wifiinfo_New {
	/*
	 * 共享一个wifi获得0.5元奖励
	 * @param user
	 * @param bssids
	 * @param password
	 * @param type
	 * @param hasReward
	 * @param rewardType
	 * @return
	 * 
	 */
	public static JSONObject performSharewifi(User user,String bssids,String password,int type,String ssid,
			int hasReward,int rewardType){
		user.setHttpParam("bssids", bssids);
		user.setHttpParam("password", password);
		user.setHttpParam("type", String.valueOf(type));
		user.setHttpParam("ssid", ssid);
		user.setHttpParam("hasReward", String.valueOf(hasReward));
		user.setHttpParam("rewardType", String.valueOf(rewardType));		
		JSONObject result = user.getJsonResp(Constant.WIFIINFO_SHARE);
		return result;
	}
	/*
	 * 共享10个wifi，领取6元任务
	 * @param user
	 * @param missionID
	 * @return
	 */
	
	public static JSONObject preformExtra_reward(User user,int missionId){
		user.setHttpParam("missionId", String.valueOf(missionId));
		JSONObject result =user.getJsonResp(Constant.REWARD_SUBMIT);
		return result;
		
	}
	/*
	 * 激活奖励送0.5元
	 * @param user
	 * @param missionID
	 * @return
	 */
	public static JSONObject preformActive_reward(User user,int missionId){
		user.setHttpParam("missionId", String.valueOf(missionId));
		JSONObject result =user.getJsonResp(Constant.REWARD_SUBMIT);
		return result;
	}
	/*
	 * 发展下线提成奖励
	 * @param user
	 * @param missionID
	 * @return
	 * 
	 */
	public static JSONObject preform_reward_percentage(User user,int missionId){
		user.setHttpParam("missionId", String.valueOf(missionId));
		JSONObject result =user.getJsonResp(Constant.REWARD_SUBMIT);
		return result;
	}	
	/*
	 * 一级代理发展下线提成奖励
	 * @param user
	 * @param missionID
	 * @return
	 * 
	 */
	public static JSONObject preform_reward_partner_percentage(User user,int missionId){
		user.setHttpParam("missionId", String.valueOf(missionId));
		JSONObject result =user.getJsonResp(Constant.REWARD_SUBMIT);
		return result;
	}	
		
		
}
