package com.ultrapower.cli.opt;

public class TerminateInstancesOptions extends BaseOptions {

	public TerminateInstancesOptions() {
		super();
		// ������еĲ�����
		super.addWithArgOpt("instances", "һ����������ID������Ƕ�̨��Ӣ��Сд�ָ� (TYPE String)", "instances");
		super.addWithArgOpt("zone", "���� ID��ע��ҪСд (TYPE String)", "zone");
	}

}
