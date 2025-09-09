package com.kh.pratice.object;

import java.util.Scanner;

public class Practice5________1 {

	public static void main(String[] args) {
		//문자가 등장할 떄 등장한 문자를 체크
		// 이미 나왔던 문자가 다시등장시, 이전문자와 같은지 확인후
		// 이미 나왔던 문자가 이전문자와 다른문자라면 그룹단어가 아니다
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int count = 0;
		
		for(int i = 0 ; i<n ; i++) {
			String str = sc.next();
			
			boolean[] isDupl = new boolean[26];
			char prev = 0;
			boolean isOK=true;
			
			
			//단어 하나에대한 검사문
			for(int j = 0 ; j < str.length();j++) {
				char ch = str .charAt(j);
				
				if(prev != ch) {
					int index = ch - 'a';
					if(isDupl[index]) {
						//그룹단어가 아니다
						isOK=false;
						break;
					}
				     isDupl[index]=true; // 이미 등장한 알파벳 체킹
				     prev=ch; //비교를위한 이전문자 저장
				}
			}
			
			if(isOK) {
				count++;}
			
		}
		 System.out.println(count);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
