package sdk.class_;

import sdk.Const;
import utils.FileUtil;
import utils.HttpJSONRequest;

public class DeleteMyClass {
	private static String path = DeleteMyClass.class.getResource("").getPath();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String json = FileUtil.readStream(path+"DeleteMyClass.json");
		String result = HttpJSONRequest.post(Const.DO_MAIN_URL+"third/api/class/deleteMyClass/nologin", json);
		System.out.println(result);
	}

}
