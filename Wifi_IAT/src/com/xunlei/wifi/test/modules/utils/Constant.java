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

	// 预置登录的主帐号
	public static String OPENID_TEST = "oGsKmswsHSifPDfcEdBu6i_bW9hM";
	public static String USERNAME_TEST = "aixiaoeye";
	public static String USERID_TEST = "220069";

	// ================================================================================

	// ===================================预发布环境帐号信息==================================

	// ================================================================================

	// ===================================LBS相关数据==================================

	// 中青经纬度和poiId
	public static String LON_XUNLEI = "116.460728";
	public static String LAT_XUNLEI = "39.929481";

	// ================================================================================

	// ===========================User模块接口名=======================================
	public static String USER_ACCOUNTLIST = "user.accountList";
	public static String USER_BINDTHIRD = "user.bindThird";
	public static String USER_COMMISION = "user.commision";
	public static String USER_INVITED = "user.invited";
	public static String USER_LOGINBYTHIRD = "user.loginByThird";
	public static String USER_REG = "user.reg";
	public static String USER_UNBINDTHIRD = "user.unbindThird";
	// ================================================================================
	
	// ===========================Wifiinfo模块接口名===================================
	public static String WIFIINFO_MINE = "wifiinfo.mine";
	// ================================================================================
}
