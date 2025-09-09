package com.kh.loop;

import java.util.Scanner;

public class Dowhile {

	/*
	 * do {
    // 반복 실행할 코드
         } while (조건식);
  
   
   실행 순서:
          do { } 안의 코드를 먼저 실행
          while(조건식) 검사
          조건이 true면 다시 do 블록 실행
          조건이 false면 반복 종료
         
	 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		//사용자가 입력한 수를 계속해서 더하는 프로그램을 작성
		// 단 , 사용자가 0을 입력하면종료
		int sum=0;
		int num;
		
		do {
			num =sc.nextInt();
					sum+=num;
					
		}while(num!=0);
		
		
		System.out.println("sum: "+sum);
		
		
		
		
	}

}
