package sdk.class_;

import sdk.Const;
import utils.FileUtil;
import utils.HttpJSONRequest;

public class StudentAdd {
	private static String path = StudentAdd.class.getResource("").getPath();
	public static void main(String[] args) {
		String json = FileUtil.readStream(path+"StudentAdd.json");
		String result = HttpJSONRequest.post(Const.DO_MAIN_URL+"third/api/class/student/add/nologin", json);
		System.out.println(result);
		//result = {"resultCode":"000000I","studentIds":[{"id":"402880c1623d349401623d544c4e0009","number":"1234"}]}

	}
}
