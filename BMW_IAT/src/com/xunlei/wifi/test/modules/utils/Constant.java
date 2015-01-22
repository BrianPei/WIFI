package com.xunlei.wifi.test.modules.utils;

/**
 * 
 * @author peiyu
 * 
 */
public class Constant {
	// ===================================平台级参数==================================
	public static String TEST_URL = "http://twin13a087vm5.sandai.net/api/";
	public static String PRE_URL = "https://sslquery-wifibee.xunlei.com/api/test";
	public static String ONLINE_URL = "https://sslquery-wifibee.xunlei.com/api/";

	public static String APP_ID = "1";
	public static String VERSION = "1.0";
	public static String GZ = "compression";
	// encode后的clientInfo，原文为{"model":"HM NOTE 1TD","version":"2.6.1","os":"4.2.2","screen":"1280*720","from":"UMENG_CHANNEL_VALUE","uniqid":"864375022142948","mac":"d4:97:0b:6a:cf:1d"}
	public static String CLIENTINFO = "{\"model\":\"HM NOTE 1TD\",\"version\":\"2.6.1\",\"os\":\"4.2.2\",\"screen\":\"1280*720\",\"from\":\"UMENG_CHANNEL_VALUE\",\"uniqid\":\"864375022142948\",\"mac\":\"d4:97:0b:6a:cf:1d\"}";
	// ===============================================================================

	// ===================================测试环境帐号信息==================================

	// 预置登录的主帐号（微信）
	public static String OPENID_TEST = "oGsKms0G_IG6cvXk0sKje9sP89XU";
	public static String USERNAME_TEST = "青青的小树";
	public static String USERID_TEST = "220062";

	// 已注册的QQ帐号
	public static String OPENID_QQ_TEST = "8C9F18F0F0301568472F943123C396CD";
	public static String USERNAME_QQ_TEST = "下雨天";
	public static String USERID_QQ_TEST = "220112";

	// 测试绑定用的QQ帐号
	public static String OPENID_QQ_TEST2 = "1EDA5014E930971855AA9B50B4D2C46C";
	public static String USERNAME_QQ_TEST2 = "猪熏熏";

	// 测试绑定用的微信帐号
	public static String OPENID_TEST2 = "oGsKmsxhJXLHWF1ZfXmgELZ6np90";
	public static String USERNAME_TEST2 = "裴二煜";

	// ================================================================================

	// ===================================预发布环境帐号信息================================

	// 预置登录的主帐号（微信）
	public static String OPENID_PRE = "oGsKms0G_IG6cvXk0sKje9sP89XU";
	public static String USERNAME_PRE = "青青的小树";

	// ================================================================================

	// ===================================线上环境帐号信息==================================

	// 预置登录的主帐号（微信）
	public static String OPENID_ONLINE = "oGsKms0G_IG6cvXk0sKje9sP89XU";
	public static String USERNAME_ONLINE = "青青的小树";

	// ================================================================================

	// ===================================LBS相关数据==================================

	// 中青经纬度和poiId
	public static String LON_XUNLEI = "116.460728";
	public static String LAT_XUNLEI = "39.929481";

	// ================================================================================

	// ===========================User模块接口名=======================================
	public static String USER_ACCOUNTLIST = "user.accountList";
	public static String USER_BIND = "user.bind";
	public static String USER_COMMISION = "user.commision";
	public static String USER_INVITED = "user.invited";
	public static String USER_LOGINBYTHIRD = "user.loginByThird";
	public static String USER_REG = "user.reg";
	public static String USER_UNBIND = "user.unbind";
	// ================================================================================

	// ===========================Reward模块接口名=======================================
	public static String REWARD_BONUS = "reward.bonus";
	public static String REWARD_CONFIG = "reward.config";
	public static String REWARD_ENCASH = "reward.encash";
	public static String REWARD_ENCASHDETAIL = "reward.encashDetail";
	public static String REWARD_LIST = "reward.list";
	public static String REWARD_SUBMIT = "reward.submit";
	// ================================================================================

	// ===========================Config模块接口名===================================
	public static String CONFIG_CONFIG = "config.config";
	public static String CONFIG_SHARECONFIG = "config.shareConfig";
	// ================================================================================

	// ===========================Wifiinfo模块接口名===================================
	public static String WIFIINFO_ACCEPTINVIT = "wifiinfo.acceptInvit";
	public static String WIFIINFO_CHECKSHARELIST = "wifiinfo.checkShareList";
	public static String WIFIINFO_COLLECT = "wifiinfo.collect";
	public static String WIFIINFO_CREATECSV = "wifiinfo.createCsv";
	public static String WIFIINFO_DUMPPWD = "wifiinfo.dumpPwd";
	public static String WIFIINFO_INVITCODE = "wifiinfo.invitCode";
	public static String WIFIINFO_MINE = "wifiinfo.mine";
	public static String WIFIINFO_NEARBY = "wifiinfo.nearby";
	public static String WIFIINFO_QUERY = "wifiinfo.query";
	public static String WIFIINFO_SHARE = "wifiinfo.share";
	public static String WIFIINFO_SHARECOUNT = "wifiinfo.shareCount";
	public static String WIFIINFO_UPDATEDICT = "wifiinfo.updateDict";
	// ================================================================================

	// ===========================Ofw模块接口名=======================================
	public static String OFW_CMCC_BALANCE = "ofw.cmcc.balance";
	public static String OFW_CMCC_LOGIN = "ofw.cmcc.login";
	public static String OFW_CMCC_LOGOUT = "ofw.cmcc.logout";
	public static String OFW_CMCC_TRYRECHARGE = "ofw.cmcc.tryRecharge";
	public static String OFW_CT_GETCARD = "ofw.ct.getCard";
	public static String OFW_CT_NOTICELOGIN = "ofw.ct.noticeLogin";
	public static String OFW_CT_NOTICELOGOUT = "ofw.ct.noticeLogout";
	// ================================================================================

	// ===========================Wall模块接口名===================================
	public static String WALL_DOMOB = "wall.domob";
	public static String WALL_MUMAYI = "wall.mumayi";
	// ================================================================================
}
