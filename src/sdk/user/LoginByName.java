package sdk.user;
import utils.HttpJSONRequest;

public class LoginByName {
	public static void main(String[] args) {		
		String result = HttpJSONRequest.getLoginParamUrl("app3434");
		//浏览器访问以下地址
		System.out.println(result);
	}
}
