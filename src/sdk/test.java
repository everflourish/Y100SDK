package sdk;

import utils.HttpJSONRequest;
import utils.ThirdApiSignUtil;

public class test {

	/**
	 * @param args
	 */
	public static String sign(String key,String appSecret,String timestamp,String outputStr){
		//ʹ��MD5����
		return ThirdApiSignUtil.stringMD5(key+appSecret+timestamp+outputStr);
	}
	public static void main(String[] args) {
		
	}

}
