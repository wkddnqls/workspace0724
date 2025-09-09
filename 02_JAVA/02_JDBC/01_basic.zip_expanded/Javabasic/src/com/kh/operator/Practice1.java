package com.kh.operator;

import java.util.Scanner;

public class Practice1 {
 /*
  * 키보드로 가로 , 세로 값을 실수형으로 입력받아 사각형의 면적과 둘레를 계산하여 출력
  * 면적 : 가로 * 세로
  * 둘레 : (가로 + 세로 )*2
  * 
  * [출력]
  * 가로 : (키보드로입력)
  * 세로 : (키보드로입력)
  *
  * 면적 : ~
  * 둘레 : ~
  * +소수점 2번째 자리까지 출력
  *
  *float 쓰기 
  *
  */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
       
		
		
		System.out.print("가로 길이 입력: ");
		double num1 = sc.nextDouble();
		
		System.out.print("세로 길이 입력: ");
		double num2 = sc.nextDouble();
		
		System.out.printf("사각형의 면적 : %.2f\n",(num1*num2));
		System.out.printf("사각형의 둘래 : %.2f " , ((num1+num2)*2));
	}

}
