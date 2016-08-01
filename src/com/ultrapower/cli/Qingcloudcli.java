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
                // ȥǰ��ո�
                val = val.trim();
                String[] myArgs = val.split(" ");
                if(myArgs == null){
                	continue;
                }
                
                // ��ȡ��������
                String cmdStr = myArgs[0];
				if (cmdStr.trim().length() == 0) {
					continue;
				}
                // �����������ƻ�ȡ����ʵ��
                command = getCmd(cmdStr);
                if(command == null){
                	//  ��ʾ������Ϣ
                	System.out.println("û�� '" + cmdStr + "' ����");
                	continue;
                }
                
                int argsLength = myArgs.length;
                Map<String, String> optMap = null;
                if(argsLength > 1){
                	// ˵���в���������
                	String[] opts = new String[myArgs.length-1];
                    System.arraycopy(myArgs, 1, opts, 0, opts.length);
                    
                    
                    optMap = command.parser(opts);
                    // �жϲ�������  ֱ�Ӵ�ӡ������Ϣ����������Ĵ���
                    if(optMap == null){
                    	command.printHelp();
                    	continue;
                    }
                    // �ж������������-h  ����  ֱ�Ӵ�ӡ������Ϣ����������Ĵ���
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
