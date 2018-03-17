package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpJSONRequest {
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
            HttpURLConnection connection = (HttpURLConnection) url  
                    .openConnection();  
            connection.setDoOutput(true);  
            connection.setDoInput(true);  
            connection.setUseCaches(false);  
            connection.setInstanceFollowRedirects(true);  
            connection.setRequestMethod("POST"); // ��������ʽ  
            connection.setRequestProperty("Accept", "application/json"); // ���ý������ݵĸ�ʽ  
            connection.setRequestProperty("Content-Type", "application/json"); // ���÷������ݵĸ�ʽ  
            connection.connect();  
            out = new OutputStreamWriter(  
                    connection.getOutputStream(), "UTF-8"); // utf-8����  
            out.append(params);  
            out.flush();  
           // out.close();  
            in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            } 
        } catch (IOException e) {  
            e.printStackTrace();  
        }finally{
      try {
        if(in!=null){
          in.close();
        }
        if(out!=null){
              out.close();
            }
        
      } catch (IOException e) {
        e.printStackTrace();
      }         
        }
        return result;
    }  

}
