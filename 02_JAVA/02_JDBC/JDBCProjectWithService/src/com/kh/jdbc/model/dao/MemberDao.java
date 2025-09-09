package com.kh.jdbc.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.kh.jdbc.common.JDBCTemplate.*;

import com.kh.jdbc.common.JDBCTemplate;
import com.kh.jdbc.model.vo.Member;

/*
 * Dad (Data access Object): db에 직접적으로 접근해서 사용자의 요청에 맞게 sql문을 실행 후 결과를 반환
 */
public class MemberDao {
	Properties propXml = new Properties();
	
	
	
	
	public int insertMember(Member m , Connection conn) {
		
		
		
		
		//필요한 변수 세팅
		int result = 0;
		
		PreparedStatement pstmt = null;

		//실행할 SQL (sql뒤에 ; 없어야함 !!)
	    String sql = propXml.getProperty("insertMember");

	    try {
			
		    
		    //아직 미완성 sql문으로 ?의 값을 전부 채워야함
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
	
	

	public ArrayList<Member> selectMemberList(Connection conn){
	    //select문 (여러개) -> ResultSet -> ArrayList에 담기
			
			ResultSet rset= null;
			ArrayList<Member> list = new ArrayList<>();
		
			PreparedStatement pstmt = null;
			
			String sql = propXml.getProperty("selectMemberList");
			
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
	//Member객체 m을 통해서 update sql을 전달하는 메서드
		public int updateMember(Member m ,Connection conn) {
			//update문 -> 처리된 행 수 : int -> 트랜잭션처리
			
			//필요한 변수 세팅
			int result = 0;
	
			PreparedStatement pstmt = null;
			
			//실행할 sql(sql뒤에 ;없어야함!!!)
			String sql = propXml.getProperty("updateMember");
			
			try {
				
				
				//아직 미완성 sql문으로 ?의 값을 전부 채워야함
				pstmt = conn.prepareStatement(sql);
			
				pstmt.setString(1, m.getEmall());
				pstmt.setString(2, m.getPhone());
				pstmt.setString(3, m.getAddress());
				pstmt.setString(4, m.getHobby());
				pstmt.setString(5, m.getUserId());
				
				result = pstmt.executeUpdate();
				
				
			
			} catch (SQLException e) {
				e.printStackTrace();
			} finally
			{
				
				close(pstmt);
			}
			 
			return result;
		}
		
		//Member객체 m을 통해서 delete sql을 전달하는 메서드
		public int deleteMember(Member m ,Connection conn) {			
			int result = 0;	
			PreparedStatement pstmt = null;
			String sql = propXml.getProperty("deleteMember");
			try {
				pstmt = conn.prepareStatement(sql);			
				pstmt.setString(1, m.getUserId());
				pstmt.setString(2, m.getUserPwd());
							
				result = pstmt.executeUpdate();

			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					pstmt.close();
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			return result;
		}
	
	
public ArrayList<Member> keywordselect( String userName , Connection conn) {			
	ResultSet rset= null;
	ArrayList<Member> list = new ArrayList<>();
	Member m =new Member();
	PreparedStatement pstmt = null;
	
	String sql = propXml.getProperty("keywordselect");
	
	try {
		
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, userName);
	    rset = pstmt.executeQuery();
	    
	    while(rset.next())
	    {
	    	
	    	 
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
}


