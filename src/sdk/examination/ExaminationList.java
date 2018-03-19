package sdk.examination;

import sdk.Const;
import sdk.core.AddOrg;
import utils.FileUtil;
import utils.HttpJSONRequest;
import utils.ThirdApiSignUtil;

public class ExaminationList {
	/**
	 * @param 加载考试列表
	 * 
	 * 
	 */
	/*public static String sign(String key,String appSecret,String timestamp,String outputStr){
		//使用MD5加密
		return ThirdApiSignUtil.stringMD5(key+appSecret+timestamp+outputStr);
	}*/
	private static String path = ExaminationList.class.getResource("").getPath();
	public static void main(String[] args) {
		String json = FileUtil.readStream(path+"ExaminationList.json");
		String result = HttpJSONRequest.post(Const.DO_MAIN_URL+"third/api/examination/history/teacher/list/nologin", json);
		System.out.println(result);
		// TODO Auto-generated method stub
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
