package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import sdk.Const;

public class HttpJSONRequest {
	/**
	 * 调用接口
	 * @param url 地址ַ
	 * @param outputStr JSON参数
	 * @return 
	 */
	public static String post(String url,String jsonStr) {		
		String timestamp = System.currentTimeMillis()/1000+"";
		String sign = ThirdApiSignUtil.stringMD5(Const.KEY + Const.SECRET + timestamp + jsonStr);
		url += "?key="+Const.KEY+"&timestamp="+timestamp+"&sign="+sign;
		System.out.println(url);
		String result = HttpJSONRequest.sendPostJson(url, jsonStr);
		return result;
	}
	public static String getLoginParamUrl(String name) {
		String timestamp = System.currentTimeMillis()/1000+"";
		String sign = ThirdApiSignUtil.stringMD5(Const.KEY + Const.SECRET + timestamp + name);
		String url = Const.LOGIN_URL + "?key="+Const.KEY+"&timestamp="+timestamp+"&sign="+sign+"&username="+name;
		return url;
	}
	/**
	 * HttpPost
	 * 
	 * @param strURL
	 *            地址ַ
	 * @param params
	 *            json参数: "{ \"id\":\"12345\" }" ;
	 * @return 字符串
	 */
	public static String sendPostJson(String strURL, String params) {
		BufferedReader in = null;
		OutputStreamWriter out = null;
		String result = "";
		try {
			URL url = new URL(strURL);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestMethod("POST");
			connection.setRequestProperty("Accept", "application/json");
			connection.setRequestProperty("Content-Type", "application/json");
			connection.connect();
			out = new OutputStreamWriter(connection.getOutputStream(), Const.CHATSET);
			out.append(params);
			out.flush();
			InputStreamReader isr = new InputStreamReader(connection.getInputStream(), Const.CHATSET);
			in = new BufferedReader(isr);
			String line;
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
				if (out != null) {
					out.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}

}
