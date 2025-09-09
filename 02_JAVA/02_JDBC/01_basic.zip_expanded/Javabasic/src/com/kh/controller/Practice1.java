package com.kh.controller;

import java.util.Scanner;

public class Practice1 {

	
	
	public static void main(String[] args) {
	Scanner sc = new Scanner(System.in);
			
	/*
			 * 나이를 입력받아 
			 * 13세 이하면 : 어린이
			 * 13세 초과 19세 이하면 : 청소년
			 * 19세 초과 : 성인
			 * [출력]
			 * 나이를 입력 :
			 * ??은???에 속합니다
			 */
    int age = 0;
	System.out.print("나이를 입력 : ");
	age = sc.nextInt();
	String grade;
	if(age>0 && age<= 13) {
		grade="어린이";
		}else if(age>13 && age <=19) {
			grade="청소년";
		}else if(age>19) {
			grade="성인";
		}else {
			grade ="외계인";
		}
	
	System.out.println(age+ "살은 " +grade+"에 속합니다");
	
	}

}
