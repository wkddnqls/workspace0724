package com.kh.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UPDATE {

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
		
	
	
	}}
