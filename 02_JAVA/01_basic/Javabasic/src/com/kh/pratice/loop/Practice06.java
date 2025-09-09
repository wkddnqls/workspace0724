package com.kh.pratice.loop;

import java.util.Scanner;

public class Practice06 {
/*
 * 사용자로부터 10개의 정수를 입력받아, 
 *  **짝수일 경우에만 제곱을 출력**하는 프로그램을 작성하세요.
 *  홀수는 건너뛰고 출력하지 않습니다.
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		System.out.printf("숫자 입력 : ");
		num =sc.nextInt();
		
		for(int i =1 ; i <=10; i++) {
			System.out.printf("숫자 입력 : ");
			num =sc.nextInt();
			if(num%2==0) {
				System.out.println("짝수 "+num+"제곱은 "+(num*num)+"입니다");
			}
			
			
		}
		
		sc.close();
	}

}
