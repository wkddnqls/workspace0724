package com.kh.controller;

import java.util.Scanner;

public class Switch {
/*
 *  switch문도 if문과 동일하게 조건문
 *  
 *  다만, switch문은 값이 정확하게 일치(동등비교)하는 경우에만 사용 됨
 *  
 *  [표현식]
 *  
 *  switch(비교대상(정수,문자,문자열)){
 *  case 값1 : 실행코드;
 *  case 값2 : 실행코드;
 *  case 값3 : 실행코드;
 *  ...
 *  default : 위의 값이 전부 일치하지 않았을 때 실행할 코드;
 *  
 *  break -> switch문 내에서 사용하면 해당코드가 실행되고 동시에 가장가까운 switch문을 종료
 *  
 *  }
 *  
 * 
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
	
	/*Line
	 * 정수를 입력받아서
	 * 1일경우 빨간식입니다.
	 * 2일경우 파란색입니다.
	 * 3일경우 초록색입니다
	 * 다른경우 모두 잘못입력했습니다.
	
	 */
		/*
    System.out.print("정수 입력 : ");
	int num1 = sc.nextInt();	
		
	switch (num1) {
	case 1 : System.out.println("빨간색입니다"); break;
	case 2 : System.out.println("파란색입니다"); break;
	case 3 : System.out.println("초록색입니다"); break;
	default: System.out.println("잘못입력하셨습니다"); 
	}  
		/*
		 * 과일을 구매하는 프로그램을 작성하자
		 * 구매하고자하는 과일을 입력하면
		 * 구에맞는 가격이 출력되는 프로그램
		 * 
		 * [출력]
		 * 구매하고자하는 과일
		 * (사과 2000 , 바나나 3000 , 딸기 5000)
		 * :xxx의 가격은 xxx입니다 . 출력/ 잘못입력하셨습니다
		 */
/*	System.out.print("과일 입력 : ");
	String num2 = sc.next();
	
		switch (num2) {
		case "사과": System.out.println(num2 + "의 가격은 2000원 입니다"); break;
		case "바나나" : System.out.println(num2 + "의 가격은 3000원 입니다"); break;
		case "딸기" : System.out.println(num2 + "의 가격은 5000원 입니다"); break;
		default: System.out.println("잘못입력하셨습니다"); 
		} 
	}

}
*/

/*
 * int price = 0 
 * 
 * switch (num2) {
		case "사과": price = 2000:
		 break;
		case "바나나" : price = 3000:
		 break;
		case "딸기" : price = 5000:
		  break;
	if(price==0){
	System.out.println("잘못입력하셨습니다"); 
	}else{
	System.out.println(num2 의 가격은 price 입니다 ); 
	}
		 
 * 
 */

/*
 * 월을 입력받아서 해당월에 마지막일이 며칠인지를 출력하는 프로그램 작성
 * 
 * [출력]
 * 월을 입력하세요 : xx
 * xx월은 xx일까지 있습니다.
 * 
 * 1,3,5,7,8,10,12 -> 31일
 * 2 -> 28일
 * 4,6,9,11 -> 30일
 * 
 */
int num3,num4 =0;
		 System.out.print("월 입력 : ");
			num3 = sc.nextInt();
		    
			
			
			switch (num3) {
		case 1,3,5,7,8,10,12:
			num4 = 31;
	
		 break;
		case 2 :
			num4 = 28;
			
		 break;
		case 4,6,9,11 :
			num4 = 30;
		
		  break;
		 
			}
			if(num3 >12 || num3<0) {
				System.out.println(num3+ "월은 없습니다" );
			}else {
			System.out.println(num3+ "월은 " +num4+"일까지 있습니다");

			}










	}}





