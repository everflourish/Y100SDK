package sdk;

import utils.HttpJSONRequest;
import utils.ThirdApiSignUtil;

public class ExaminationList {
	/**
	 * @param 加载考试列表
	 */
	public static String sign(String key,String appSecret,String timestamp,String outputStr){
		//使用MD5加密
		return ThirdApiSignUtil.stringMD5(key+appSecret+timestamp+outputStr);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String key = "sdgdfg";
		String appSecret = "fghjgjghjgh";
		String timestamp = System.currentTimeMillis()/1000+"";
		String outputStr = "";
		String sign = sign(key,appSecret,timestamp,outputStr);
		String url = "http://192.168.0.66:8080/yeah100-svc-web/third/api/examination/history/teacher/list/nologin?key="+key+"&timestamp="+timestamp+"&sign="+sign+"";
		String result = HttpJSONRequest.sendPostJson(url, outputStr);
		System.out.println(result);
	}

}
