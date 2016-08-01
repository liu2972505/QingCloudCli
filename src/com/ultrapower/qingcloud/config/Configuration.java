package com.ultrapower.qingcloud.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


public class Configuration {
	private static Properties SYSTEM_CONFIG = new Properties();
	private static String config = null;
	private static String configPath = null;

	public static String fileName = "";
	public static List configPropertys = new ArrayList();
	
	private static String contextPath;

	public static String getContextPath() {
		return contextPath;
	}

	public static void setContextPath(String contextPath) {
		Configuration.contextPath = contextPath;
	}

	public static void init(String path) {
		try {
			if (path == null) {
				return;
			}
			
			configPropertys.add("vCenterUserName");
			configPropertys.add("vCenterPassword");
			
			InputStream inputStream = new FileInputStream(new File(path));
			SYSTEM_CONFIG.load(inputStream);

			fileName = "";
			int index = path.lastIndexOf("/") == -1 ? path.lastIndexOf("\\")
					: path.lastIndexOf("/");
			if (index > 0) {
				fileName = path.substring(index + 1);
			}
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return;
	}

	public static String getProperty(String key) {
		try {
			return SYSTEM_CONFIG.getProperty(key);
		} catch (Exception e) {
			return null;
		}
	}



	public static boolean updateProperty(String key, String value) {
		try {
			try {
				InputStream inputStream = null;
				ClassLoader classLoader = null;
				classLoader = Thread.currentThread().getContextClassLoader();
				inputStream = classLoader.getResourceAsStream(config);
				SYSTEM_CONFIG.load(inputStream);

				SYSTEM_CONFIG.setProperty(key, value);
				SYSTEM_CONFIG.store(new FileOutputStream(configPath),
						"config.properties");
				inputStream.close();
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}

			return true;
		} catch (Exception e) {
			return false;
		}
	}
}
