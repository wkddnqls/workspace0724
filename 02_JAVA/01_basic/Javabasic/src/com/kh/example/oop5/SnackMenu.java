package com.kh.example.oop5;

import java.util.Scanner;

public class SnackMenu {
	private Scanner sc = new Scanner(System.in);
	private SnackController scr = new SnackController();
	
	public void menu() {
	
		
		System.out.println("스낵류를 입력하세요.");
	    
		
		System.out.print("종류 : ");
		String kind = sc.nextLine();
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("맛 : ");
		String flavor = sc.nextLine();
		System.out.print("개수 : ");
		int numOf = sc.nextInt();
		sc.nextLine();
		System.out.print("가격 : ");
		int price = sc.nextInt();
		sc.nextLine();
		
	
		System.out.println(scr.saveData(kind, name, flavor, numOf, price));

	scr.confirmData();
	System.out.print("저장 정보 확인? (y/n): ");
	String a = sc.nextLine();
	
	if(a.equals("y")) {
		System.out.print(scr.confirmData());
	}else {
		return;
	}
	
	}
	
	
	
	
	
	
}
