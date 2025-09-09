package com.kh.pratice.object;

import java.util.Scanner;

public class Practice3_2 {

	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		System.out.print("알파벳 입력 : ");
		String N = sc.next().toUpperCase(); 
		
       int[] count = new int[26];
      
       for (int i = 0; i < N.length(); i++) {
          
    	   int index = N.charAt(i) - 'A';
    	   count [index]++;
          }
   int max= 0;
   int index = 0;
 boolean isDupl = false;
for(int i =0 ; i<count.length ; i++)
{ 
   
if(count[i] >max){
     max = count[i];
     index =i;
     isDupl = false; 
    }else if(count[i] ==max) {
	    isDupl=true;
	   
	}
}

System.out.println(isDupl ? "?" : (char)(index+ 'A'));
}

	
	
	
	}