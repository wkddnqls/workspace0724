package com.kh.example.collection2;

import java.util.HashSet;
import java.util.Scanner;

public class LotteryMenu {
	 private final Scanner sc = new Scanner(System.in);
	    private final LotteryController lc = new LotteryController();
	   
	    public void mainMenu() {
	    	 while(true) {
	    	System.out.println("========== KH 추첨 프로그램 ==========");
	       
	            System.out.println("***** 메인 메뉴 *****");
	            System.out.println("1. 추첨 대상 추가  ");
	            System.out.println("2. 추첨 대상 삭제  ");
	            System.out.println("3. 당첨 대상 확인  ");
	            System.out.println("4. 정렬된 당첨 대상 확인");
	            System.out.println("5. 당첨 대상 검색 ");
	            System.out.println("9. 종료  ");
	            System.out.println("메뉴 번호 입력 :  ");
	           int a = sc.nextInt();
	           sc.nextLine();
	           switch(a) {
	           case 1 :
	        	   insertObject();
	         	  break;
	           case 2 :
	        	   deleteObject();
	               break;
	           case 3 :
	        	   winObject();
	         	  break;
	           case 4 :
	        	   sortedWinObject();
	         	  break;
	           case 5 :
	        	   searchWinner();
	         	  break;
	           case 9 :
	         	  System.out.println("프로그램 종료입니다. ");
	         	  return; 
	           default :
	         	  System.out.println("잘못 입력하셨습니다 \n ");
	           }
	    }}

	    public void insertObject() {
	    	System.out.print("추가할 대상자 수: ");
	        int n = Integer.parseInt(sc.nextLine());

	        for (int i = 0; i < n; ) {
	            System.out.print((i + 1) + "번째 이름: ");
	            String name = sc.nextLine();

	            System.out.print((i + 1) + "번째 폰 번호: ");
	            String number = sc.nextLine();

	            Lottery l = new Lottery(name, number);

	            // 중복 시 재입력 유도
	            if (!lc.insertObject(l)) {
	                System.out.println("중복된 대상입니다. 다시 입력해주세요.");
	            } else {
	                System.out.println("추가 완료");
	                i++; // 성공적으로 추가된 경우만 카운트 증가
	            }    
	    }}

	    public void deleteObject() {
	    	System.out.print("삭제할 이름: ");
	        String name = sc.nextLine();

	        System.out.print("삭제할 번호: ");
	        String number = sc.nextLine();

	        Lottery l = new Lottery(name, number);

	        boolean result = lc.deleteObject(l);

	        if (result) {
	            System.out.println("삭제 완료되었습니다.");
	        } else {
	            System.out.println("존재하지 않는 대상입니다.");
	        }
	    }
	    

	    public void winObject() {
	    	HashSet win = lc.winObject();
	    	System.out.println(win);
	        // lc.winObject() 반환 Set을 println으로 출력
	    }

	    public void sortedWinObject() {
	        // lc.sortedWinObject() 반환 TreeSet을 Iterator로 순회 출력
	    }

	    public void searchWinner() {
	    	System.out.println("검색할 대상의 이름과 핸드폰 번호를 입력하세요. ");
	    	System.out.print("이름 : ");
	    	String name = sc.nextLine();

	        System.out.print("번호: ");
	        String phone = sc.nextLine();
	        
	        boolean isWin = lc.searchWinner(new Lottery(name,phone));
	        
	        if(isWin) {
	        	System.out.println("축하 당첨 ");
	        }else
	        {
	        	System.out.println("당첨 안되셧네요 ");
	        }
	    }
	}




