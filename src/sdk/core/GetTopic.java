package sdk.core;

import sdk.Const;
import utils.FileUtil;
import utils.HttpJSONRequest;

/**
 * ��ӻ���
 * @author xieqiuming
 *
 */
public class GetTopic {
	private static String path = GetTopic.class.getResource("").getPath();
	public static void main(String[] args) {
		String json = FileUtil.readStream(path+"GetTopic.json");
		String result = HttpJSONRequest.post(Const.DO_MAIN_URL+"third/api/core/g_topic/nologin", json);
		System.out.println(result);
		//result = {"orgId":879,"resultCode":"000000I"}
	}
}
