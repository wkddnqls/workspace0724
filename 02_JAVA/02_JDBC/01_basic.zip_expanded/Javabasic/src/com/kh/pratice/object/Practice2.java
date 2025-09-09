package com.kh.pratice.object;

import java.util.Scanner;

public class Practice2 {
     /*
      * 알파벳 소문자로만 이루어진 단어가 주어진다. 이때, 
      * 이 단어가 팰린드롬인지 아닌지 확인하는 프로그램을 작성하시오.
      * 팰린드롬이란 앞으로 읽을 때와 거꾸로 읽을 때 똑같은 단어를 말한다.
      * level, noon은 팰린드롬이고, baekjoon, online, judge는 팰린드롬이 아니다. 
      */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
          int a=1;
		
		System.out.print("문자입력 : ");
		String N = sc.next();
             
	     int sum = N.length();
	     
	     for (int i = 0; i < sum ; i++) {
	    if( N.charAt(i) != N.charAt(sum-1-i)) {
	    	a=0;
	    }
	     
	    	 
	     } 
	     
	     System.out.println(a);
	}
		 
	}




/*
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int result = 1; // 일단 팰린드롬이라고 가정
        int len = str.length();

        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - 1 - i)) {
                result = 0; // 다르면 팰린드롬 아님
                break;
            }
        }

        System.out.println(result);
    }
}






*/