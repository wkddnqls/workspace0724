package com.kh.example.api;

import java.util.StringTokenizer;

public class TokenController {

	public TokenController() {
		super();
	}

	 public String[] afterToken(String str) {
		 
		 
		 StringTokenizer stn = new StringTokenizer(str," ");
		 
		 int size =stn.countTokens();
		  
		 // 배열 생성
		    String[] tokens = new String[size];

		    // 배열에 토큰 저장
		    for (int i = 0; i < size; i++) {
		        tokens[i] = stn.nextToken();
		    }

		    return tokens;
		 
	 }
	
	 public String firstCap(String input) {
		 return input.substring(0, 1).toUpperCase() + input.substring(1);
	 }
	
	 public int findChar(String input, char one) {
		 
		 int count = 0 ;
		 
		 for(int i = 0 ; i<input.length(); i++ ) {
		 
			 if(input.charAt(i) == one) {
			 count++;
		 }
	 }
		 return count;
	 }
}
