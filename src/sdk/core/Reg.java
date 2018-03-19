package sdk.core;

import sdk.Const;
import utils.FileUtil;
import utils.HttpJSONRequest;

/**
 * ×¢²áÕËºÅ
 * @author xieqiuming
 *
 */
public class Reg {
	private static String path = Reg.class.getResource("").getPath();
	public static void main(String[] args) {
		String json = FileUtil.readStream(path+"Reg.json");
		String result = HttpJSONRequest.post(Const.DO_MAIN_URL+"third/api/core/reg/nologin", json);
		System.out.println(result);
		//result = {"orgId":878,"userId":"402880c1623d349401623d3aa6870004","resultCode":"0000001"}

	}
}
