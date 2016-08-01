package com.ultrapower.cli.opt;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

public abstract class BaseOptions {

	private Options opts = new Options();
	
	private HelpFormatter formatter = new HelpFormatter();
	
	private CommandLineParser parser = new DefaultParser();
	
	private String cliDescriptionFooter = "QingCloud API: https://docs.qingcloud.com/api/index.html";
	
	public BaseOptions(){
		// 添加操作符  这里添加公共的操作符
		// 帮助
		addSimpleOpt("h", "命令参数说明");
	}
	
	/**
	 * 添加没有参数的操作符 如帮助 -h
	 * @param optName
	 * @param optDescription
	 */
	protected void addSimpleOpt(String optName, String optDescription){
		opts.addOption(optName, optDescription);
	}
	
	/**
	 * 添加有参数的操作符  ，默认不是必选项
	 * @param optName
	 * @param optDescription
	 * @param argName
	 */
	protected void addWithArgOpt(String optName, String optDescription, String argName){
		addWithArgOpt(optName, optDescription, argName, false);
	}
	
	/**
	 * 添加有参数的操作符  可以设置必选项
	 * @param optName
	 * @param optDescription
	 * @param argName
	 * @param isRequired
	 */
	protected void addWithArgOpt(String optName, String optDescription, String argName, boolean isRequired){
		Option opt = Option.builder(optName).build();
		opt.setArgs(1);
		opt.setArgName(argName);
		opt.setDescription(optDescription);
		opt.setRequired(isRequired);
		opts.addOption(opt);
	}
	
	public void printHelp(String cmdName, String cmdDescription){
		formatter.printHelp(cmdName, cmdDescription, opts, cliDescriptionFooter, true);
	}
	
	public CommandLine parser(String[] args) throws ParseException{
		return parser.parse(opts, args);
	}
	
}
