package com.kh.jdbc.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class SELECT {

	public static void main(String[] args) {
		//각자의 pc(local host)에 jdbc계정 연결 후 test 테이블에 데이터 select
		//select -> 결과 :ResultSet -> 데이터를 추출
		Connection conn =null;
		Statement stmt = null;
		ResultSet rset = null;
		List<Test> list = new ArrayList<>();
		//실행할 sql
		String sql = "SELECT * FROM TEST";
		try {
			//1)JDBC드라이버 등록
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("오라클드라이브 등록성공");
		  //2)Connection생성(db ur1 , 계정명 , 비번)
		 
			
		conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##JDBC","JDBC");
		//3 ) Statement 생성
		stmt = conn.createStatement();
		//4 ,5 ) sql문 전달하면서 결과받아 (select -> ResultSet)
		rset = stmt.executeQuery(sql);
		//rest.next() =>rset 의 다음행이 있는지 없는지 알려주고 + 다음행을 가르킨다.
		while(rset.next()) {
			int tno = rset.getInt("TNO");
		    String tName = rset.getString("TNAME");
		    Date tDate = rset.getDate("TDATE");
		    
		    list.add(new Test(tno , tName , tDate.toLocalDate()));
		}
		 
		 } catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}finally {
			try {
				rset.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		if(list.isEmpty()) {
			System.out.println("데이터 없음");
		}else
		{
			System.out.println("성공");
		}
		
		
		if (list.isEmpty()) {
		    System.out.println("데이터 없음");
		} else {
		    // 1. for-each 문
		    for (Test t : list) {
		        System.out.println(t);
		    }

		    // 2. 람다식 (간단하게)
		    // list.forEach(System.out::println);
		}
		
		
	}}
