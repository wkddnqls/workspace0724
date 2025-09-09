package com.kh.jdbc.view;

import java.util.List;
import java.util.Scanner;

import com.kh.jdbc.controller.MemberController;
import com.kh.jdbc.model.dao.MemberDao;

public class MemberMenu {
	Scanner sc = new Scanner(System.in);
	
	private MemberController mc = new MemberController();
	
	public void mainMenu() {
		
		
		while(true) {
			System.out.println("============ 회원관리 프로그램 ============");
			System.out.println("1. 회원 추가");
			System.out.println("2. 회원 전체 조회");
			System.out.println("3. 회원 정보 변경");
			System.out.println("4. 회원 탈퇴");
			System.out.println("5. 회원 이름으로 키워드 검색");
			System.out.println("6. 회원 일괄 추가");
			System.out.println("7. 회원 일괄 삭제");
			System.out.println("9. 프로그램 종료");
			
			System.out.print("메뉴 입력 : ");
			int sel = sc.nextInt();
			sc.nextLine();
			
			switch(sel) {
				case 1: insertMember(); break;
				case 2: mc.selectMemberAll();   break;
				case 3: updateMember(); break;
				case 4: deleteMember(); break;
				case 5: selectkeyword(); break;
				case 6: bulkInsertMembers(); break; //회원추가를 몇명할것인지?
				case 7:  // bulkDeleteMembers(); break; //아이디를 ,로 구분해서 입력받아서
				case 9: System.out.println("프로그램을 종료합니다."); return;
				default: System.out.println("잘못 입력하셨습니다. ");
			}
			
			System.out.println();
		}
	}

	
public void insertMember(){
	
	System.out.println(" ---------- 회원추가 --------------- ");
	System.out.println(" 아이디 : ");
	String userId= sc.nextLine();
	
	System.out.println(" 비밀번호 : ");
	String userPwd= sc.nextLine();
	
	System.out.println(" 이름 : ");
	String userName= sc.nextLine();
	
	System.out.println(" 성별(M,F) : ");
	String gender= sc.nextLine();
	
	System.out.println(" 나이 : ");
	String age= sc.nextLine();
	
	System.out.println(" 이메일 : ");
	String emall= sc.nextLine();
	
	System.out.println(" 핸드폰번호 : ");
	String phone= sc.nextLine();
	
	System.out.println(" 주소 : ");
	String address= sc.nextLine();
	
	System.out.println(" 취미 : ");
	String hobby= sc.nextLine();
	
	
	mc.insertMember(userId, userPwd, userName, gender, 
			age, emall, phone, address, hobby);
	
}







public void updateMember() {
	System.out.println(" ----------업데이트 --------------- ");
	System.out.println(" 수정할 아이디 : ");
	String userId= sc.nextLine();
	
	
	System.out.println(" 이메일 : ");
	String emall= sc.nextLine();
	
	System.out.println(" 핸드폰번호 : ");
	String phone= sc.nextLine();
	
	System.out.println(" 주소 : ");
	String address= sc.nextLine();
	
	System.out.println(" 취미 : ");
	String hobby= sc.nextLine();
	
	mc.updateMember(userId,
			emall, phone, address, hobby);
}

public void deleteMember() {
	System.out.println(" ---------- 회원삭제 --------------- ");
	System.out.println(" 삭제할 아이디 : ");
	String userId= sc.nextLine();
	
	
	System.out.println("  비밀번호 : ");
	String userPwd= sc.nextLine();
	
	
	
	
	mc.deleteMember(userId,
			userPwd);	
	
}

public void selectkeyword() {
	System.out.println(" 찾을 이름  : ");
	String userName= sc.nextLine();
	
	
	
	mc.selectkeyword(userName
			);	
	
}




public void bulkInsertMembers() {
	
	
	System.out.println(" 추가할회원수 :  ");
	int num= sc.nextInt();
	sc.nextLine();
	
for(int i=0 ; i<num ; i++) {
	System.out.println(" ---------- 회원추가 --------------- ");
	System.out.println(" 아이디 : ");
	String userId= sc.nextLine();
	
	System.out.println(" 비밀번호 : ");
	String userPwd= sc.nextLine();
	
	System.out.println(" 이름 : ");
	String userName= sc.nextLine();
	
	System.out.println(" 성별(M,F) : ");
	String gender= sc.nextLine();
	
	System.out.println(" 나이 : ");
	String age= sc.nextLine();
	
	System.out.println(" 이메일 : ");
	String emall= sc.nextLine();
	
	System.out.println(" 핸드폰번호 : ");
	String phone= sc.nextLine();
	
	System.out.println(" 주소 : ");
	String address= sc.nextLine();
	
	System.out.println(" 취미 : ");
	String hobby= sc.nextLine();
	
	
	mc.insertMember2(userId, userPwd, userName, gender, 
			age, emall, phone, address, hobby);
	
	
	
}
	
	
	
}










































public static void displayList(List list , String title) {
	System.out.println("=================="+title+" ================");

	for (Object item : list) {
	    System.out.println(item);
	}
	
}








}



















