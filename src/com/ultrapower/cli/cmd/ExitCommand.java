package com.ultrapower.cli.cmd;

import com.ultrapower.cli.exe.ExitExeHandler;
import com.ultrapower.cli.exe.ICommandExeHandler;
import com.ultrapower.cli.opt.BaseOptions;
import com.ultrapower.cli.opt.SimpleOptions;



public class ExitCommand extends BaseCommand {
	
	public ExitCommand(){
		this("exit", "ÃüÁîËµÃ÷£ºÍË³ö", new SimpleOptions(), new ExitExeHandler());
	}
	
	private ExitCommand(String cmdName, String cmdDescription, BaseOptions optsDef, ICommandExeHandler cmdHandle){
		super(cmdName, cmdDescription, optsDef, cmdHandle);
	}

}
