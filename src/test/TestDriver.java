package test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.http.client.ClientProtocolException;

import com.ultrapower.qingcloud.exception.HttpSendException;
import com.ultrapower.qingcloud.util.EncryUtil;
import com.ultrapower.qingcloud.util.HttpClientUtil;


public class TestDriver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
		String sDate = sdf.format(new Date());
		System.out.println(sDate);
		try {
			sDate = URLEncoder.encode(sDate, "UTF-8");
			System.out.println(sDate);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		String qy_access_key_id = "ZPDNGLPQMOQRWZSOCZRG";
		
		String url = "https://api.qingcloud.com/iaas/?access_key_id="+qy_access_key_id+"&action=DescribeInstances&instances.1=i-fb1lzapo&instances.2=i-h3z5leok&signature_method=HmacSHA256&signature_version=1"
				 + "&status=stopped" +"&time_stamp="+sDate + "&version=1"+ "&zone=gd1";

		System.out.println("--" + url);

		
		String string_to_sign = "GET\n/iaas/\naccess_key_id="+qy_access_key_id+"&action=DescribeInstances&instances.1=i-fb1lzapo&instances.2=i-h3z5leok&signature_method=HmacSHA256&signature_version=1"
				 + "&status=stopped" + "&time_stamp="+sDate + "&version=1"+ "&zone=gd1";
		String secret_access_key = "8bEruMQ1x3Nl1rAjAgJffzlKJQDRDMY3yJSplveN";
		System.out.println("«©√˚¥Æ£∫"+string_to_sign);
		System.out.println("√ÿ‘ø£∫"+secret_access_key);
		String result = EncryUtil.sha256Encode(string_to_sign,
				secret_access_key);
		url = url + "&signature=" + result;
		String response = null;

		try {
			response = HttpClientUtil.sendHttpRequest(url);
		} catch (HttpSendException e) {
			e.printStackTrace();
		} 
		System.out.println(response);
	}

}
