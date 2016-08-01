package com.ultrapower.qingcloud.util;

import java.net.URLEncoder;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;


public class EncryUtil {

	private static final Logger logger = Logger.getLogger(EncryUtil.class);
    /**
	 * 将摘要信息转换成HMC-SHA256编码
	 * 
	 * @param message
	 *            摘要信息
	 * @param key
	 *            密钥
	 * @return SHA-256编码之后的字符串
	 */
	public static String sha256Encode(String message, String key) {
		try {
			Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
			SecretKeySpec secret_key = new SecretKeySpec(key.getBytes(),
					"HmacSHA256");
			sha256_HMAC.init(secret_key);

			String hash = Base64.encodeBase64String(sha256_HMAC.doFinal(message
					.getBytes()));
			String url = URLEncoder.encode(hash, "UTF-8");
			return url;
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("HMC-SHA256编码出错！");
		}
		return "";
	}
	
	public static void main(String[] args) {
		String string_to_sign = "GET\n/iaas/\naccess_key_id=QYACCESSKEYIDEXAMPLE&action=RunInstances&count=1&image_id=centos64x86a&instance_name=demo&instance_type=small_b&login_mode=passwd&login_passwd=QingCloud20130712&signature_method=HmacSHA256&signature_version=1&time_stamp=2013-08-27T14%3A30%3A10Z&version=1&vxnets.1=vxnet-0&zone=pek1";
		String secret_access_key = "SECRETACCESSKEY";
		String result = sha256Encode(string_to_sign,secret_access_key);
		System.out.println(result);
	}
}
