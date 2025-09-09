package com.kh.pratice.controll;

import java.util.Scanner;

public class Practice1 {
/*
 * 0점부터 100점 사이의 정수를 입력받아 아래조건에 따라 
 * 등급(학점) 을 출력하는 프로그램 작성
 * 
 * 입력 조건 -> 시험점수 (정수형 0 이상 100이하)
 */
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score;
		String level;
		System.out.print("점수를 입력하세요: ");
		score = sc.nextInt();

		
		if(score >= 90 && score<=100) {
	       level = "A";
       }else if (score >= 80 && score<=89) {
    	   level ="B";
       }else if (score >= 70 && score<=79) {
    	   level = "C";
       }else if (score >= 60 && score<=69) {
    	   level = "D";
       }else if (score >= 0 && score<=59) {
    	   level = "F";
       }else {
    	   level="측정불가";       }
		
		System.out.println("당신의 성적은"+level+ "입니다");
	}

}
