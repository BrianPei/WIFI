package com.xunlei.wifi.test.scene;

import net.sf.json.JSONObject;

import com.xunlei.wifi.test.modules.model.User;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Reward_New {
	/**
	 * 获取用户奖金情况
	 * 
	 * @param user
	 * @return
	 */
	public static JSONObject getBonus(User user) {
		//入参数
		user.setHttpParam("dump", "reward.bonus");
		//调用方法
		JSONObject result = user.postJsonResp(Constant.REWARD_BONUS);
		//返回结果
		return result;
		
	}
	/*
	 * 获取奖励任务的配置，可以间隔较长的时间更新一次
	 * @param user
	 * @return
	 */
	public static JSONObject getconfig(User user){
		//入参数
		user.setHttpParam("dump", "reward.config");
		//调用方法
		JSONObject result = user.postJsonResp(Constant.REWARD_CONFIG);
		//返回结果
		return result;
	}
	/**
	 * 用户提现
	 * 
	 * @param user
	 * @param amount
	 * @return
	 */
	public static JSONObject performEncash(User user, int amount) {
		user.setHttpParam("amount", String.valueOf(amount));
		JSONObject result = user.postJsonResp(Constant.REWARD_ENCASH);
		return result;
	}
	/**
	 * 获取最新提现详情
	 * 	
	 * @param user
	 * @return
	 */
	public static JSONObject getLatestEncashDetail(User user) {
		user.setHttpParam("count", "10"); //每页显示条数
		user.setHttpParam("actionId", "0"); //分页最后id
		JSONObject result = user.postJsonResp(Constant.REWARD_ENCASHDETAIL);
		return result.getJSONArray("encashDetailList").getJSONObject(0);
	}
	/*
	 * 获取用户完成额外任务的情况
	 * @param user
	 * @return
	 * 
	 */
	public static JSONObject getlist(User user){
		user.setHttpParam("dump", "reward.list");
		JSONObject result = user.postJsonResp(Constant.REWARD_LIST);
		return result.getJSONArray("missionStatusList").getJSONObject(3);
	}
	/*
	 * 完成任务，获取奖金情况
	 * @
	 */
	public static JSONObject getsubmit(User user,int missionId){
		user.setHttpParam("missionId", String.valueOf(missionId));
		JSONObject result = user.postJsonResp(Constant.REWARD_SUBMIT);
		return result;
		
	}
}
