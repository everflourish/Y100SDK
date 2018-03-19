package sdk.organization;

import sdk.Const;
import sdk.core.AddOrg;
import utils.FileUtil;
import utils.HttpJSONRequest;

public class TeacherOrg {
	
	private static String path = TeacherOrg.class.getResource("").getPath();
	public static void main(String[] args) {
		String json = FileUtil.readStream(path+"TeacherOrg.json");
		String result = HttpJSONRequest.post(Const.DO_MAIN_URL+"third/api/organization/teacher2org/nologin", json);
		System.out.println(result);
	}

}
