package sdk.organization;

import sdk.Const;
import utils.FileUtil;
import utils.HttpJSONRequest;

/**
 * 修改机构信息
 * @author Administrator
 *
 */
public class EditByNew {
	private static String path = EditByNew.class.getResource("").getPath();
	public static void main(String[] args) {
		String json = FileUtil.readStream(path+"EditByNew.json");
		String result = HttpJSONRequest.post(Const.DO_MAIN_URL+"third/api/organization/editByNew/nologin", json);
		System.out.println(result);
		//result = {"orgId":877,"userId":"402880c1623d1cad01623d2075cf0000","resultCode":"0000001"}
	}

}
