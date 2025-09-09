package com.kh.jdbc.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.kh.jdbc.common.JDBCTemplate.*;
import com.kh.jdbc.common.JDBCTemplate;
import com.kh.jdbc.model.dao.MemberDao;
import com.kh.jdbc.model.vo.Member;

public class MemberService {
	private MemberDao md = new MemberDao();
	private JDBCTemplate jd = new JDBCTemplate();
	
     public int insertMember(Member m ) {
    	
    	 Connection conn = jd.go();
    	
    	 int result = md.insertMember(m,conn);
    	 
    	 if(result>0) {
    		 commit(conn);
    	 }else {
    		 rollback(conn);
    	 }
    	     close(conn);
    	
    	 return result;
    	 
     }


public ArrayList<Member> selectMemberAll(){
	Connection conn = jd.go();
	
	 ArrayList<Member> list = md.selectMemberAll(conn);
	 
	
	     close(conn);
	
	 return list;
}

public int updateMember(Member m ) {
	
	 Connection conn = jd.go();
	
	 int result = md.updateMember(m,conn);
	 
	 if(result>0) {
		 commit(conn);
	 }else {
		 rollback(conn);
	 }
	     close(conn);
	
	 return result;
	 
}

public int deleteMember(Member m) {

	Connection conn = jd.go();
	
	 int result = md.deleteMember(m,conn);
	 
	 if(result>0) {
		 commit(conn);
	 }else {
		 rollback(conn);
	 }
	     close(conn);
	
	 return result;
	 
}

public ArrayList<Member> selectkeyword(String userName) {
	Connection conn = jd.go();
	
	 ArrayList<Member> list = md.selectkeyword(userName,conn);
	 
	
	     close(conn);
	
	 return list;
	 
}


public int insertMember2(Member m ) {
	
	 Connection conn = jd.go();
	
	 int result = md.insertMember(m,conn);
	 
	 if(result>0) {
		 commit(conn);
	 }else {
		 rollback(conn);
	 }
	     close(conn);
	
	 return result;
	 
}










}