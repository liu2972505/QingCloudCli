package test;

import org.apache.log4j.Logger;

import com.ultrapower.qingcloud.config.Configuration;
import com.ultrapower.qingcloud.driver.QyInstances;

public class TestMain {

	/** 定义记录日志类logger */
	private static Logger logger = Logger.getLogger(TestMain.class);

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Configuration conf = new Configuration();
		conf.init("conf/config.properties");
//		testdescribeInstances();
		testrunInstances();
//		testTerminateInstances();
	}

	public static void testdescribeInstances() {
		String param = "{'status':'stopped','zone':'gd1','instances.1':'i-jrxuu2tz','instances.2':'i-wjqqravb'}";
		QyInstances instances = new QyInstances();
		String result = instances.describeInstances(param);
		System.out.println("=========="+result);
	}
	
	public static void testrunInstances() {
		String param = "{'image_id':'centos7x64d','cpu':1,'memory':1024,'instance_name':'liujuntest10','login_mode':'passwd','login_passwd':'2972505Abcd','zone':'gd1','vxnets.1':'vxnet-6ygoe7g'}";
		QyInstances instances = new QyInstances();
		String result = instances.runInstances(param);
		System.out.println("=========="+result);
	}
	
	public static void testTerminateInstances() {
		String param = "{'instances.1':'i-h3z5leok','instances.2':'i-fb1lzapo','zone':'gd1'}";
		QyInstances instances = new QyInstances();
		String result = instances.terminateInstances(param);
		System.out.println("=========="+result);
	}
	

}
