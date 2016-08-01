package com.ultrapower.cli;

public class WorldUtil {
	
	public static final String startString = "[qingcloudcli]#";
	public static final String startWord = "[qingcloudcli]#\n" +
			"###################################################\n" +
			"#  命令说明:\n" +
			"#  run-instances 创建主机；（例 run-instances -image_id centos7x64d -cpu 1 -memory 1024 -instance_name liujuntest1 -login_mode passwd -login_passwd 123456Abcd -zone gd1 -vxnets vxnet-6ygoe7g）\n" +
			"#  describe-instances 查询主机；（例 describe-instances -status stopped,running -zone gd1 -instances i-izbcc6k1,i-wjqqravb ）\n" +
			"#  terminate-instances 销毁主机；（例 terminate-instances -instances i-yyh6kk07,i-z5libxtx -zone gd1）\n"+
			"#  命令 + h 命令帮助；（例 run-instances -h） \n"+
			"#  exit 推出；\n"+
			"#  help 帮助；\n"+
			"#  注 多值属性使用英文逗号进行分割 \n"+
			"#     参数不区分类型 \n"+
			"###################################################\n";
	public static final String endWord = "[qingcloudcli]#感谢使用！";
}
