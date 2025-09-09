package com.kh.jdbc.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import static com.kh.jdbc.common.JDBCTemplate.*;
import com.kh.jdbc.common.JDBCTemplate;
import com.kh.jdbc.model.vo.Member;

public class MemberDao {

	JDBCTemplate mc = new JDBCTemplate();
	
	public int insertMember(Member m,Connection conn) {
		
	
		
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql ="INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL,?,?,?,?,?,?,?,?,?,SYSDATE)";
		

	    try {
			pstmt = conn.prepareStatement(sql);
		
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserPwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getGender());
			pstmt.setInt(5, m.getAge());
			pstmt.setString(6, m.getEmall());
			pstmt.setString(7, m.getPhone());
			pstmt.setString(8, m.getAddress());
			pstmt.setString(9, m.getHobby());
			
			
			result =pstmt.executeUpdate();
			

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally
	    {
			close(pstmt);
			 
	    }
	
	return result;
	
	
	}


public ArrayList<Member> selectMemberAll(Connection conn) {
		
	
		
	ArrayList<Member> list = new ArrayList<>();
	ResultSet rset= null;
	

	PreparedStatement pstmt = null;
	
	String sql = "SELECT * FROM MEMBER";
	
	try {
		
	    pstmt = conn.prepareStatement(sql);
	    rset = pstmt.executeQuery();
	    
	    while(rset.next())
	    {
	    	Member m =new Member();
	    	
	    	m.setUserNo(rset.getInt("USER_NO"));
	    	m.setUserId(rset.getString("USER_ID"));
	    	m.setUserPwd(rset.getString("USER_PWD"));
	    	m.setUserName(rset.getString("USER_NAME"));
	    	m.setGender(rset.getString("GENDER"));
	    	m.setAge(rset.getInt("AGE"));
	    	m.setEmall(rset.getString("EMALL"));
	    	m.setPhone(rset.getString("PHONE"));
	    	m.setAddress(rset.getString("ADDRESS"));
	    	m.setHobby(rset.getString("HOBBY"));
	    	m.setEnrollDate(rset.getTimestamp("ENROLL_DATE").toLocalDateTime());
	    	
	    	list.add(m);
	    }
	    //반복문이 끝난시점
	    //list -비어있거나 / 데이터가 들어잇거나
	    
	    
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally
	{
		close(rset);
		close(pstmt);
	}
	
	
	
	return list;
	
}
	
public int updateMember(Member m,Connection conn) {
	
	
	
	
	int result = 0;
	PreparedStatement pstmt = null;
	
	String sql ="UPDATE MEMBER SET EMALL =? , PHONE=? , ADDRESS=? ,HOBBY=? WHERE USER_ID=?;";
	

    try {
		pstmt = conn.prepareStatement(sql);
	
		
		
		pstmt.setString(1, m.getEmall());
		pstmt.setString(2, m.getPhone());
		pstmt.setString(3, m.getAddress());
		pstmt.setString(4, m.getHobby());
		pstmt.setString(5, m.getUserId());
		
		result =pstmt.executeUpdate();
		

		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally
    {
		close(pstmt);
		 
    }

return result;


}


public int deleteMember(Member m,Connection conn) {
	
	
	
	
	int result = 0;
	PreparedStatement pstmt = null;
	
	String sql ="DELECT FROM MEMBER WHERE USER_ID=? AND USER_PWD=?";
	

    try {
		pstmt = conn.prepareStatement(sql);
	
		
		
		pstmt.setString(1, m.getUserId());
		pstmt.setString(2, m.getUserPwd());
		
		result =pstmt.executeUpdate();
		

		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally
    {
		close(pstmt);
		 
    }

return result;


}

public ArrayList<Member> selectkeyword(String userName, Connection conn) {
	
	ArrayList<Member> list = new ArrayList<>();
	ResultSet rset= null;
	

	PreparedStatement pstmt = null;
	
	String sql = "SELECT * FROM MEMBER WHERE USER_NAME LIKE'%' || ? ||'%'";
	
	try {
		
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, userName);
	    rset = pstmt.executeQuery();
	    
	    while(rset.next())
	    {
	    	Member m =new Member();
	    	
	    	m.setUserNo(rset.getInt("USER_NO"));
	    	m.setUserId(rset.getString("USER_ID"));
	    	m.setUserPwd(rset.getString("USER_PWD"));
	    	m.setUserName(rset.getString("USER_NAME"));
	    	m.setGender(rset.getString("GENDER"));
	    	m.setAge(rset.getInt("AGE"));
	    	m.setEmall(rset.getString("EMALL"));
	    	m.setPhone(rset.getString("PHONE"));
	    	m.setAddress(rset.getString("ADDRESS"));
	    	m.setHobby(rset.getString("HOBBY"));
	    	m.setEnrollDate(rset.getTimestamp("ENROLL_DATE").toLocalDateTime());
	    	
	    	list.add(m);
	    }
	    //반복문이 끝난시점
	    //list -비어있거나 / 데이터가 들어잇거나
	    
	    
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally
	{
		close(rset);
		close(pstmt);
	}
	
	
	
	return list;
	
}


public int insertMember2(Member m,Connection conn) {
	
	
	
	
	int result = 0;
	PreparedStatement pstmt = null;
	
	String sql ="INSERT INTO MEMBER VALUES(SEQ_USERNO.NEXTVAL,?,?,?,?,?,?,?,?,?,SYSDATE)";
	

    try {
		pstmt = conn.prepareStatement(sql);
	
		
		pstmt.setString(1, m.getUserId());
		pstmt.setString(2, m.getUserPwd());
		pstmt.setString(3, m.getUserName());
		pstmt.setString(4, m.getGender());
		pstmt.setInt(5, m.getAge());
		pstmt.setString(6, m.getEmall());
		pstmt.setString(7, m.getPhone());
		pstmt.setString(8, m.getAddress());
		pstmt.setString(9, m.getHobby());
		
		
		result =pstmt.executeUpdate();
		

		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally
    {
		close(pstmt);
		 
    }

return result;


}













}
