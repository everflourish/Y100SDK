package sdk.class_;

import sdk.Const;
import utils.FileUtil;
import utils.HttpJSONRequest;

/**
 * 修改学生信息
 * @author Administrator
 *
 */
public class StudentUpdate {
	private static String path = StudentUpdate.class.getResource("").getPath();
	public static void main(String[] args) {
		String json = FileUtil.readStream(path+"StudentUpdate.json");
		String result = HttpJSONRequest.post(Const.DO_MAIN_URL+"third/api/class/student/update/nologin", json);
		System.out.println(result);
		//result = {"resultCode":"000000I","studentIds":[{"id":"402880c1623d349401623d544c4e0009","number":"1234"}]}

	}
}
