package sdk.class_;

import sdk.Const;
import sdk.organization.AddTeacher;
import utils.FileUtil;
import utils.HttpJSONRequest;

public class UpdateClass {
	private static String path = UpdateClass.class.getResource("").getPath();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String json = FileUtil.readStream(path+"updateClass.json");
		String result = HttpJSONRequest.post(Const.DO_MAIN_URL+"third/api/class/update/nologin", json);
		System.out.println(result);
	}

}
