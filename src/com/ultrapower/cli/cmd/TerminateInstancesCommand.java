package com.ultrapower.cli.cmd;

import com.ultrapower.cli.exe.ICommandExeHandler;
import com.ultrapower.cli.exe.TerminateInstancesExeHandler;
import com.ultrapower.cli.opt.BaseOptions;
import com.ultrapower.cli.opt.TerminateInstancesOptions;



public class TerminateInstancesCommand extends BaseCommand {
	
	public TerminateInstancesCommand(){
		this("terminate-instances", "命令说明：销毁主机", new TerminateInstancesOptions(), new TerminateInstancesExeHandler());
	}
	
	private TerminateInstancesCommand(String cmdName, String cmdDescription, BaseOptions optsDef, ICommandExeHandler cmdHandle){
		super(cmdName, cmdDescription, optsDef, cmdHandle);
	}

}
