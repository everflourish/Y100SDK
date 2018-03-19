package sdk;

import utils.HttpJSONRequest;
import utils.ThirdApiSignUtil;

public class OrganizationEdit {
	/**
	 * @param �޸Ļ�����Ϣ
	 */
	public static String sign(String key,String appSecret,String timestamp,String outputStr){
		//ʹ��MD5����
		return ThirdApiSignUtil.stringMD5(key+appSecret+timestamp+outputStr);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String key = "sdgdfg";
		String appSecret = "fghjgjghjgh";
		String timestamp = System.currentTimeMillis()/1000+"";
		String outputStr = "{\"id\":\"757\",\"orgName\":\"����a\",\"address\":\"�㶫|����|�����|�����˺�\",\"tel\":\"17602068893\"}";
		String sign = sign(key,appSecret,timestamp,outputStr);
		String url = "http://192.168.0.66:8080/yeah100-svc-web/third/api/organization/editByNew/nologin?key="+key+"&timestamp="+timestamp+"&sign="+sign+"";
		String result = HttpJSONRequest.sendPostJson(url, outputStr);
		System.out.println(result);
	}

}
