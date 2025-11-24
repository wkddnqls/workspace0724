package com.kh.mybatis.model.dao;



import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Properties;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.model.vo.Member;




	public class MemberDao {
		
	  public Member loginMember (SqlSession sqlSession , String userId,String userPwd){
		  HashMap<String,String> map = new HashMap<>();
		  map.put("memberId", userId);
		  map.put("memberPwd", userPwd);
		  
		  
		  Member loginMember = sqlSession.selectOne("MemberMapper.loginMember" , map );
	      return loginMember;
	  }
	  
		public int idCheck(SqlSession sqlSession , String checkId) {
			//select -> 동일한 ID로 가입된 멤버 수 -> ResultSet(count)
			return sqlSession.selectOne("MemberMapper.idCheck", checkId);
			
		}
		
		public int insertMember(SqlSession sqlSession, Member m) {
			//insert -> 처리된 행 수 -> 반환
			
			int result = sqlSession.insert("MemberMapper.insertMember", m);
			return result;
		}
		
	}
	
