package com.kh.jdbc.controller;

import java.util.ArrayList;
import java.util.List;


import com.kh.jdbc.model.vo.Member;
import com.kh.jdbc.service.MemberService;
import com.kh.jdbc.view.MemberMenu;

/*
 * Controller : View를 통해서 사용자가 요청한 기능에 대해 처리하는 객체
 *              해당 메서드로 전달된 데이터를 가공한 후 dao로 전달하여 기능을 수행.
 *              dao로부터 반환받은 결과에 따라서 성공/실패 여부를 판단해서 응당화면을 결정 
 *              -> View호출
 */
public class MemberController {
private MemberService ms = new MemberService();
	
	public MemberController() {
		super();

	}
    
	/*
 * 사용자의 추가요청을 처리하는 메서드
 *  userId~hobby : 사용자가 입력한 정보를 매개변수로 받음
 */
	
	public void insertMember(String userId, String userPwd, 
			String userName, String gender, String age, String emall,
			String phone, String address, String hobby) {
	   
		
		//view로 부터 전달받은 값을 바로 dao에 전달x
		//vo에 잘 담아서 전달
		Member m = new Member(userId, userPwd,userName,gender , 
				Integer.parseInt(age) ,emall , phone ,address , hobby);
		
	int result = ms.insertMember(m);
	
	if(result>0) {
		   new MemberMenu().displaySuccess("성공적으로 회원이 추가되었습니다 ");
	   }else {
		   new MemberMenu().displayFail("회원추가에 실패했습니다  ");
	   }
   }
	
	
	//회원을 모두 조회
	public void selectMemberAll() {
		
		
		List<Member> list = ms.selectMemberList();
		
		if(list.isEmpty()) {
			new MemberMenu().displayNoData("회원목록 조회 결과가 없습니다");
		} else
		{
			new MemberMenu().displayList( list ,"회원조회 완료 ");
		}

	
	
	
	}
	
	
	public void updateMember(String userId ,  String emall , String phone , String address,String hobby) {
		
	Member m = new Member();
	
	m.setUserId(userId);
	m.setEmall(emall);
	m.setPhone(phone);
	m.setAddress(address);
	m.setHobby(hobby);
	
	int result = ms.updateMember(m);
	
	if(result>0) {
		   new MemberMenu().displaySuccess("성공적으로 회원이 수정되었습니다 ");
	   }else {
		   new MemberMenu().displayFail("회원수정에 실패했습니다  ");
		   
		
		   
	   }

	
	
	}
	
	
	public void removeMember(String userId , String userPwd) {
		Member m = new Member();
		
		m.setUserId(userId);
		m.setUserPwd(userPwd);
		
		int result = ms.removeMember(m);
		
		if(result>0) {
			   new MemberMenu().displaySuccess("성공적으로 회원이 삭제되었습니다 ");
		   }else {
			   new MemberMenu().displayFail("회원삭제에 실패했습니다  ");
			   
			
			   
		   }
		
		
		
		
		
	}
	
	
	
	public void keywordselect(String userName) {
     
    ArrayList<Member> list = ms.keywordselect(userName);
		
    if(list.isEmpty()) {
		new MemberMenu().displayNoData("회원목록 조회 결과가 없습니다");
	} else
	{
		new MemberMenu().displayList( list ,"회원조회 완료 ");
	}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
