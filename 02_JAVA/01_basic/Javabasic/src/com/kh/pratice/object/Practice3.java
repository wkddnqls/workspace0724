package com.kh.pratice.object;

import java.util.Scanner;

public class Practice3 {

	
	/*
	 * 대소문자가 섞인 영어 단어에서 가장 많이 사용된 알파벳을 대문자로 출력하세요.
     * 가장 많이 사용된 알파벳이 여러 개면 `?`를 출력합니다.
	 * 
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("알파벳 입력 : ");
		String N = sc.next().toUpperCase(); 
		
       int[] arr = new int[26];
      
       for (int i = 0; i < N.length(); i++) {
          
    	   arr[N.charAt(i) - 'A']++;
          }
	   
       int Max = Integer.MIN_VALUE;
       char result = '?' ; 
       
       for (int i = 0; i < 26; i++) {
    	   if(arr[i]>Max) {
    		   Max = arr[i];
    		   result = (char)(i+65);
    	   }else if (arr[i] == Max) {
    		   result = '?';
    	   }
    	   
       }
	  
       System.out.println( result );
	    
		
		
	}

}
/*
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String word = sc.next().toUpperCase(); // 모두 대문자로 변환

        int[] counts = new int[26];
        for (int i = 0; i < word.length(); i++) {
            counts[word.charAt(i) - 'A']++;
        }

        int maxCount = -1;
        char result = '?';
        boolean isDuplicate = false;

        for (int i = 0; i < 26; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                result = (char) (i + 'A');
                isDuplicate = false;
            } else if (counts[i] == maxCount) {
                isDuplicate = true;
            }
        }

        System.out.println(isDuplicate ? '?' : result);
   
    
    }
    
    
}







*/