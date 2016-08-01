package com.ultrapower.cli;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import com.ultrapower.cli.cmd.BaseCommand;
import com.ultrapower.cli.cmd.DescribeInstancesCommand;
import com.ultrapower.cli.cmd.ExitCommand;
import com.ultrapower.cli.cmd.HelpCommand;
import com.ultrapower.cli.cmd.RunInstanceCommand;
import com.ultrapower.cli.cmd.TerminateInstancesCommand;
import com.ultrapower.qingcloud.config.Configuration;



public class Qingcloudcli {

	
	private static Map<String, BaseCommand> cmdMap = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.print(WorldUtil.startWord);
		initCommandMap();
		initConfig();
		BufferedReader bufferedReader = null;
		BaseCommand command = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            while(true){
        		System.out.print(WorldUtil.startString);
                String val = bufferedReader.readLine();
                if(val == null){
                	continue;
                }
                // 去前后空格
                val = val.trim();
                String[] myArgs = val.split(" ");
                if(myArgs == null){
                	continue;
                }
                
                // 获取命令名称
                String cmdStr = myArgs[0];
				if (cmdStr.trim().length() == 0) {
					continue;
				}
                // 根据命令名称获取处理实例
                command = getCmd(cmdStr);
                if(command == null){
                	//  提示错误信息
                	System.out.println("没有 '" + cmdStr + "' 命令");
                	continue;
                }
                
                int argsLength = myArgs.length;
                Map<String, String> optMap = null;
                if(argsLength > 1){
                	// 说明有操作符输入
                	String[] opts = new String[myArgs.length-1];
                    System.arraycopy(myArgs, 1, opts, 0, opts.length);
                    
                    
                    optMap = command.parser(opts);
                    // 判断参数错误  直接打印帮助信息，不做命令的处理
                    if(optMap == null){
                    	command.printHelp();
                    	continue;
                    }
                    // 判断如果参数中有-h  帮助  直接打印帮助信息，不做命令的处理
                    if((optMap!= null) && (optMap.containsKey("h"))){
                    	command.printHelp();
                    	continue;
                    }
                   
                }
                
                command.exec(optMap);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally{
            if(bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                bufferedReader = null;
            }
        }

	}
	
	private static void initCommandMap(){
		cmdMap = new HashMap<String, BaseCommand>();
		
		BaseCommand helpCmd = new HelpCommand();
		cmdMap.put(helpCmd.getCmdName(), helpCmd);
		
		BaseCommand runCmd = new RunInstanceCommand();
		cmdMap.put(runCmd.getCmdName(), runCmd);
		
		BaseCommand delCmd = new TerminateInstancesCommand();
		cmdMap.put(delCmd.getCmdName(), delCmd);
		
		BaseCommand queryCmd = new DescribeInstancesCommand();
		cmdMap.put(queryCmd.getCmdName(), queryCmd);
		
		BaseCommand exitcmd = new ExitCommand();
		cmdMap.put(exitcmd.getCmdName(), exitcmd);
	}
	
	private static void initConfig(){
		Configuration conf = new Configuration();
		conf.init("conf/config.properties");
	}
	
	private static BaseCommand getCmd(String cmdName){
		return cmdMap.get(cmdName);
	} 

}
