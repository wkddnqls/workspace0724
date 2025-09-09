package com.kh.example.collection3;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class MemberMenu {
	MemberController mc = new MemberController();
	Scanner sc = new Scanner(System.in);

    public void mainMenu() {
        /*
         ******* 메인 메뉴 *******
           1. 회원가입  // joinMembership() 실행
           2. 로그인  // logIn() 실행 후 memberMenu() 실행
           3. 같은 이름 회원 찾기 // sameName()
           9. 종료   // “프로그램 종료.” 출력 후 main()으로 리턴
           메뉴 번호 선택 : >> 입력 받음
           // 메뉴 화면 반복 실행 처리
           // 잘 못 입력 하였을 경우 "잘못 입력하였습니다. 다시 입력해주세요" 출력 후 반복
        */
    	 while(true) {
 	    	System.out.println("==========KH 사이트 저장프로그램 ==========");
 	       
 	            System.out.println("***** 메인 메뉴 *****");
 	            System.out.println("1. 회원가입   ");
 	            System.out.println("2. 로그인   ");
 	            System.out.println("3. 같은 이름 회원 찾기  ");
 	            System.out.println("9. 종료");
 	            System.out.println("메뉴 번호 입력 :  ");
 	           int a = sc.nextInt();
 	           sc.nextLine();
 	           switch(a) {
 	           case 1 :
 	        	  joinMembership();
 	         	  break;
 	           case 2 :
 	        	  logIn();
 	               break;
 	           case 3 :
 	        	  sameName();
 	         	  break;  
 	           case 9 :
 	         	  System.out.println("프로그램 종료입니다. ");
 	         	  return; 
 	           default :
 	         	  System.out.println("잘못 입력하셨습니다 다시입력해주세요 \n ");
 	           }
 	    }
    }

    public void memberMenu() {
        /*
         ******* 회원 메뉴 *******
           1. 비밀번호 바꾸기 // changePassword() 실행
           2. 이름 바꾸기  // changeName()
           3. 로그아웃  // “로그아웃 되었습니다.” 출력 후 mainMenu()로 리턴
           메뉴 번호 선택 : >> 입력 받음
           // 메뉴 화면 반복 실행 처리
           // 잘 못 입력 하였을 경우 "잘못 입력하였습니다. 다시 입력해주세요" 출력 후 반복
        */
    	 while(true) {
    	System.out.println("******* 회원 메뉴 *******");
         System.out.println("1. 비밀번호 바꾸기   ");
         System.out.println("2. 이름 바꾸기  ");
         System.out.println("3. 로그아웃  ");
         System.out.println("메뉴 번호 입력 :  ");
        int a = sc.nextInt();
        sc.nextLine();
        
        switch(a) {
        case 1 :
        	changePassword();
      	  break;
        case 2 :
        	changeName();
            break;
      
        case 3 :
      	  System.out.println("로그아웃 메뉴로 돌아갑니다 ");
      	   
      
      	 return;
        default :
      	  System.out.println("잘못 입력하셨습니다 다시입력해주세요 \n ");
        }
 }
    }

    public void joinMembership() {
        /*
          회원가입하기 위해 아이디, 비밀번호, 이름을 받고 비밀번호와 이름은
          Member객체에 담고 id와 객체는 MemberController(mc)의 joinMembership()로 보냄.
          받은 결과에 따라 true면 “성공적으로 회원가입 완료하였습니다.”,
          false면 “중복된 아이디입니다. 다시 입력해주세요.” 출력
        */
    	System.out.print("아이디: ");
        String id = sc.nextLine();

        System.out.print("비밀번호: ");
        String password = sc.nextLine();

        System.out.print("이름: ");
        String name = sc.nextLine();
        
        // Member 객체 생성
        Member m = new Member(name, password); 
       

        // 컨트롤러에 전달
        boolean result = mc.joinMembership(id, m);

        if (result) {
            System.out.println("성공적으로 회원가입 완료하였습니다.");
        } else {
            System.out.println("중복된 아이디입니다. 다시 입력해주세요.");
        }
    }

    public void logIn() {
        /*
           아이디와 비밀번호를 사용자에게 받아 mc의 logIn()메소드로 넘겨 줌
           반환 값 있으면 “OOO님, 환영합니다!” 출력 후 로그인 된 화면으로(memberMenu()),
           없으면 “틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요.” 출력 후 반복
        */
    	 while (true) {
             System.out.print("아이디: ");
             String id = sc.nextLine();

             System.out.print("비밀번호: ");
             String password = sc.nextLine();

             String name = mc.logIn(id, password);

             if (name != null) { // 로그인 성공
                 System.out.println(name + "님, 환영합니다!");
                 memberMenu();  // 로그인 후 화면으로 이동
                 break; // 반복 종료
             } else { // 로그인 실패
                 System.out.println("틀린 아이디 또는 비밀번호입니다. 다시 입력해주세요.");
             }
         }
    }

    public void changePassword() {
        /*
           아이디와 비밀번호, 변경할 비밀번호를 받아 mc의 chagePassword()로 보냄.
           받은 결과 값이 true면 “비밀번호 변경에 성공했습니다.”,
           false면 “비밀번호 변경에 실패했습니다. 다시 입력해주세요.” 출력 후 반복
        */
    	 while (true) {
             System.out.print("아이디 입력: ");
             String id = sc.nextLine();

             System.out.print("현재 비밀번호 입력: ");
             String oldPw = sc.nextLine();

             System.out.print("변경할 비밀번호 입력: ");
             String newPw = sc.nextLine();

             boolean result = mc.changePassword(id, oldPw, newPw);

             if (result) {
                 System.out.println("비밀번호 변경에 성공했습니다.");
                 break; // 성공 시 반복 종료
             } else {
                 System.out.println("비밀번호 변경에 실패했습니다. 다시 입력해주세요.");
             }
         }
     }
    

    public void changeName() {
        /*
           아이디와 비밀번호를 받아 mc의 logIn()으로 넘겨 현재 저장되어 있는 이름을 받고
           사용자에게 현재 저장되어 있는 이름을 출력하여 보여줌.
           변경할 이름을 받아 mc의 chageName()로 id와 함께 넘기고
           “이름 변경에 성공하였습니다.” 출력
           만일 logIn()로부터 저장되어 있는 이름을 받지 못 했다면
           “이름 변경에 실패했습니다. 다시 입력해주세요” 출력 후 반복
        */
    	while (true) {
            System.out.print("아이디 입력: ");
            String id = sc.nextLine();

            System.out.print("비밀번호 입력: ");
            String password = sc.nextLine();

            // 로그인 후 현재 이름 받기
            String currentName = mc.logIn(id, password);

            if (currentName != null) {
                System.out.println("현재 저장된 이름: " + currentName);
                System.out.print("변경할 이름 입력: ");
                String newName = sc.nextLine();

                mc.changeName(id, newName);
                System.out.println("이름 변경에 성공하였습니다.");
                break; // 성공 시 반복 종료
            } else {
                System.out.println("이름 변경에 실패했습니다. 다시 입력해주세요.");
            }
        }
        
    }

    public void sameName() {
        /*
           검색할 이름을 받고 mc의 sameName()메소드로 넘김.
           반환 값을 가지고 entrySet()을 이용하여 ‘이름-아이디’ 형식으로 출력
        */
    	System.out.print("검색할 이름 입력: ");
        String name = sc.nextLine();

        TreeMap<String, String> result = mc.sameName(name);

        if (result.isEmpty()) {
            System.out.println("해당 이름을 가진 회원이 없습니다.");
        } else {
            // entrySet()으로 출력
            for (Map.Entry<String, String> entry : result.entrySet()) {
                System.out.println(entry.getValue() + " - " + entry.getKey());
            }
        }
    
    }
}


