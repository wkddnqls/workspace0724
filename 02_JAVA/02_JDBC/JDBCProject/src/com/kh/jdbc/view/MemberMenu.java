package com.kh.jdbc.view;

import java.util.List;
import java.util.Scanner;

import com.kh.jdbc.controller.MemberController;
import com.kh.jdbc.model.vo.Member;

//View : 사용자와의 상호작용을 하는 객체 -> 입력및 출력
public class MemberMenu {
	boolean loop = true ; 
    private Scanner sc;
    private MemberController mc;
	public MemberMenu() {
		super();
		this.sc = new Scanner(System.in);
		this.mc = new MemberController();
	}
    /*
     * 사용자가 보게될 첫 화면 (메인화면)
     */
	public void mainMenu() {
		while(loop) {
		System.out.println("========= 회원관리 프로그램 ==============");
		System.out.println("1. 회원 추가 ");
		System.out.println("2. 회원 전체 조회");
		System.out.println("3. 회원 정보 변경");
		System.out.println("4. 회원 탈퇴 ");
		System.out.println("9. 프로그램 종료 ");
		
		System.out.println("메뉴 입력 : ");
		int sel = sc.nextInt();
		sc.nextLine();
		
		switch(sel){
		case 1 : insertMember(); break;
		case 2 : mc.selectMemberAll(); break;
		case 3 : updateMember(); break;
		case 4 : removeMeber();             break;
		case 9 :	
			System.out.println("프로그램을 종료합니다 ");
			return;
			default:
				System.out.println("잘못입력함 ");
		}
		
		
		System.out.println();
		
		
		
		}
		
		
	}
	
	
	
	public void insertMember() {
		System.out.println("====================== 회원추가 ======================");
		//id~취미까지 전부 입력받아서 회원 추가 
		System.out.println("아이디 : ");
		String userId=sc.nextLine();
		
		System.out.println("비밀번호 : ");
		String userPwd=sc.nextLine();
		
		System.out.println("이름 : ");
		String userName=sc.nextLine();
		
		System.out.println("성별 (M ,F) : ");
		String gender=sc.nextLine();
		
		System.out.println("나이 : ");
		String age=sc.nextLine();
		
		
		System.out.println("이메일 : ");
		String email=sc.nextLine();
		
		System.out.println("폰번호 : ");
		String phone=sc.nextLine();
		
		System.out.println("주소 : ");
		String address=sc.nextLine();
		
		System.out.println("취미 : ");
		String hobby=sc.nextLine();
		
		mc.insertMember(userId, userPwd, userName, gender, 
				age, email, phone, address, hobby);
	}
	
	
	public void updateMember() {
		System.out.println("====================== 회원정보변경 ======================");
		//어떤 회원의 정보를 수정할 것인가? -> USER_ID
		//변경할 정보를 입력 : 이메일 , 전화번호 , 주소 ,취미
		
		
		
		System.out.println("정보를 수정할 아이디 : ");
		String userId=sc.nextLine();
		
		
		System.out.println("변경할 이메일 : ");
		String email=sc.nextLine();
		
		System.out.println("변경할 폰번호 : ");
		String phone=sc.nextLine();
		
		System.out.println("변경할 주소 : ");
		String address=sc.nextLine();
		
		System.out.println("변경할 취미 : ");
		String hobby=sc.nextLine();
		
		
		
		mc.updateMember(userId, email, phone, address, hobby);
		
		}
	
	
	public void removeMeber() {
		System.out.println("정보를 삭제할 아이디 : ");
		String userId=sc.nextLine();
		
		System.out.println("비밀번호 입력 : ");
		String userPwd=sc.nextLine();
		
		mc.removeMember(userId,userPwd);
	}
	

	
	
	//=====================응답화면 =========================
	//서비스요청 처리 후 성공했을 때 사용자가 보게될 화면
	//msg : 기능별 제공 메세지 
	public void displaySuccess(String msg) {
		System.out.println("\n 서비스 요청 성공 : " +msg);
	}
	
	
	public void displayFail(String msg) {
		System.out.println("\n 서비스 요청 실패 : " +msg);
	}
	
	public void displayNoData(String msg) {
		System.out.println("\n " +msg);
	}
	
	public void displayList(List list , String title) {
		System.out.println("=================="+title+" ================");
	
		for (Object item : list) {
		    System.out.println(item);
		}
		
	}
}
