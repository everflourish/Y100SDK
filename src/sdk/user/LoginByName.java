package sdk.user;
import utils.HttpJSONRequest;

public class LoginByName {
	public static void main(String[] args) {		
		String result = HttpJSONRequest.getLoginParamUrl("syse123");
		//������������µ�ַ
		System.out.println(result);
	}
}
