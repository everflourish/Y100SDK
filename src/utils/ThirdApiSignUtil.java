package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
/**
 * ǩ��У�鹤��
 * @author xieqiuming
 *
 */
public class ThirdApiSignUtil {
	private static long OVER_TIME = 600;//ʱ���10���ӳ�ʱ
	public static void main(String[] args) {
		//{"examinationId":"8a990a515f4db835015f5621b0bb04d7"}
		//337A1E58DE95D3A22E6316444C3AB8D3
		String stamp = System.currentTimeMillis()/1000+"";
		String sign = sign("abc", "abcde", stamp+"", "{\"phoneNo\":\"18825195112\",\"phoneZone\":\"86\",\"username\":\"jlewjfle\",\"password\":\"123456\"}");
		System.out.println(sign);
		
		System.out.println(stamp);
		//System.out.println(System.currentTimeMillis()/1000);
	}
	
	/**
	 * ǩ��
	 * @param key ������ƽ̨ƾ֤
	 * @param appSecret ������ƽ̨�ӿ���Կ
	 * @param timptrap ʱ�������ȷ���룩
	 * @param outputStr �����JSON�ַ���
	 * @return
	 */
	public static String sign(String key,String appSecret,String timestamp,String outputStr){
		//ʹ��MD5����
		return stringMD5(key+appSecret+timestamp+outputStr);
	}
	/**
	   * ��ȡ���ܺ���ַ���
	   * @param input
	   * @return
	   */
	  public static String stringMD5(String pw) {
	   try {  
	     
	        // �õ�һ��MD5ת�����������ҪSHA1�������ɡ�SHA1����  
	        MessageDigest messageDigest =MessageDigest.getInstance("MD5");  
	        // ������ַ���ת�����ֽ�����  
	        byte[] inputByteArray = pw.getBytes();  
	        // inputByteArray�������ַ���ת���õ����ֽ�����  
	        messageDigest.update(inputByteArray);  
	        // ת�������ؽ����Ҳ���ֽ����飬����16��Ԫ��  
	        byte[] resultByteArray = messageDigest.digest();  
	        // �ַ�����ת�����ַ�������  
	        return byteArrayToHex(resultByteArray).toLowerCase();  
	     } catch (NoSuchAlgorithmException e) {  
	        return null;  
	     }  
	 }
	  
	     public static String byteArrayToHex(byte[] byteArray) {  
	        
	        // ���ȳ�ʼ��һ���ַ����飬�������ÿ��16�����ַ�  
	        char[] hexDigits = {'0','1','2','3','4','5','6','7','8','9', 'A','B','C','D','E','F' };  
	        // newһ���ַ����飬�������������ɽ���ַ����ģ�����һ�£�һ��byte�ǰ�λ�����ƣ�Ҳ����2λʮ�������ַ���2��8�η�����16��2�η�����  
	        char[] resultCharArray =new char[byteArray.length * 2];  
	        // �����ֽ����飬ͨ��λ���㣨λ����Ч�ʸߣ���ת�����ַ��ŵ��ַ�������ȥ  
	        int index = 0; 
	        for (byte b : byteArray) {  
	           resultCharArray[index++] = hexDigits[b>>> 4 & 0xf];  
	           resultCharArray[index++] = hexDigits[b& 0xf];  
	        }
	         // �ַ�������ϳ��ַ�������  
	        return new String(resultCharArray);  
	    }
}
