package com.kh.example.oop7;

import java.util.Scanner;

public class ProductMenu {
	
	Scanner sc = new Scanner(System.in);
	ProductController pc = new ProductController();
	 
public void mainMenu() {
	while(true) {
	System.out.println("============ 상품 관리 메뉴 =============");
    System.out.println("1. 상품 추가");
    System.out.println("2. 상품 전체 조회");
    System.out.println("9. 종료");
    System.out.print("메뉴 번호 : ");
	int choice = sc.nextInt();
	sc.nextLine();
	System.out.println();
switch(choice) {
case 1 : 
	
	
	System.out.print("추가할 상품명 : ");
	String pName = sc.nextLine();
	
	System.out.print("추가할 상품 가격 : ");
	int price = sc.nextInt();
	sc.nextLine();
	
	System.out.print("추가할 상품 브랜드 : ");
	String brand = sc.nextLine();
	
	pc.insertProduct(pName,  price, brand);
	
	
	break;
case 2 :
	/*
	pc.selectProduct();
	
	 for (Product s : pc.selectProduct()) {
         System.out.println(s.inform());
     }
	 */
	  Product[] pro = pc.selectProduct();
	
	 for (Product s : pro) 
	 {
		 if(s!= null) {
         System.out.println(s.inform());
     }else 
     {
    	 break;
    	 }
		 }
	 
    break;
case 9 :
	System.out.println("프로그램을 종료합니다.");
	return;
default :
	System.out.println("잘못입력하셨습니다 다시입력해주세요");
}
}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
	
	
