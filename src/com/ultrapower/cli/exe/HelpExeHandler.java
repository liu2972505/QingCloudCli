package com.ultrapower.cli.exe;

import java.util.Map;

import com.ultrapower.cli.WorldUtil;

public class HelpExeHandler implements ICommandExeHandler {

	public void exec(Map<String, String> paramMap) {
		System.out.println(WorldUtil.startWord);
	}

}
