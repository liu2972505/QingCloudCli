package com.ultrapower.cli.opt;

public class TerminateInstancesOptions extends BaseOptions {

	public TerminateInstancesOptions() {
		super();
		// 添加特有的操作符
		super.addWithArgOpt("instances", "一个或多个主机ID，如果是多台用英文小写分割 (TYPE String)", "instances");
		super.addWithArgOpt("zone", "区域 ID，注意要小写 (TYPE String)", "zone");
	}

}
