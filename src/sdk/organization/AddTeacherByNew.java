package sdk.organization;

import sdk.Const;
import sdk.core.AddOrg;
import utils.FileUtil;
import utils.HttpJSONRequest;

public class AddTeacherByNew {
	private static String path = AddTeacherByNew.class.getResource("").getPath();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String json = FileUtil.readStream(path+"AddTeacherByNew.json");
		String result = HttpJSONRequest.post(Const.DO_MAIN_URL+"third/api/organization/addTeacherByNew/nologin", json);
		System.out.println(result);
	}

}
