package com.ultrapower.cli;

public class WorldUtil {
	
	public static final String startString = "[qingcloudcli]#";
	public static final String startWord = "[qingcloudcli]#\n" +
			"###################################################\n" +
			"#  ����˵��:\n" +
			"#  run-instances �������������� run-instances -image_id centos7x64d -cpu 1 -memory 1024 -instance_name liujuntest1 -login_mode passwd -login_passwd 123456Abcd -zone gd1 -vxnets vxnet-6ygoe7g��\n" +
			"#  describe-instances ��ѯ���������� describe-instances -status stopped,running -zone gd1 -instances i-izbcc6k1,i-wjqqravb ��\n" +
			"#  terminate-instances �������������� terminate-instances -instances i-yyh6kk07,i-z5libxtx -zone gd1��\n"+
			"#  ���� + h ������������� run-instances -h�� \n"+
			"#  exit �Ƴ���\n"+
			"#  help ������\n"+
			"#  ע ��ֵ����ʹ��Ӣ�Ķ��Ž��зָ� \n"+
			"#     �������������� \n"+
			"###################################################\n";
	public static final String endWord = "[qingcloudcli]#��лʹ�ã�";
}
