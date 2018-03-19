package sdk.class_;

import sdk.Const;
import utils.FileUtil;
import utils.HttpJSONRequest;

/**
 * 获取班级
 * @author Administrator
 *
 */
public class ListNew {
	private static String path = ListNew.class.getResource("").getPath();
	public static void main(String[] args) {
		String json = FileUtil.readStream(path+"ListNew.json");
		String result = HttpJSONRequest.post(Const.DO_MAIN_URL+"third/api/class/list/new/nologin", json);
		System.out.println(result);
		//result = {"resultCode":"000000I","classInfo":{"id":8246,"name":"高一（6）班","size":0,"sharingNo":"348097369756","createTime":"2018-03-19 16:00:31","createdBy":"crrj"}}
	}
}
