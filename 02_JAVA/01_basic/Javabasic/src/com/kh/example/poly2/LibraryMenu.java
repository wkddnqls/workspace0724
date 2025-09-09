package com.kh.example.poly2;

import java.util.Arrays;
import java.util.Scanner;

public class LibraryMenu {
	private Scanner sc = new Scanner(System.in);
 private LibraryController lc = new LibraryController();
 
	public void mainMenu(){
		System.out.print("이름 : ");
		String name =sc.nextLine();
		
		System.out.print("나이 : ");
		int age =sc.nextInt();
		sc.nextLine();
		
		System.out.print("성별 : ");
		char gender =sc.next().charAt(0);
		
		lc.insertMember(new Member(name,age,gender));
	
		while (true) {
            System.out.println("\n==== 도서관 메뉴 ====");
            System.out.println("1. 마이페이지");
            System.out.println("2. 도서 전체 조회");
            System.out.println("3. 도서 검색");
            System.out.println("4. 도서 대여하기");
            System.out.println("5. 프로그램 종료");
            System.out.print("메뉴 선택: ");

            int menu = sc.nextInt();
            sc.nextLine(); // 버퍼 비우기

            switch (menu) {
                case 1: 
               
                	System.out.println(lc.myInfo());
                    break;
                  
                case 2: 
                	selectAll();
                    break;
 
                case 3: 
                	searchBook();
                    break;

                case 4: 
                	rentBook();
                    break;

                case 5: // 종료
                    System.out.println("프로그램 종료");

                    return;

                default:
                    System.out.println("잘못된 메뉴 번호입니다.");
            }
            
		}}
            
            
            
            public void selectAll() {
                Book[] books = lc.selectAll();
                
                for (int i = 0; i < books.length; i++) {
                    System.out.println(i + "번 도서 : " + books[i]);
                }
            }
            
            public void searchBook() {
            	
            	System.out.println("검색할 제목 키워드 : ");
            	String name=sc.nextLine();
            	
            	Book[] result = lc.searchBook(name);
            	for (Book b : result) {
            	    System.out.println(b);
            	}
            }
            
            public void rentBook() {
            
            	System.out.println("대여할 도서 번호 선택 : ");
            	int num = sc.nextInt();
            	
            	int result = lc.rentBook(num-1);
            	
            	switch (result) {
                case 0:
                    System.out.println("성공적으로 대여되었습니다.");
                    break;
                case 1:
                    System.out.println("나이 제한으로 대여 불가능입니다.");
                    break;
                case 2:
                    System.out.println("성공적으로 대여되었습니다. 요리학원 쿠폰이 발급되었으니 마이페이지에서 확인하세요");
                    break;
            }
            sc.nextLine(); // 버퍼 비우기
        }
	}
