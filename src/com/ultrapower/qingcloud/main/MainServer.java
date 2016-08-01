package com.ultrapower.qingcloud.main;

import java.text.ParseException;

import org.apache.log4j.Logger;

import com.ultrapower.qingcloud.config.Configuration;


public class MainServer {
	private static final Logger logger = Logger.getLogger(MainServer.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		logger.info("# QingCloud cli Starting...");
		Configuration conf = new Configuration();
		conf.init("conf/config.properties");
		logger.info("# Configuration init success");
		String qy_access_key_id = (String) conf.getProperty("qy_access_key_id");
		String qy_secret_access_key = (String) conf.getProperty("qy_secret_access_key");
		String qy_api_url = (String)conf.getProperty("qy_api_url");
		logger.info("# qy_access_key_id = "+ qy_access_key_id);
		logger.info("# qy_secret_access_key = "+ qy_secret_access_key);
		logger.info("# qy_api_url = "+qy_api_url);
		logger.info("# QingCloud cli Starting Start Success.");
	}

}
