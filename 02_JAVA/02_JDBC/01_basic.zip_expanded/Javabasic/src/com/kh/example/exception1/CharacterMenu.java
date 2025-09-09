package com.kh.example.exception1;

import java.util.Scanner;

public class CharacterMenu {
	CharacterController t = new CharacterController();
	Scanner sc = new Scanner(System.in);
	
	public void menu() {
		
		System.out.print("입력 : ");
		String a = sc.nextLine().toUpperCase();
		
		try {
			 int result = t.countAlpha(a);   // 반환값 저장
	            System.out.println("영문자 개수 : " + result);
		} catch (CharCheckException e) {
			
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		
	
		
	}
}
