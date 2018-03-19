package sdk.core;

import sdk.Const;
import utils.FileUtil;
import utils.HttpJSONRequest;

/**
 * Ìí¼Ó»ú¹¹
 * @author xieqiuming
 *
 */
public class AddOrg {
	private static String path = AddOrg.class.getResource("").getPath();
	public static void main(String[] args) {
		String json = FileUtil.readStream(path+"AddOrg.json");
		String result = HttpJSONRequest.post(Const.DO_MAIN_URL+"third/api/core/add_org/nologin", json);
		System.out.println(result);
		//result = {"orgId":879,"resultCode":"000000I"}
	}
}
