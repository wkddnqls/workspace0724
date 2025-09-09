package com.kh.jdbc.controller;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.jdbc.common.JDBCTemplate;
import com.kh.jdbc.model.dao.MemberDao;
import com.kh.jdbc.model.vo.Member;
import com.kh.jdbc.service.MemberService;
import com.kh.jdbc.view.MemberMenu;

public class MemberController {
	private MemberService ms = new MemberService();
	
	public MemberController() {
		super();

	}
	
	public void insertMember(String userId, String userPwd, 
			String userName, String gender, String age, String emall,
			String phone, String address, String hobby) {
	   
		
		//view로 부터 전달받은 값을 바로 dao에 전달x
		//vo에 잘 담아서 전달
		Member m = new Member(userId, userPwd,userName,gender , 
				Integer.parseInt(age) ,emall , phone ,address , hobby);
		
	int result = ms.insertMember(m);
	
	
	if(result>0) {
		   System.out.println("성공적으로 회원이 추가되었습니다 ");
	   }else {
		   System.out.println(" 회원 추가실패습니다 ");
	   }
   }
	
	





public void selectMemberAll() {
	ArrayList<Member> list = ms.selectMemberAll();
	
	if(list.isEmpty()) {
		   System.out.println(" 회원 조회 실패했습니다 ");
	   }else {
		   MemberMenu.displayList(list, "조회완료");
	   }
	
}

public void updateMember(String userId ,String emall,
		String phone, String address, String hobby) {
   
	
Member m = new Member();
	
	m.setUserId(userId);
	m.setEmall(emall);
	m.setPhone(phone);
	m.setAddress(address);
	m.setHobby(hobby);
	
int result = ms.updateMember(m);


if(result>0) {
	   System.out.println("성공적으로  수정되었습니다 ");
   }else {
	   System.out.println(" 회원 수정실패습니다 ");
   }
}


public void deleteMember(String userId ,
		String userPwd) {
   
	
Member m = new Member();
	
	m.setUserId(userId);
	m.setUserPwd(userPwd);
	
int result = ms.deleteMember(m);


if(result>0) {
	   System.out.println("성공적으로  삭제되었습니다 ");
   }else {
	   System.out.println(" 회원 삭제실패습니다 ");
   }
}


public void selectkeyword(String userName) {

	
	ArrayList<Member> list = ms.selectkeyword(userName);
	
	if(list.isEmpty()) {
		   System.out.println(" 회원 조회 실패했습니다 ");
	   }else {
		   MemberMenu.displayList(list, "조회완료");
	   }
	
}


public void insertMember2(String userId, String userPwd, 
		String userName, String gender, String age, String emall,
		String phone, String address, String hobby) {
   
	
	//view로 부터 전달받은 값을 바로 dao에 전달x
	//vo에 잘 담아서 전달
	Member m = new Member(userId, userPwd,userName,gender , 
			Integer.parseInt(age) ,emall , phone ,address , hobby);
	
int result = ms.insertMember(m);


if(result>0) {
	   System.out.println("성공적으로 회원이 추가되었습니다 ");
   }else {
	   System.out.println(" 회원 추가실패습니다 ");
   }
}










}