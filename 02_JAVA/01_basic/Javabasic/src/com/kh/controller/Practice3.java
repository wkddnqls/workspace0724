package com.kh.controller;

import java.util.Scanner;

public class Practice3 {
/*
 * 정수(양수)를 입력받아
 * 짝수인지 홀수인지 출력하는 프로그램
 * 
 * [출력]
 * 정수 입력 :
 * 짝수다 /홀수다 / 양수가아니다
 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int num1;
		System.out.print("정수 입력: ");
		num1 = sc.nextInt();
	
		if(num1 > 0) {
			if(num1 %2 ==0) {
				System.out.print("짝수입니다 ");
			}else {
				System.out.print("홀수입니다 ");
			}
			
		} else {
			System.out.print("양수가 아닙니다");
		}
		
	
		
		
	}

}
