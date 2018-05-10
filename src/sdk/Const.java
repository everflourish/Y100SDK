package sdk;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

public class Const {
	public static final String KEY = "xqm";//账号
	public static final String SECRET = "123456";//秘钥
	public static final String DO_MAIN_URL = "http://localhost:8089/yeah100-svc-web/";//接口地址ַ
	public static final String LOGIN_URL = "http://localhost:8089/yeah100-web-new/login_by_name.html";//登录地址
	public static final String CHATSET = "UTF-8"; 
	
	public static void main(String[] args) throws UnsupportedEncodingException {
		//byte[] b = "是".getBytes(CHATSET);		
		//System.out.println(b.length);
		List<Integer[]> s = new ArrayList<Integer[]>();
		/*s.add(new Integer[] {1,2,3});
		s.add(new Integer[] {4,5,6});
		s.add(new Integer[] {7,8,9});*/
		/*s.add(new Integer[] {1,2,3,4});
		s.add(new Integer[] {12,13,14,5});
		s.add(new Integer[] {11,16,15,6});
		s.add(new Integer[] {10,9,8,7});*/
		s.add(new Integer[] {1,2,3,4,91});
		s.add(new Integer[] {12,13,14,5,92});
		s.add(new Integer[] {11,16,15,6,93});
		s.add(new Integer[] {10,9,8,7,94});
		s.add(new Integer[] {1011,911,811,711,95});
		List<Integer> list = new ArrayList<Integer>();
		int len = s.size();
		
		for(int i=0;
				i<len*2-1;//次数，规律
				i++) {
			int n = i%4;//第n行，列
			if(n==0) {
				Integer[] s0 = s.get(0);
				for(Integer j : s0) {
					list.add(j);
				}
				s.remove(0);
			}
			if(n==1) {
				for(int j=0;j<s.size();j++) {
					Integer[] js = s.get(j);
					Integer[] js2 = new Integer[js.length-1];
					for(int b=0;b<js.length;b++) {
						if(b+1 != js.length) {
							js2[b] = js[b];
						}else {
							list.add(js[b]);
						}			
					}
					
					s.set(j, js2);
				}
			}
			if(n==2) {
				Integer[] s0 = s.get(s.size()-1);
				
				for(int j = s0.length-1;j >-1;j--) {
					list.add(s0[j]);
				}
				s.remove(s.size()-1);
			}
			if(n==3) {
				for(int j=s.size()-1;j>-1;j--) {
					Integer[] js = s.get(j);
					Integer[] js2 = new Integer[js.length-1];
					for(int b=js.length-1;b>-1;b--) {
						if(b != 0) {
							js2[b-1] = js[b];
						}else {
							list.add(js[b]);
						}			
					}						
					s.set(j, js2);
				}
			}
		}
		for(Integer i:list) {
			System.out.print(i+",");
		}
	}
}
