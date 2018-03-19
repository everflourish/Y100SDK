package sdk.organization;

import sdk.Const;
import utils.FileUtil;
import utils.HttpJSONRequest;

public class AddTeacher {
	private static String path = AddTeacher.class.getResource("").getPath();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String json = FileUtil.readStream(path+"AddTeacher.json");
		String result = HttpJSONRequest.post(Const.DO_MAIN_URL+"third/api/core/add_teacher/nologin", json);
		System.out.println(result);
	}

}
