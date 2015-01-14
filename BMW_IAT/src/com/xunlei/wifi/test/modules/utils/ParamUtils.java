package com.xunlei.wifi.test.modules.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.*;

/**
 * 处理接口调用参数
 * 
 * @author peiyu
 * 
 */
public class ParamUtils {

	/**
	 * 参数序列化
	 * 
	 * @param map
	 * @return
	 */
	public static String map2Str(Map<String, String> map) {
		StringBuilder sb = new StringBuilder();
		for (String key : map.keySet()) {
			sb.append(key);
			sb.append("=");
			try {
				sb.append(URLEncoder.encode(map.get(key), "UTF-8"));
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			sb.append("&");
		}
		if (!map.isEmpty())
			sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	/**
	 * 从第三方平台换token
	 * 
	 * @param username
	 * @param passWd
	 * @return
	 */
	// public static JSONObject getThirdTicket(String username, String password,
	// String postUrl) {
	// Map<String, String> param = new HashMap<String, String>();
	// JSONObject json = new JSONObject();
	//
	// param.put("grant_type", "password");
	// param.put("username", username);
	// param.put("password", DigestUtils.md5Hex(password));
	// param.put("password_type", "md5");
	//
	// try {
	// HttpClient client = new HttpClient();
	// client.setEncode("UTF-8");
	// HttpResponse response;
	// response = client.Post(postUrl, ParamUtils.map2Str(param));
	// String resp = response.Body();
	// System.out.println(resp);
	// json = JSONObject.fromObject(resp);
	//
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// return json;
	// }

	/**
	 * 将url和接口名拼成请求地址
	 * 
	 * @param sUrl
	 * @param apiName
	 * @return
	 */
	public static String GetPostUrl(String sUrl, String apiName) {
		if (!sUrl.endsWith("/")) {
			sUrl += "/";
		}
		String urlEnd = apiName.replace('.', '/');
		String resultString = sUrl + urlEnd;
		return resultString;
	}
}
