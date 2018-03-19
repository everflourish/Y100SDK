package sdk.core;

import sdk.Const;
import utils.FileUtil;
import utils.HttpJSONRequest;

public class FindInfo {

	private static String path = FindInfo.class.getResource("").getPath();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String json = FileUtil.readStream(path+"FindInfo.json");
		String result = HttpJSONRequest.post(Const.DO_MAIN_URL+"third/api/core/find_info/nologin", json);
		System.out.println(result);

	}

}
