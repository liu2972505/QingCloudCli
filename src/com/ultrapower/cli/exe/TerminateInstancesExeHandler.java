package com.ultrapower.cli.exe;

import java.util.Map;

import com.ultrapower.qingcloud.driver.QyInstances;
import com.ultrapower.qingcloud.util.StrUtil;

public class TerminateInstancesExeHandler implements ICommandExeHandler {

public void exec(Map<String, String> paramMap) {
		
		String mark = "instances";
		StringBuffer param = new StringBuffer();
		param.append("{");
		if(paramMap != null){
			int i = 0;
			for(String key : paramMap.keySet()){
		    	if(i==0){
		    		param.append(StrUtil.getParamValue(key,paramMap.get(key),mark));
		    	}else{
		    		param.append(","+StrUtil.getParamValue(key,paramMap.get(key),mark));
		    	}
		    	i++;
		    }
		}
		param.append("}");
		QyInstances instances = new QyInstances();
		String result = instances.terminateInstances(param.toString());
		System.out.println(result);
	}

}
