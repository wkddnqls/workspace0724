package com.kh.jdbc.test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



public class Run {

/*
 * JDBC를 사용하기 위해서는 자바 프로젝트에 JDBC드라이버를 추가해 줘야한다.
 * 프로젝트 우클릭 - properties-java build path -library
 * -add external jar - ojdbc.jar추가 
 * 
 * JDBC용 객체
 * - Connection : DB의 연결정보를 담고잇는 객체
 *  -[Prepared]Statement : 연결된 DB에 sql문을 전달해서 실행하고 , 결과를 받아내느 개체
 *  - ResultSet: SLELECT문 실행 후 조회된 결과를 담는 객체
 */
	/*
	public static void main(String[] args) {
		//각자의 pc(local host)에 jdbc계정 연결 후 test 테이블에 데이터 insert
		Scanner sc =new Scanner(System.in);
		Connection conn =null;//DB연결정보 보관 객체
		Statement stmt = null;// sql문을 전달해서 실행 후 결과를 받아올 객체
		int result=0;
		
		System.out.print("번호 입력 : ");
        int tno = sc.nextInt();
        sc.nextLine(); // 버퍼 비우기

        System.out.print("이름 입력 : ");
        String tName = sc.nextLine();
		
		//실행할 sql문 ( 완전한 상태로 만듬 , sql 뒤에는 ;이 없어야함 !!!!)
		String sql = "INSERT INTO TEST VALUES ("+tno+" ,'"+tName+"',SYSDATE)";
		
		try {		
			// 1) JDBC Drivaer등록 
			//Class.forName() -> 문자열로 주어진 클래스 이름을 찾아서 JVM에 로드함.
			Class.forName("oracle.jdbc.driver.OracleDriver");// dhxk | ojdbc.jar파일을 추가안했을시
			System.out.println("오라클드라이브 등록성공");
			//127.0.0.1 -> 무조건적으로 지금 실행중인 컴퓨터의 ip(localhost)//@localhost:1521:xe
			//2)Connection생성(url , 계정명 , 비밀번호) 
			
				conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##JDBC","JDBC");
			    conn.setAutoCommit(false);
			    
			    //3)Statemnet생성 
			    stmt = conn.createStatement();
			
			    //4 ,5 )sql문 전달 /전달 후 결과를 받음 (insert, update , delete-> 처리된 행 수)
			    result = stmt.executeUpdate(sql);
			    
			    //insert , update ,delete ->stmt.excuteUpdate : int
			    //select -> stmt.executeQuery(sql); : ResultSet
			    
			    //트랜잭션 처리 
			    if(result>0) {
			    	conn.commit();
			    }else {
			    	conn.rollback();
			    }
}catch (SQLException e) {
	e.printStackTrace();
} catch (ClassNotFoundException e) {			
	e.printStackTrace();
}
		
	
	
	}} */
/*
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

*/


//3. PreparedStatemnet 객체 사용 => sql문 형태를 먼저 정의하고 각 데이터는 추후에 넣는 방법 
	
	public static void main(String[] args) {
		
		Scanner sc =new Scanner(System.in);
		Connection conn =null;//DB연결정보 보관 객체
		PreparedStatement pstmt = null;// sql문을 전달해서 실행 후 결과를 받아올 객체
		int result=0;
		
		System.out.println("수정할 번호를 입력하세요 : ");
		int tno = sc.nextInt();
	    
		System.out.println("새로운 이름을 입력하세요 :  ");
		String newName = sc.next();
		
		System.out.println("새로운 날짜를 입력하세요 ( YYYY-MM-DD) : ");
	    String newDate = sc.next();
	    sc.nextLine();
	
	   // String sql = "UPDATE TEST SET TNAME = '" +newName+ ", TDATE = TO_DATE('"+newDate+"', 'YYYY-MM-DD')" +
	   //               "WHERE TNO =" +tno;
	   
	   String sql = "UPDATE TEST SET TNAME = ? , TDATE =TO_DATE(?,'YYYY-MM-DD') WHERE TNO=?";
	   
	   try {
		   Class.forName("oracle.jdbc.driver.OracleDriver");
		   conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","c##JDBC","JDBC");
		   conn.setAutoCommit(false);
		   
		   //미완성된 sql문을 전달해서 pstmt객체 생성 
		   pstmt = conn.prepareStatement(sql);
		   
		   //pstmt에 작성하지않은 값들을 메서드를 통해 완성시키기(?개수만큼)
		   pstmt.setString(1, newName);
		   pstmt.setString(2, newDate);
		   pstmt.setInt(3, tno);
          
		   result = pstmt.executeUpdate();
		   
		   if(result>0) {
			   conn.commit();
		   }else {
			   conn.rollback();
		   }
		   
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally {
		try {
			pstmt.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	   
	   if(result>0) {
		   System.out.println(result+"개의 행 UPDATE");
	   }else {
		   System.out.println(" UPDATE실퐤");
	   }
	   
	   
	   
	   
	   
	   
	}}
	
	
	
	
	
	
	
	