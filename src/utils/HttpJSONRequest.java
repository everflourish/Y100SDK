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
	 * ���ü���
	 * @param url �ӿڵ�ַ
	 * @param outputStr �������
	 * @return �ӿڷ����ַ���
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
	 * ����HttpPost����
	 * 
	 * @param strURL
	 *            �����ַ
	 * @param params
	 *            json�ַ���,����: "{ \"id\":\"12345\" }" ;���������������˫����<br/>
	 * @return �ɹ�:����json�ַ���<br/>
	 */
	public static String sendPostJson(String strURL, String params) {
		BufferedReader in = null;
		OutputStreamWriter out = null;
		String result = "";
		try {
			URL url = new URL(strURL);// ��������
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setDoOutput(true);
			connection.setDoInput(true);
			connection.setUseCaches(false);
			connection.setInstanceFollowRedirects(true);
			connection.setRequestMethod("POST"); // ��������ʽ
			connection.setRequestProperty("Accept", "application/json"); // ���ý������ݵĸ�ʽ
			connection.setRequestProperty("Content-Type", "application/json"); // ���÷������ݵĸ�ʽ
			connection.connect();
			out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8"); // utf-8����
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
