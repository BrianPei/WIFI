package com.xunlei.wifi.test.scene;

import net.sf.json.JSONObject;
import com.xunlei.wifi.test.modules.model.User;
import com.xunlei.wifi.test.modules.utils.Constant;

public class Ofw {
	/*
	 * 卡余额不足时、获取ChinaNet时长卡
	 */
	public static JSONObject getCard_changecard(User user) {
		user.setHttpParam("status", "1");		
		JSONObject result = user.postJsonResp(Constant.OFW_CT_GETCARD);
		return result;
	}
	/*
	 * 初次申请卡获取ChinaNet时长卡
	 */
	public static JSONObject getCard_Newcard(User user) {
		user.setHttpParam("status", "0");		
		JSONObject result = user.postJsonResp(Constant.OFW_CT_GETCARD);
		return result;
	}
	/*
	 * 用户使用时长卡登录上网后，客户端通知服务端登陆状态
	 */
	public static JSONObject noticeLogin(User user ,String userId,String cardId) {
		user.setHttpParam("userId", String.valueOf(userId));	
		user.setHttpParam("cardId", String.valueOf(cardId));
		JSONObject result = user.postJsonResp(Constant.OFW_CT_NOTICELOGIN);
		return result;
	}
	/*
	 *  用户正常登出，或者申请后一段时间没有使用该卡，或者异常情况下断网了，客户端重新连上网后，通知服务端登状态
	 */
	public static JSONObject noticeLogout(User user ,String userId,String cardId) {
		user.setHttpParam("userId", String.valueOf(userId));	
		user.setHttpParam("cardId", String.valueOf(cardId));
		JSONObject result = user.postJsonResp(Constant.OFW_CT_NOTICELOGOUT);
		return result;
	}
	/*
	 * 获取用户CMCC时长
	 * 
	 */
	public static JSONObject getbalance(User user) {
		JSONObject result = user.postJsonResp(Constant.OFW_CMCC_BALANCE);
		return result;
	}
	/*
	 * 进行CMCC登录
	 * 
	 */
	public static JSONObject performLogin(User user,long sessionId,int duration) {
		user.setHttpParam("sessionId", String.valueOf(sessionId));
		user.setHttpParam("duration", String.valueOf(duration));
		JSONObject result = user.postJsonResp(Constant.OFW_CMCC_LOGIN);
		return result;
	}
	/*
	 * 客户端通知CMCC登出
	 * 
	 */
	public static JSONObject performLogout(User user,long sessionId,int duration) {
		user.setHttpParam("sessionId", String.valueOf(sessionId));
		user.setHttpParam("duration", String.valueOf(duration));
		JSONObject result = user.postJsonResp(Constant.OFW_CMCC_LOGOUT);
		return result;
	}
	/*
	 *  客户端尝试获取CMCC时长
	 * 
	 */
	public static JSONObject tryRecharge(User user) {
		JSONObject result = user.postJsonResp(Constant.OFW_CMCC_TRYRECHARGE);
		return result;
	}
}
