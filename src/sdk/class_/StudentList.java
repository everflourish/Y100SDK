package sdk.class_;

import sdk.Const;
import sdk.core.FindInfo;
import utils.FileUtil;
import utils.HttpJSONRequest;

public class StudentList {
	private static String path = StudentList.class.getResource("").getPath();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String json = FileUtil.readStream(path+"StudentList.json");
		String result = HttpJSONRequest.post(Const.DO_MAIN_URL+"third/api/class/student/list/nologin", json);
		System.out.println(result);
	}

}
