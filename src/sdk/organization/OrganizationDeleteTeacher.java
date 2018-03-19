package sdk.organization;

import sdk.Const;
import sdk.examination.ExaminationOneStudent;
import utils.FileUtil;
import utils.HttpJSONRequest;
import utils.ThirdApiSignUtil;

public class OrganizationDeleteTeacher {
	/**
	 * @param ����ɾ����ʦ
	 */
	/*public static String sign(String key,String appSecret,String timestamp,String outputStr){
		//ʹ��MD5����
		return ThirdApiSignUtil.stringMD5(key+appSecret+timestamp+outputStr);
	}*/
	private static String path = OrganizationDeleteTeacher.class.getResource("").getPath();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String key = "sdgdfg";
		String appSecret = "fghjgjghjgh";
		String timestamp = System.currentTimeMillis()/1000+"";
		String outputStr = "{\"orgId\":\"757\",\"name\":\"123321123test\"}";
		String sign = sign(key,appSecret,timestamp,outputStr);
		String url = "http://192.168.0.66:8080/yeah100-svc-web/third/api/organization/deleletTeacherByNew/nologin?key="+key+"&timestamp="+timestamp+"&sign="+sign+"";
		String result = HttpJSONRequest.sendPostJson(url, outputStr);
		System.out.println(result);*/
		String json = FileUtil.readStream(path+"OrganizationDeleteTeacher.json");
		String result = HttpJSONRequest.post(Const.DO_MAIN_URL+"third/api/organization/deleletTeacherByNew/nologin", json);
		System.out.println(result);
	}

}
