package com.kh.pratice.object;

import java.util.Scanner;

public class Practice4_2 {
	/*
	    * 예전에는 운영체제에서 크로아티아 알파벳을 입력할 수가 없었다.
	    *  따라서, 다음과 같이 크로아티아 알파벳을 변경해서 입력했다.
	    *
	    *문자열.replace("찾을문자열","바꿀문자열");
	    *
	    *원래문자열에서 찾을문자열을 검색하여 바꿀문자열로 치환한 새로운 문자열 반환
	    */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
       String s = sc.next();
       
       int i = 0;
       int count = 0;
       int len = s.length();
       //ljes=njak 
       
       while (i < len) {
    	   //3글자
    	   {if((i+2<len)&&
    		  s.charAt(i)=='d'&&
    		  s.charAt(i+1)== 'z'&&
    		  s.charAt(i+2)=='=') {
    		   count++;
    		   i+=3;
    	      continue;
    	   }
    	   }
    	   //2글자
    	   
    	   if(i+1 <len) {
    		   String str = s.charAt(i) + "" + s.charAt(i+1);
    	   if(
    			   str.equals("c=") ||
    			   str.equals("c-") ||
    			   str.equals("d-") ||
    			   str.equals("lj") ||
    			   str.equals("nj") ||
    			   str.equals("s=") ||
    			   str.equals("z=") ) {
    		   count ++;
    		   i += 2;
    		   continue;
    		   
    	   }}
    	
    	   //1글자
    			   count++;		   
    			   i++;
       }
       
       System.out.println(count);
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
       
	}

}
