package utils;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileUtil {
	public static String readStream(String path){  	
		File file = new File(path);
		return readStream(file);
	}
	public static String readStream(File file){  
		try {
			InputStream inStream = new FileInputStream(file);
			return readStream(inStream);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	/** 
     * @功能 读取流 
     * @param inStream 
     * @return 字节数组 
     * @throws Exception 
     */  
    public static String readStream(InputStream inStream){  
        ByteArrayOutputStream fileOutStream = new ByteArrayOutputStream();  
        try {
	        byte[] buffer = new byte[1024];  
	        int len = -1;  
	        while ((len = inStream.read(buffer)) != -1) {  
	        	fileOutStream.write(buffer, 0, len);  
	        }         
        } catch (IOException e) {   
            e.printStackTrace();             
        }finally{
        	if(inStream!=null){
        		try {
					inStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        	if(fileOutStream!=null){
        		try {
					fileOutStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        }
        byte[] b = fileOutStream.toByteArray();
        return new String(b);  
    } 
}
