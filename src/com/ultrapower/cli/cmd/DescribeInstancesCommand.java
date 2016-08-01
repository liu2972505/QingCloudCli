package com.ultrapower.cli.cmd;

import com.ultrapower.cli.exe.DescribeInstancesExeHandler;
import com.ultrapower.cli.exe.ICommandExeHandler;
import com.ultrapower.cli.opt.BaseOptions;
import com.ultrapower.cli.opt.DescribeInstancesOptions;



public class DescribeInstancesCommand extends BaseCommand {
	
	public DescribeInstancesCommand(){
		this("describe-instances", "命令说明：获取主机列表", new DescribeInstancesOptions(), new DescribeInstancesExeHandler());
	}
	
	private DescribeInstancesCommand(String cmdName, String cmdDescription, BaseOptions optsDef, ICommandExeHandler cmdHandle){
		super(cmdName, cmdDescription, optsDef, cmdHandle);
	}

}
