package com.kh.controller;

import java.util.Scanner;

public class Practice2 {

	/*
	 * 성별을 (m/f)(대소문자 상관x)로 입력받아 남학생인지 여학생인지
	 * 출력하는 프로그램을 작성해라
	 * 
	 * [출력]
	 * 성별(m/f) :x
	 * 여학생입니다/남학생입니다/잘못입력하셨습니다 
	 */
	public static void main(String[] args) {
		
      Scanner sc= new Scanner(System.in);
      char gender;
      
      
      System.out.print("성별(m/f) : ");
      gender = sc.next().charAt(0);
      
      
      
      switch (gender) {
      case 'm', 'M' : 
    	  System.out.println("남학생");
      break;
      case 'f','F' : 
    	  System.out.println("여학생");
          break;
          default:System.out.println("다시");
        	  
      }
      
      
      
	}

}

// sc.next() . toUpperCase() . charAt(0);
// 문자열 입력 . 대문자로 모두 변경 . 맨앞글자추출
//toUpperCase() :대문자로 모두 변경
//toLowerCase() :소문자로 모두 변경









