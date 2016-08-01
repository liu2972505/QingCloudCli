package com.ultrapower.cli.opt;

public class DescribeInstancesOptions extends BaseOptions {

	public DescribeInstancesOptions() {
		super();
		// 添加特有的操作符
		super.addWithArgOpt("instances", "主机ID，如果是多台用英文小写逗号分割 (TYPE String)", "instances");
		super.addWithArgOpt("image_id", "映像ID, 如果是多个用英文小写逗号分割 (TYPE String)", "image_id");
		super.addWithArgOpt("instance_type", "主机配置类型, 如果是多个用英文小写逗号分割 (TYPE String)", "instance_type");
		super.addWithArgOpt("instance_class", "主机性能类型: 性能型:0 ,超高性能型:1 (TYPE Integer)", "instance_class");
		super.addWithArgOpt("status", "主机状态 如果是多个用英文小写逗号分割: pending, running, stopped, suspended, terminated, ceased (TYPE String)", "status");
		super.addWithArgOpt("search_word", "搜索关键词, 支持主机ID, 主机名称 (TYPE String)", "search_word");
		super.addWithArgOpt("tags", "一个或多个标签 如果是多个用英文小写逗号分割, 如果是多个用英文小写逗号分割 (TYPE String)", "tags");
		super.addWithArgOpt("verbose", "是否返回冗长的信息, 若为1, 则返回主机相关其他资源的详细数据 (TYPE Integer)", "verbose");
		super.addWithArgOpt("offset", "数据偏移量, 默认为0 (TYPE Integer)", "offset");
		super.addWithArgOpt("limit", "返回数据长度，默认为20，最大100 (TYPE Integer)", "limit");
		super.addWithArgOpt("zone", "区域 ID，注意要小写 (TYPE String)", "zone");
	}

}
