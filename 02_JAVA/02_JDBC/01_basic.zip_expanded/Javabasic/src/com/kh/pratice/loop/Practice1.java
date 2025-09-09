package com.kh.pratice.loop;

import java.util.Scanner;

public class Practice1 {
/*
 * 정수 N(1 ≤ N ≤ 9)이 주어졌을 때, N 단 구구단을 1부터 9까지 출력하는 프로그램을 작성하세요. 
 * 출력 형식은 N * i = 결과이며, 각 줄마다 i가 1부터 9까지 하나씩 증가합니다. 
 * 공백과 기호 표현에 주의하세요
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int dan;
		
		System.out.print("dan을 입력하세요 :  ");
		dan = sc.nextInt();
		
		for(int i= 1 ; i<10 ; i++ ) {
			System.out.println(dan + "*" +i+ "=" +(dan*i));
		}
		
	}

}
