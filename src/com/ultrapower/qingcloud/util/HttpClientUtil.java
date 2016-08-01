package com.ultrapower.qingcloud.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.log4j.Logger;

import com.ultrapower.qingcloud.exception.HttpSendException;

public class HttpClientUtil {

	private static final Logger logger = Logger.getLogger(HttpClientUtil.class);

	
	public static String sendHttpRequest(String httpUrl)
			throws HttpSendException {
		// 创建HttpClient实例
		HttpClient httpclient = new DefaultHttpClient();

		// 创建Get方法实例
		HttpGet httpgets = new HttpGet(httpUrl);
		try {
			HttpResponse response = httpclient.execute(httpgets);
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				InputStream instreams = entity.getContent();
				String str = convertStreamToString(instreams);
				logger.info("response=" + str);
				httpgets.abort();
				return str;
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new HttpSendException("发送http请求出错！");
		}
		return "";
	}

	public static String convertStreamToString(InputStream is) throws HttpSendException{
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();

		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
			throw new HttpSendException("发送http请求出错！");
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
				throw new HttpSendException("发送http请求出错！");
			}
		}
		return sb.toString();
	}
}
