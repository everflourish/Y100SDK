package sdk;

import utils.HttpJSONRequest;
import utils.ThirdApiSignUtil;

public class ExaminationOneStudent {
	/**
	 * @param 考试加载单个学生信息
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
		String outputStr = "{\"examinationId\":\"402880c261d0d0d00161d0d203760000\",\"studentNo\":\"001\"}";
		String sign = sign(key,appSecret,timestamp,outputStr);
		String url = "http://192.168.0.66:8080/yeah100-svc-web/third/api/examination/load/oneStu/paper/info/nologin?key="+key+"&timestamp="+timestamp+"&sign="+sign+"";
		String result = HttpJSONRequest.sendPostJson(url, outputStr);
		System.out.println(result);
	}

}
