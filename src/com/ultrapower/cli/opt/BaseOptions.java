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
		// ��Ӳ�����  ������ӹ����Ĳ�����
		// ����
		addSimpleOpt("h", "�������˵��");
	}
	
	/**
	 * ���û�в����Ĳ����� ����� -h
	 * @param optName
	 * @param optDescription
	 */
	protected void addSimpleOpt(String optName, String optDescription){
		opts.addOption(optName, optDescription);
	}
	
	/**
	 * ����в����Ĳ�����  ��Ĭ�ϲ��Ǳ�ѡ��
	 * @param optName
	 * @param optDescription
	 * @param argName
	 */
	protected void addWithArgOpt(String optName, String optDescription, String argName){
		addWithArgOpt(optName, optDescription, argName, false);
	}
	
	/**
	 * ����в����Ĳ�����  �������ñ�ѡ��
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
