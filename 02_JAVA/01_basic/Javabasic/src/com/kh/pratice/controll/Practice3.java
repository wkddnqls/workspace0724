package com.kh.pratice.controll;

import java.util.Scanner;

public class Practice3 {
/*
 *  놀이공원 요금 계산기
 *
 *나이 요일 어린이 청소년 성인
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int age;
		String day;
		String name1;
		double money = 0.0;
		System.out.print("나이를 입력하세요 : ");
		age = sc.nextInt();
		sc.nextLine();
		
		
		System.out.print("요일을 입력하세요 : ");
		day = sc.nextLine();
		
		if(age>0 && age<=13) {
			name1 = "어린이";
			money = 5000;
	   }else if (age>13 && age<=18){
		   name1 = "청소년";
			money = 7000;   
	   }else if (age>=19 ) {
		   name1 = "성인";
			money = 10000; 
	   }else {
		   name1 = "외계인";
		   
			money = 0;
			return;
	   }
      
		switch (day) {
	    case "월":
	    case "화":
	    case "수":
	    case "목":
	    case "금":
	        money *= 1;
	        break;
	    case "토":
	    case "일":
	        money *= 0.8;
	        break;
	    default:
	        System.out.println("요일 잘못 입력하셨습니다.");
	        return;
	} // if(day.equals("토") || day.equals("일") )
		if (day =="토" || day=="일" ) {
			System.out.println(name1 + "요금입니다.(주말 할인 적용)"  );
			System.out.printf("최종 요금은 %.0f원 입니다.\n", money);
		}else {
		System.out.println(name1 + "요금입니다 (주말 할인 미적용)" );
		System.out.printf("최종 요금은 %.0f원 입니다.\n", money);
	}

}}
