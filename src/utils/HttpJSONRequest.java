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
	 * 调用几口
	 * @param url 接口地址
	 * @param outputStr 传入参数
	 * @return 接口返回字符串
	 */
	public static String post(String url,String jsonStr) {		
		String timestamp = System.currentTimeMillis()/1000+"";
		String sign = ThirdApiSignUtil.stringMD5(Const.KEY + Const.SECRET + timestamp + jsonStr);
		url += "?key="+Const.KEY+"&timestamp="+timestamp+"&sign="+sign;
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
	 * 发送HttpPost请求
	 * 
	 * @param strURL
	 *            服务地址
	 * @param params
	 *            json字符串,例如: "{ \"id\":\"12345\" }" ;其中属性名必须带双引号<br/>
	 * @return 成功:返回json字符串<br/>
	 */
	public static String sendPostJson(String strURL, String params) {
		BufferedReader in = null;
		OutputStreamWriter out = null;
		String result = "";
		try {
			URL url = new URL(strURL);// 创建连接
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestMethod("POST"); // 设置请求方式
			connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式
			connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式
			connection.connect();
			out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); // utf-8编码
			out.append(params);
			out.flush();
			InputStreamReader isr = new InputStreamReader(connection.getInputStream(), "utf-8");
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
