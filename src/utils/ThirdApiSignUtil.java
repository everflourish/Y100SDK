package utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import sdk.Const;

/**
 * ǩ��У�鹤��
 * 
 * @author xieqiuming
 *
 */
public class ThirdApiSignUtil {
	
	
	/**
	 * 签名
	 * 
	 * @param key
	 *  ֤
	 * @param appSecret
	 *            秘钥
	 * @param timptrap
	 *            时间戳
	 * @param outputStr
	 *           输出内容
	 * @return
	 */
	public static String sign(String key, String appSecret, String timestamp, String outputStr) {
		return stringMD5(key + appSecret + timestamp + outputStr);
	}

	/**
	 * md5加密
	 * 
	 * @param input
	 * @return
	 */
	public static String stringMD5(String pw) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] inputByteArray = null;
			try {
				inputByteArray = pw.getBytes(Const.CHATSET);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
			messageDigest.update(inputByteArray);
			byte[] resultByteArray = messageDigest.digest();
			return byteArrayToHex(resultByteArray).toLowerCase();
		} catch (NoSuchAlgorithmException e) {
			return null;
		}
	}

	public static String byteArrayToHex(byte[] byteArray) {
		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] resultCharArray = new char[byteArray.length * 2];
		int index = 0;
		for (byte b : byteArray) {
			resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
			resultCharArray[index++] = hexDigits[b & 0xf];
		}
		return new String(resultCharArray);
	}
}
