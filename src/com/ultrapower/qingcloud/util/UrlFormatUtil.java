package com.ultrapower.qingcloud.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.ultrapower.qingcloud.config.Configuration;
import com.ultrapower.qingcloud.exception.ParamFormatException;

public class UrlFormatUtil {

	private static final Logger logger = Logger.getLogger(UrlFormatUtil.class);

	public static String formatUrl(String param, String action)
			throws ParamFormatException {
		// 请求URL
		StringBuffer strApiUrl = new StringBuffer();
		try {
			String qy_access_key_id = (String) Configuration
					.getProperty("qy_access_key_id");
			String qy_secret_access_key = (String) Configuration
					.getProperty("qy_secret_access_key");
			String qy_api_url = (String) Configuration
					.getProperty("qy_api_url");
			String qy_api_uri = (String) Configuration
					.getProperty("qy_api_uri");

			// 根据API地址、param拼装请求URL
			if (StrUtil.isNullStr(qy_access_key_id)) {
				throw new  ParamFormatException("请在配置文件config.properties中设置API密钥IDaccess_key_id");
			}

			if (StrUtil.isNullStr(qy_secret_access_key)) {
				throw new  ParamFormatException("请在配置文件config.properties中设置API密钥的私钥qy_secret_access_key");
			}

			if (StrUtil.isNullStr(qy_api_url)) {
				throw new  ParamFormatException("请在配置文件config.properties中设置青云API地址qy_api_url，默认为 https://api.qingcloud.com/iaas/");
			}

			if (StrUtil.isNullStr(qy_api_uri)) {
				throw new  ParamFormatException("请在配置文件config.properties中设置青云请求的uri路径，默认为 /iaas/");
			}
			logger.info(param);
			Map<String, Object> map = (Map<String, Object>) JSON.parse(param);
			// 生成请求时间
			SimpleDateFormat sdf = new SimpleDateFormat(
					"yyyy-MM-dd'T'HH:mm:ss'Z'");
			String sDate = sdf.format(new Date());
			map.put("action", action);
			map.put("time_stamp", sDate);
			map.put("access_key_id", qy_access_key_id);
			map.put("signature_version", "1");
			map.put("signature_method", "HmacSHA256");
			map.put("version", "1");

			Map<String, Object> resultMap = sortMapByKey(map);

			// 签名串
			StringBuffer strSignature = new StringBuffer();
			strSignature.append("GET\n").append(qy_api_uri).append("\n");

			int i = 0;
			try {
				for (String key : resultMap.keySet()) {
					if (i == 0) {
						strSignature.append(getUrlEncoder(key) + "="
								+ getUrlEncoder(map.get(key).toString()));
						strApiUrl.append(qy_api_url + "?" + getUrlEncoder(key)
								+ "=" + getUrlEncoder(map.get(key).toString()));
					} else {
						strSignature.append("&" + getUrlEncoder(key) + "="
								+ getUrlEncoder(map.get(key).toString()));
						strApiUrl.append("&" + getUrlEncoder(key) + "="
								+ getUrlEncoder(map.get(key).toString()));
					}
					i++;
				}
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
				throw new ParamFormatException("参数错误！");
			}
			logger.info("签名串:" + strSignature.toString());
			logger.info("秘钥:" + qy_secret_access_key);
			String result = EncryUtil.sha256Encode(strSignature.toString(),
					qy_secret_access_key);
			strApiUrl.append("&" + "signature=" + result);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ParamFormatException("参数错误！");
		}

		logger.info("实际URL:" + strApiUrl.toString());

		return strApiUrl.toString();
	}

	/**
	 * 使用 Map按key进行排序
	 * 
	 * @param map
	 * @return
	 */
	public static Map<String, Object> sortMapByKey(Map<String, Object> map) {
		if (map == null || map.isEmpty()) {
			return null;
		}
		Map<String, Object> sortMap = new TreeMap<String, Object>(
				new MapKeyComparator());
		sortMap.putAll(map);
		return sortMap;
	}
	
	private static String getUrlEncoder(String param) throws UnsupportedEncodingException {
		return URLEncoder.encode(param, "UTF-8");
	}
}
