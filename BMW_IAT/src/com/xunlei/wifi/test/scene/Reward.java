package com.xunlei.wifi.test.scene;

import net.sf.json.JSONObject;

import com.xunlei.wifi.test.modules.model.User;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Reward {
	/**
	 * 获取用户奖金情况
	 * 
	 * @param user
	 * @return
	 */
	public static JSONObject getBonus(User user) {
		user.setHttpParam("dump", "reward.bonus");
		JSONObject result = user.postJsonResp(Constant.REWARD_BONUS);
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
		user.setHttpParam("count", "1");
		user.setHttpParam("actionId", "0");
		JSONObject result = user.postJsonResp(Constant.REWARD_ENCASHDETAIL);
		return result.getJSONArray("encashDetailList").getJSONObject(0);
	}
	/*
	 *  获取用户完成任务的情况
	 *  @param user
	 *  @return 
	 */
	public static JSONObject getlist(User user){
		user.setHttpParam("dump", "reward.list");
		JSONObject result =user.postJsonResp(Constant.REWARD_LIST);
		return result.getJSONArray("missionStatusList").getJSONObject(0);
		
	}
}
