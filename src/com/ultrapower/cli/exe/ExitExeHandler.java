package com.ultrapower.cli.exe;

import java.util.Map;

import com.ultrapower.cli.WorldUtil;

public class ExitExeHandler implements ICommandExeHandler {

	public void exec(Map<String, String> paramMap) {
		System.out.println(WorldUtil.endWord);
		System.exit(0);
	}

}
