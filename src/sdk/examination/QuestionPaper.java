package sdk.examination;

import sdk.Const;
import utils.FileUtil;
import utils.HttpJSONRequest;

public class QuestionPaper {
	private static String path = QuestionPaper.class.getResource("").getPath();
	public static void main(String[] args) {
		String json = FileUtil.readStream(path+"QustionPaper.json");
		String result = HttpJSONRequest.post(Const.DO_MAIN_URL+"third/api/examination/load/question/paper/info/nologin", json);
		System.out.println(result);
	}

}
