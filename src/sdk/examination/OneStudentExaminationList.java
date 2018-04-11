package sdk.examination;

import sdk.Const;
import sdk.core.AddOrg;
import utils.FileUtil;
import utils.HttpJSONRequest;
import utils.ThirdApiSignUtil;

public class OneStudentExaminationList {
	/**
	 * @param ���ؿ����б�
	 * 
	 * 
	 */
	/*public static String sign(String key,String appSecret,String timestamp,String outputStr){
		//ʹ��MD5����
		return ThirdApiSignUtil.stringMD5(key+appSecret+timestamp+outputStr);
	}*/
	private static String path = OneStudentExaminationList.class.getResource("").getPath();
	public static void main(String[] args) {
		String json = FileUtil.readStream(path+"OneStudentExaminationList.json");
		String result = HttpJSONRequest.post(Const.DO_MAIN_URL+"third/api/examination/load/oneStu/all/exam/nologin", json);
		System.out.println(result);
		// TODnO Auto-generated method stub
		/*String key = "sdgdfg";
		String appSecret = "fghjgjghjgh";
		String timestamp = System.currentTimeMillis()/1000+"";
		String outputStr = "";
		String sign = sign(key,appSecret,timestamp,outputStr);
		String url = "http://192.168.0.66:8080/yeah100-svc-web/third/api/examination/history/teacher/list/nologin?key="+key+"&timestamp="+timestamp+"&sign="+sign+"";
		String result = HttpJSONRequest.sendPostJson(url, outputStr);
		System.out.println(result);*/
	}

}
