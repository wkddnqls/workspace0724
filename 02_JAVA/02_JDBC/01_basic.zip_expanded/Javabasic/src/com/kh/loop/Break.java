package com.kh.loop;

import java.util.Scanner;

public class Break {

	/*
	 * break: 반복문, switch문 안에서 사용되는 분기문
	 * break;가 실행되는순간 가장가까운 반복문 switch를 강제로 탈출한다
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
	
	//랜덤값(1~100)을 발생시켜 출력 (이과정을 계속반복)
	// 단, 랜덤값이 3의배수(3으로 나누명 0)일 경우 반복문 종료
		/*
		while(true) {
			int num = (int)(Math.random()*100)+1;
			System.out.println(num);
			if(num%3==0) {
				break;
				
			}
		}
		*/
		//로또번호 추천 1~45까지 중 랜덤하게 6개 추출
		for(int i=0;i<6;i++) {
			int num = (int)(Math.random()*45)+1;
			System.out.print(num+" ");
		 if(i==5) {
			 break;
		 }
		}
		 
	
	
	
	
	}

}
