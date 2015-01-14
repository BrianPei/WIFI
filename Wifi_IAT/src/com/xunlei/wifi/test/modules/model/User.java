package com.xunlei.wifi.test.modules.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.HashSet;
import java.net.MalformedURLException;

import net.sf.json.JSONObject;

import org.apache.commons.codec.digest.DigestUtils;

import com.xunlei.wifi.test.modules.utils.Configuration;
import com.xunlei.wifi.test.modules.utils.Constant;
import com.xunlei.wifi.test.modules.utils.NewHttpTools;
import com.xunlei.wifi.test.modules.utils.ParamUtils;

/**
 * 
 * @author peiyu
 * 
 */
public class User {
	private String userId;
	private String avatar;
	private String token;
	private String user_post_url;
	public Map<String, String> http_param;

	public static final String appSecretKey = "7ygv6tfc";
	private String loginSecretKey;

	private String platform = Configuration.loadProperties().getProperty(
			"environment");

	public void setHttpParam(String key, String value) {
		http_param.put(key, value);
	}

	public String getHttpParam(String key) {
		return http_param.get(key);
	}

	public String getToken() {
		return this.token;
	}

	public String getUid() {
		return this.userId;
	}

	public String getHeadUrl() {
		return this.avatar;
	}

	public void setUserPostUrl(String user_post_url) {
		this.user_post_url = user_post_url;
	}

	public String getUserPostUrl() {
		return this.user_post_url;
	}

	public String getPlatform() {
		return this.platform;
	}

	public User() {
		http_param = new HashMap<String, String>();
		switch (platform) {
		case "test":
			user_post_url = Constant.TEST_URL;
			break;
		case "pre":
			user_post_url = Constant.PRE_URL;
			break;
		default:
			user_post_url = Constant.ONLINE_URL;
			break;
		}
	}

	public User(String openId, String userName) {
		http_param = new HashMap<String, String>();
		switch (platform) {
		case "test":
			user_post_url = Constant.TEST_URL;
			break;
		case "pre":
			user_post_url = Constant.PRE_URL;
			break;
		default:
			user_post_url = Constant.ONLINE_URL;
			break;
		}
		login(openId, userName);
	}

	/**
	 * 用于get方式调用接口
	 * 
	 * @param api
	 *            调用的方法名
	 * @return 方法返回的json串
	 */
	public JSONObject getJsonResp(String api) {
		http_param.put("appId", Constant.APP_ID);
		http_param.put("v", Constant.VERSION);
		http_param.put("callId", String.valueOf(new Date().getTime()));
		http_param.put("clientInfo", Constant.CLIENTINFO);
		if (this.token != null) {
			http_param.put("t", this.token);
		}
		String sig = sig(http_param);
		http_param.put("sig", sig);
		paramsPrint(http_param);

		String params = ParamUtils.map2Str(http_param);
		System.out.println("参数序列：" + params);

		JSONObject resultObject = NewHttpTools.SendGetRequest(
				ParamUtils.GetPostUrl(user_post_url, api), params);
		http_param.clear();
		return resultObject;
	}

	/**
	 * 用于post方式调用接口
	 * 
	 * @param api
	 *            调用的方法名
	 * @return 方法返回的json串
	 */
	public JSONObject postJsonResp(String api) {
		http_param.put("appId", Constant.APP_ID);
		http_param.put("v", Constant.VERSION);
		http_param.put("callId", String.valueOf(new Date().getTime()));
		http_param.put("clientInfo", Constant.CLIENTINFO);
		if (this.token != null) {
			http_param.put("t", this.token);
		}
		String sig = sig(http_param);
		http_param.put("sig", sig);
		paramsPrint(http_param);

		System.out.println("参数序列：" + ParamUtils.map2Str(http_param));

		JSONObject resultObject = NewHttpTools.SendPostRequest(
				ParamUtils.GetPostUrl(user_post_url, api), http_param);
		http_param.clear();
		return resultObject;
	}

	/**
	 * multipart方式上传文件
	 * 
	 * @param api
	 *            调用的方法名
	 * @param FileMaps
	 *            上传的文件名和multipart参数名
	 * @return 方法返回的json串
	 * @throws MalformedURLException
	 */
	public JSONObject getJsonRespWithMulti(String api, String filePath)
			throws MalformedURLException {
		http_param.put("appId", Constant.APP_ID);
		http_param.put("v", Constant.VERSION);
		http_param.put("callId", String.valueOf(new Date().getTime()));
		http_param.put("clientInfo", Constant.CLIENTINFO);
		if (this.token != null) {
			http_param.put("t", this.token);
		}
		String sig = sig(http_param);
		http_param.put("sig", sig);
		paramsPrint(http_param);
		System.out.println("上传服务地址：" + api);
		JSONObject result = NewHttpTools.SendMultiRequest(api, http_param,
				filePath);
		http_param.clear();
		return result;
	}

	/**
	 * 登录时使用的方法
	 * 
	 * @param http_param1
	 * @param api
	 * @return
	 */
	private JSONObject getJsonResp(Map<String, String> http_param1, String api) {
		paramsPrint(http_param1);
		JSONObject result = NewHttpTools.SendPostRequest(
				ParamUtils.GetPostUrl(user_post_url, api), http_param1);
		http_param.clear();
		return result;
	}

	/**
	 * 直接登录接口
	 * 
	 * @param openId
	 * @param userName
	 */
	public void login(String openId, String userName) {
		Map<String, String> param = new HashMap<String, String>();
		JSONObject jsonObject;
		param.put("extUserId", openId);
		param.put("extUserName", userName);
		param.put("platform", "weixin");
		param.put("appId", Constant.APP_ID);
		param.put("v", Constant.VERSION);
		param.put("callId", String.valueOf(new Date().getTime()));
		param.put("clientInfo", Constant.CLIENTINFO);
		String sig = sig(param);
		param.put("sig", sig);

		jsonObject = getJsonResp(param, Constant.USER_LOGINBYTHIRD);

		this.userId = jsonObject.getString("userId");
		this.token = jsonObject.getString("t");
		this.loginSecretKey = jsonObject.getString("userSecretKey");
		System.out.println(this.userId + "成功登录");
	}

	/**
	 * 计算签名
	 * 
	 * @param map
	 * @return
	 */
	private final String sig(Map<String, String> map) {
		String sig = null;

		List<String> paramKeys = new ArrayList<String>(map.keySet());
		Collections.sort(paramKeys, new Comparator<String>() {

			@Override
			public int compare(String lhs, String rhs) {
				return lhs.compareTo(rhs);
			}

		});

		StringBuilder sb = new StringBuilder();
		for (String key : paramKeys) {
			sb.append(key).append("=").append(map.get(key));
		}

		if (this.loginSecretKey == null) {
			sig = DigestUtils.md5Hex(sb.append(appSecretKey).toString());
		} else {
			sig = DigestUtils.md5Hex(sb.append(appSecretKey)
					.append(this.loginSecretKey).toString());
		}
		return sig;
	}

	/**
	 * 打印参数
	 * 
	 * @param paramsMap
	 */
	private void paramsPrint(Map<String, String> paramsMap) {
		Set<String> paramsSet = new HashSet<String>();
		paramsSet = paramsMap.keySet();
		for (String key : paramsSet) {
			System.err.print(key + "=");
			System.err.print(paramsMap.get(key) + "  ");
		}
		System.err.println();
	}
}
