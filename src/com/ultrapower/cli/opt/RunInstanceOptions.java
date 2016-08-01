package com.ultrapower.cli.opt;

public class RunInstanceOptions extends BaseOptions {

	public RunInstanceOptions() {
		super();
		// 添加特有的操作符
//		super.addWithArgOpt("s", "主机JSON格式的字符串 例: {\"image_id\":\"centos7x64d\",\"cpu\":1,\"memory\":1024,\"instance_name\":\"liujuntest1\",\"login_mode\":\"passwd\",\"login_passwd\":\"123456Abcd\",\"zone\":\"gd1\",\"vxnets.1\":\"vxnet-6ygoe7g\"}", "sParam");
		super.addWithArgOpt("image_id", "映像ID (TYPE String)", "image_id");
		super.addWithArgOpt("instance_type", "主机类型 (TYPE String)", "instance_type");
		super.addWithArgOpt("cpu", "CPU core，有效值为: 1, 2, 4, 8, 16 (TYPE Integer)", "cpu");
		super.addWithArgOpt("memory", "内存，有效值为: 1024, 2048, 4096, 6144, 8192, 12288, 16384, 24576, 32768 (TYPE Integer)", "memory");
		super.addWithArgOpt("count", "创建主机的数量，默认是1 (TYPE Integer)", "count");
		super.addWithArgOpt("instance_name", "主机名称 (TYPE String)", "instance_name");
		super.addWithArgOpt("login_mode", "指定登录方式 (TYPE String)", "login_mode");
		super.addWithArgOpt("login_keypair", "登录密钥ID (TYPE String)", "login_keypair");
		super.addWithArgOpt("login_passwd", "登录密码 (TYPE String)", "login_passwd");
		super.addWithArgOpt("vxnets", "私有网络ID 如果是多个用英文小写逗号分割 (TYPE String)", "vxnets");
		super.addWithArgOpt("security_group", "主机加载的防火墙ID (TYPE String)", "security_group");
		super.addWithArgOpt("volumes", "硬盘ID 如果是多个用英文小写逗号分割 (TYPE String)", "volumes");
		super.addWithArgOpt("hostname", "主机的 hostname (TYPE String)", "hostname");
		super.addWithArgOpt("need_newsid", "1: 生成新的SID，0: 不生成新的SID, 默认为0；只对Windows类型主机有效 。 (TYPE Integer)", "need_newsid");
		super.addWithArgOpt("need_userdata", "1: 使用 User Data 功能；0: 不使用 User Data 功能；默认为 0 。 (TYPE Integer)", "need_userdata");
		super.addWithArgOpt("userdata_type", "User Data 类型 (TYPE String)", "userdata_type");
		super.addWithArgOpt("userdata_value", "User Data 值 (TYPE String)", "userdata_value");
		super.addWithArgOpt("instance_class", "主机性能类型: 性能型:0 ,超高性能型:1 (TYPE String)", "instance_class");
		super.addWithArgOpt("userdata_path", "User Data 和 MetaData 生成文件的存放路径。不输入或输入不合法时，为默认目录 /etc/qingcloud/userdata (TYPE String)", "userdata_path");
		super.addWithArgOpt("userdata_file", "userdata_type 为 ‘exec’ 时，指定生成可执行文件的路径，默认为/etc/rc.local (TYPE String)", "userdata_file");
		super.addWithArgOpt("zone", "区域 ID，注意要小写 (TYPE String)", "zone");
		
	}

}
