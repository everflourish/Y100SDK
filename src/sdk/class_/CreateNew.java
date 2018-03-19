package sdk.class_;

import sdk.Const;
import utils.FileUtil;
import utils.HttpJSONRequest;

public class CreateNew {
	private static String path = CreateNew.class.getResource("").getPath();
	public static void main(String[] args) {
		String json = FileUtil.readStream(path+"CreateNew.json");
		String result = HttpJSONRequest.post(Const.DO_MAIN_URL+"third/api/class/createNew/nologin", json);
		System.out.println(result);
		//result = {"resultCode":"000000I","classInfo":{"id":8246,"name":"¸ßÒ»£¨6£©°à","size":0,"sharingNo":"348097369756","createTime":"2018-03-19 16:00:31","createdBy":"crrj"}}
	}
}
