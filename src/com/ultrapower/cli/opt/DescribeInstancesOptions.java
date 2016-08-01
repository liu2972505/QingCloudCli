package com.ultrapower.cli.opt;

public class DescribeInstancesOptions extends BaseOptions {

	public DescribeInstancesOptions() {
		super();
		// ������еĲ�����
		super.addWithArgOpt("instances", "����ID������Ƕ�̨��Ӣ��Сд���ŷָ� (TYPE String)", "instances");
		super.addWithArgOpt("image_id", "ӳ��ID, ����Ƕ����Ӣ��Сд���ŷָ� (TYPE String)", "image_id");
		super.addWithArgOpt("instance_type", "������������, ����Ƕ����Ӣ��Сд���ŷָ� (TYPE String)", "instance_type");
		super.addWithArgOpt("instance_class", "������������: ������:0 ,����������:1 (TYPE Integer)", "instance_class");
		super.addWithArgOpt("status", "����״̬ ����Ƕ����Ӣ��Сд���ŷָ�: pending, running, stopped, suspended, terminated, ceased (TYPE String)", "status");
		super.addWithArgOpt("search_word", "�����ؼ���, ֧������ID, �������� (TYPE String)", "search_word");
		super.addWithArgOpt("tags", "һ��������ǩ ����Ƕ����Ӣ��Сд���ŷָ�, ����Ƕ����Ӣ��Сд���ŷָ� (TYPE String)", "tags");
		super.addWithArgOpt("verbose", "�Ƿ񷵻��߳�����Ϣ, ��Ϊ1, �򷵻��������������Դ����ϸ���� (TYPE Integer)", "verbose");
		super.addWithArgOpt("offset", "����ƫ����, Ĭ��Ϊ0 (TYPE Integer)", "offset");
		super.addWithArgOpt("limit", "�������ݳ��ȣ�Ĭ��Ϊ20�����100 (TYPE Integer)", "limit");
		super.addWithArgOpt("zone", "���� ID��ע��ҪСд (TYPE String)", "zone");
	}

}
