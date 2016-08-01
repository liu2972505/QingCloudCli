package com.ultrapower.qingcloud.driver;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSON;
import com.ultrapower.qingcloud.domain.ResultMessage;
import com.ultrapower.qingcloud.exception.ParamFormatException;
import com.ultrapower.qingcloud.util.HttpClientUtil;
import com.ultrapower.qingcloud.util.UrlFormatUtil;

public class QyInstances {
	private static final Logger logger = Logger.getLogger(QyInstances.class);
	
	public String describeInstances(String param) {
		logger.info("describeInstances start");
		String result = null;
		String errorMsg = "查询主机出错!";
		ResultMessage message = new ResultMessage();
		try {
			String url = UrlFormatUtil.formatUrl(param,"DescribeInstances");
			result = HttpClientUtil.sendHttpRequest(url);
		} catch (ParamFormatException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			message.setMessage(errorMsg + e.getMessage());
			message.setRet_code("1100");
			return JSON.toJSONString(message);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			message.setMessage(errorMsg + e.getMessage());
			message.setRet_code("5000");
			return JSON.toJSONString(message);
		}
		logger.info("describeInstances end");
		return result;
	}
	
	public String runInstances(String param){
		logger.info("runInstances start");
		String result = null;
		String errorMsg = "添加主机出错!";
		ResultMessage message = new ResultMessage();
		try {
			String url = UrlFormatUtil.formatUrl(param,"RunInstances");
			result = HttpClientUtil.sendHttpRequest(url);
		} catch (ParamFormatException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			message.setMessage(errorMsg + e.getMessage());
			message.setRet_code("1100");
			return JSON.toJSONString(message);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			message.setMessage(errorMsg + e.getMessage());
			message.setRet_code("5000");
			return JSON.toJSONString(message);
		}
		
		logger.info("runInstances end");
		return result;
	}
	
	public String terminateInstances(String param) {
		logger.info("runInstances start");
		String result = null;
		String errorMsg = "删除主机出错!";
		ResultMessage message = new ResultMessage();
		try {
			String url = UrlFormatUtil.formatUrl(param, "TerminateInstances");
			result = HttpClientUtil.sendHttpRequest(url);
		} catch (ParamFormatException e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			message.setMessage(errorMsg + e.getMessage());
			message.setRet_code("1100");
			return JSON.toJSONString(message);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
			message.setMessage(errorMsg + e.getMessage());
			message.setRet_code("5000");
			return JSON.toJSONString(message);
		}

		logger.info("runInstances end");
		return result;
	}
	
}
