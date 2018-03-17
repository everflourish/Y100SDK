package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpJSONRequest {
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
            HttpURLConnection connection = (HttpURLConnection) url  
                    .openConnection();  
            connection.setDoOutput(true);  
            connection.setDoInput(true);  
            connection.setUseCaches(false);  
            connection.setInstanceFollowRedirects(true);  
            connection.setRequestMethod("POST"); // 设置请求方式  
            connection.setRequestProperty("Accept", "application/json"); // 设置接收数据的格式  
            connection.setRequestProperty("Content-Type", "application/json"); // 设置发送数据的格式  
            connection.connect();  
            out = new OutputStreamWriter(  
                    connection.getOutputStream(), "UTF-8"); // utf-8编码  
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
