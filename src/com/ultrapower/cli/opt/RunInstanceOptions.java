package com.ultrapower.cli.opt;

public class RunInstanceOptions extends BaseOptions {

	public RunInstanceOptions() {
		super();
		// ������еĲ�����
//		super.addWithArgOpt("s", "����JSON��ʽ���ַ��� ��: {\"image_id\":\"centos7x64d\",\"cpu\":1,\"memory\":1024,\"instance_name\":\"liujuntest1\",\"login_mode\":\"passwd\",\"login_passwd\":\"123456Abcd\",\"zone\":\"gd1\",\"vxnets.1\":\"vxnet-6ygoe7g\"}", "sParam");
		super.addWithArgOpt("image_id", "ӳ��ID (TYPE String)", "image_id");
		super.addWithArgOpt("instance_type", "�������� (TYPE String)", "instance_type");
		super.addWithArgOpt("cpu", "CPU core����ЧֵΪ: 1, 2, 4, 8, 16 (TYPE Integer)", "cpu");
		super.addWithArgOpt("memory", "�ڴ棬��ЧֵΪ: 1024, 2048, 4096, 6144, 8192, 12288, 16384, 24576, 32768 (TYPE Integer)", "memory");
		super.addWithArgOpt("count", "����������������Ĭ����1 (TYPE Integer)", "count");
		super.addWithArgOpt("instance_name", "�������� (TYPE String)", "instance_name");
		super.addWithArgOpt("login_mode", "ָ����¼��ʽ (TYPE String)", "login_mode");
		super.addWithArgOpt("login_keypair", "��¼��ԿID (TYPE String)", "login_keypair");
		super.addWithArgOpt("login_passwd", "��¼���� (TYPE String)", "login_passwd");
		super.addWithArgOpt("vxnets", "˽������ID ����Ƕ����Ӣ��Сд���ŷָ� (TYPE String)", "vxnets");
		super.addWithArgOpt("security_group", "�������صķ���ǽID (TYPE String)", "security_group");
		super.addWithArgOpt("volumes", "Ӳ��ID ����Ƕ����Ӣ��Сд���ŷָ� (TYPE String)", "volumes");
		super.addWithArgOpt("hostname", "������ hostname (TYPE String)", "hostname");
		super.addWithArgOpt("need_newsid", "1: �����µ�SID��0: �������µ�SID, Ĭ��Ϊ0��ֻ��Windows����������Ч �� (TYPE Integer)", "need_newsid");
		super.addWithArgOpt("need_userdata", "1: ʹ�� User Data ���ܣ�0: ��ʹ�� User Data ���ܣ�Ĭ��Ϊ 0 �� (TYPE Integer)", "need_userdata");
		super.addWithArgOpt("userdata_type", "User Data ���� (TYPE String)", "userdata_type");
		super.addWithArgOpt("userdata_value", "User Data ֵ (TYPE String)", "userdata_value");
		super.addWithArgOpt("instance_class", "������������: ������:0 ,����������:1 (TYPE String)", "instance_class");
		super.addWithArgOpt("userdata_path", "User Data �� MetaData �����ļ��Ĵ��·��������������벻�Ϸ�ʱ��ΪĬ��Ŀ¼ /etc/qingcloud/userdata (TYPE String)", "userdata_path");
		super.addWithArgOpt("userdata_file", "userdata_type Ϊ ��exec�� ʱ��ָ�����ɿ�ִ���ļ���·����Ĭ��Ϊ/etc/rc.local (TYPE String)", "userdata_file");
		super.addWithArgOpt("zone", "���� ID��ע��ҪСд (TYPE String)", "zone");
		
	}

}
