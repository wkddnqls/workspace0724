package com.kh.pratice.loop;

import java.util.Scanner;

public class Practice3 {
/*
 * 테스트 케이스(`T`)만큼 **두 정수 `A`와 `B`를 입력받아, 
 * 각각의 합을 출력**하는 프로그램을 작성하세요.
 * 단, 출력 형식은 `"Case #x: "` 뒤에 합을 붙여 출력해야 하며,
 *  `x`는 1부터 시작하는 **테스트 케이스 번호**입니다.
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T; // 내가 입력할 테스트 케이스의 수
		int x=0; // 테스트케이스 번호 
		int A=0; // 입력하는 정수 1
	    int B=0; // 입력하는 정수 1
		
		
		
		System.out.print("테스크 케이스의 수 입력 :  ");
		T = sc.nextInt();
		sc.nextLine();
		
		for(int i =1 ; i <=T ; i++) {
			System.out.println("입력할 정수 1 " +i+ "-" +i+": ");
			A = sc.nextInt();
			sc.nextLine();
			
			System.out.println("입력할 정수 2 " +i+ "-" +(i-1)+": ");
			B = sc.nextInt();
			sc.nextLine();
			int sum = A + B;
			
			System.out.println("Case #"+i+"= "+sum);
		}
		
	}

}
