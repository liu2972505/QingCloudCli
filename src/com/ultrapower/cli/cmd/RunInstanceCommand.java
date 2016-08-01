package com.ultrapower.cli.cmd;

import com.ultrapower.cli.exe.ICommandExeHandler;
import com.ultrapower.cli.exe.RunInstanceExeHandler;
import com.ultrapower.cli.opt.BaseOptions;
import com.ultrapower.cli.opt.RunInstanceOptions;


public class RunInstanceCommand extends BaseCommand {
	
	public RunInstanceCommand(){
		this("run-instances", "����˵������������", new RunInstanceOptions(), new RunInstanceExeHandler());
	}
	
	private RunInstanceCommand(String cmdName, String cmdDescription, BaseOptions optsDef, ICommandExeHandler cmdHandle){
		super(cmdName, cmdDescription, optsDef, cmdHandle);
	}

}
