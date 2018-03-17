package sdk;

import utils.HttpJSONRequest;
import utils.ThirdApiSignUtil;

public class test {

	/**
	 * @param args
	 */
	public static String sign(String key,String appSecret,String timestamp,String outputStr){
		// π”√MD5º”√‹
		return ThirdApiSignUtil.stringMD5(key+appSecret+timestamp+outputStr);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String key = "sdgdfg";
		String appSecret = "fghjgjghjgh";
		String timestamp = System.currentTimeMillis()/1000+"";
		String outputStr = "{\"phoneNo\":\"18825195112\",\"phoneZone\":\"86\",\"username\":\"jlewjfle\",\"password\":\"123456\"}";
		String sign = sign(key,appSecret,timestamp,outputStr);
		String url = "http://192.168.0.65:8089/yeah100-svc-web/third/api/core/reg/nologin?key="+key+"&timestamp="+timestamp+"&sign="+sign+"";
		String result = HttpJSONRequest.sendPostJson(url, outputStr);
		System.out.println(result);
	}

}
