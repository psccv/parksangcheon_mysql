package kr.or.test;

import java.util.StringTokenizer;

public class Split {

	public static void main(String[] args) {
		String str = "아이디,이름,패스워드";
		// split 함수을 사용한 문자열 분리
		String[] tokens = str.split(",");
		int cnt=0;
		System.out.println("split()을 사용한 문자열 분리");
		for(String token : tokens) {
			System.out.println("배열["+(cnt++)+"] "+token);
		}
		
		cnt=0;
		// StringTokenizer 클래스를 사용한 문자열 분리
		StringTokenizer st = new StringTokenizer(str,",");
		System.out.println("StringTokenizer 클래스를 사용한 문자열 분리");
		while(st.hasMoreTokens()) {
			String token = st.nextToken();
			System.out.println("배열["+(cnt++)+"] "+token);
		}

	}

}
