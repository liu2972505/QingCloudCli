package com.ultrapower.cli.cmd;

import com.ultrapower.cli.exe.HelpExeHandler;
import com.ultrapower.cli.exe.ICommandExeHandler;
import com.ultrapower.cli.opt.BaseOptions;
import com.ultrapower.cli.opt.HelpOptions;


public class HelpCommand extends BaseCommand {
	
	public HelpCommand(){
		this("help", "∞Ô÷˙–≈œ¢", new HelpOptions(), new HelpExeHandler());
	}
	
	private HelpCommand(String cmdName, String cmdDescription, BaseOptions optsDef, ICommandExeHandler cmdHandle){
		super(cmdName, cmdDescription, optsDef, cmdHandle);
	}

}
