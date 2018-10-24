package sdk.examination;

import sdk.Const;
import utils.FileUtil;
import utils.HttpJSONRequest;

public class ExaminationTopicPhoto {
	/**
	 * @param ���Լ��ص���ѧ����Ϣ
	 */
	/*public static String sign(String key,String appSecret,String timestamp,String outputStr){
		//ʹ��MD5����
		return ThirdApiSignUtil.stringMD5(key+appSecret+timestamp+outputStr);
	}*/
	private static String path = ExaminationOneStudent.class.getResource("").getPath();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*String key = "sdgdfg";
		String appSecret = "fghjgjghjgh";
		String timestamp = System.currentTimeMillis()/1000+"";
		String outputStr = "{\"examinationId\":\"402880c261d0d0d00161d0d203760000\",\"studentNo\":\"001\"}";
		String sign = sign(key,appSecret,timestamp,outputStr);
		String url = "http://192.168.0.66:8080/yeah100-svc-web/third/api/examination/load/oneStu/paper/info/nologin?key="+key+"&timestamp="+timestamp+"&sign="+sign+"";
		String result = HttpJSONRequest.sendPostJson(url, outputStr);
		System.out.println(result);*/
		String json = FileUtil.readStream(path+"ExaminationTopicPhoto.json");
		String result = HttpJSONRequest.post(Const.DO_MAIN_URL+"/third/api/examination/load/question/paper/info/nologin", json);
		System.out.println(result);
	}
}
