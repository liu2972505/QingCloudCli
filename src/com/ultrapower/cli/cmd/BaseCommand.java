package com.ultrapower.cli.cmd;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.ParseException;

import com.ultrapower.cli.exe.ICommandExeHandler;
import com.ultrapower.cli.opt.BaseOptions;


public abstract class BaseCommand {
	
	private String cmdName = null;
	
	private String cmdDescription = null;
	
	private BaseOptions optsDef = null;
	
	private ICommandExeHandler cmdHandler = null;
	
	public BaseCommand(){}
	
	public BaseCommand(String cmdName, String cmdDescription, BaseOptions optsDef, ICommandExeHandler cmdHandle){
		this.cmdName = cmdName;
		this.optsDef = optsDef;
		this.cmdHandler = cmdHandle;
		this.cmdDescription = cmdDescription;
	}

	public String getCmdName() {
		return cmdName;
	}

	public BaseOptions getOptsDef() {
		return optsDef;
	}

	public ICommandExeHandler getCmdHandler() {
		return cmdHandler;
	}
	
	public void printHelp(){
		optsDef.printHelp(cmdName, cmdDescription);
	}
	
	public Map<String, String> parser(String[] args){
		try {
			CommandLine cmd = optsDef.parser(args);
			if(cmd == null){
				return null;
			}

			Map<String, String> optMap = new HashMap<String, String>();
			Option[] opts = cmd.getOptions();
			for(Option opt : opts){
				optMap.put(opt.getOpt(), opt.getValue());
			}
			return optMap;
		} catch (ParseException e) {
			System.out.println("√¸¡Ó”Ô∑®¥ÌŒÛ£∫ " + e.getMessage());
			printHelp();
			return null;
		}
	} 
	
	public void exec( Map<String, String> optMap){
		cmdHandler.exec(optMap);
	}
	
}
