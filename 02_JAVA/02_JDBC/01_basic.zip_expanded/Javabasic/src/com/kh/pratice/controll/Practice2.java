package com.kh.pratice.controll;

import java.util.Scanner;

public class Practice2 {
 /*
  * 1~6까지 주사위던지고 상금계산 프로그램작성
  * 
  * 한줄에 3개의 정수 (각각 주사위 눈 1~6) 공백으로 구분하여 입력
  * 
  * 
  */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("주사위 눈 입력: ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		int result = 0;

	if(a==b && b==c) {
		result = (10000+ a*1000);
	}else if(a == b || a == c) {
		result = 1000 + a * 100;
		
	}else if(b == c) {
		result = 1000 + b * 100;
	}else {
		int max1 = Math.max((Math.max(a,b)),c);
		result = max1*100;
	}
System.out.println(result);
	}
	//java에서 제공해주는 수학함수
	
	// java.lang/math-> 코드를 작성한떄 기본적으로 유용한것들을 담아서 제공
	//Math.max(n1, n2) 둘중큰값 반환
	
	
	}
	
	

