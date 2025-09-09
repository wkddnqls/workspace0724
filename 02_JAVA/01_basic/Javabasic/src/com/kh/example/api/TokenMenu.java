package com.kh.example.api;

import java.util.Scanner;

public class TokenMenu {
	Scanner sc = new Scanner(System.in);
	TokenController tc = new TokenController();
	
    public void mainMenu() {
    	
    	while(true) {
    	
    	System.out.print("1. 지정 문자열 ");
    	System.out.println();
    	System.out.print("2. 입력 문자열 ");
    	System.out.println();
    	System.out.print("3. 프로그램 끝내기 ");
    	System.out.println();
    	System.out.println("선택 번호 입력 :  ");
    	int a = sc.nextInt();
    	sc.nextLine();
    	
    	
    	switch(a) {
    	
    	case 1 : 
    		tokenMenu();
    		break;
    	case 2 : 
    		inputMenu();
    		break;
    	case 3 : 
    		System.out.println("프로그램을 종료합니다 ");
    		return;
    	default:
    		System.out.println("잘못 입력하셨습니다 다시 입력하세요.");
    	
    	
    	
    	
    	}
    	
    	}
    	
    } 
    	
    	
    	public void tokenMenu() {
    		String str = "J a v a P r o g r a m";

    		 System.out.println("=== 토큰 처리 전 ===");
    	        System.out.println("원문: " + str);
    	        System.out.println("글자 수(공백 포함): " + str.length());
    		
    	        String[] after = tc.afterToken(str);
    	        
    	        System.out.println("\n=== 토큰 처리 후 ===");
    	       for(int i = 0 ; i<after.length;i++) {
    	        System.out.print(after[i]);
    	       }
    	       System.out.println();
    	        System.out.println("글자 수: " + after.length);

    	        // 모두 대문자
    	        System.out.println("\n=== 모두 대문자 ===");
    	        System.out.println(after.length);
    	        System.out.println("---------------------------------------");
    	}
    	
    	
    	
    	public void inputMenu() {
    		Scanner sc = new Scanner(System.in);

            // 1) 문자열 입력받기
            System.out.print("문자열을 입력하세요 : ");
            String input = sc.nextLine();

            String firstCapStr = tc.firstCap(input);
            System.out.println("첫 글자 대문자 : " + firstCapStr);

            // 2) 문자 입력받기
            System.out.print("찾을 문자 하나를 입력하세요 : ");
            char ch = sc.nextLine().charAt(0);

            int count = tc.findChar(input, ch);
            System.out.println(ch + " 문자가 들어간 개수 : " + count);
            System.out.println("---------------------------------------");
        
    	}
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
  































}
