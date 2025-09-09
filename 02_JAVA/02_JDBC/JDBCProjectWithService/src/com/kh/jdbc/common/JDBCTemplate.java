package com.kh.jdbc.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

// 공통 템플릿(매번 반복적으로 작성될 코드를 메서드 정의)
public class JDBCTemplate {
     //모든 메서드를 전부 static메서드로 만듬
	
	//1. Connection 객체 생성 후 해당 Connection객체 반환
	public static Connection getConnection() {
		Connection conn = null;
		Properties prop = new Properties();
		try {
			prop.load(new FileInputStream("resource/driver.properties"));
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("오라클드라이브 등록성공");
			
			conn = DriverManager.getConnection(prop.getProperty("url"),prop.getProperty("username"),prop.getProperty("password"));
		    
			conn.setAutoCommit(false);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    return conn;
	}
	
	
	
//2. Connection객체를 전달받아 상태를 화깅ㄴ 후 commit하는 메서드
	public static void commit(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//3. Connection객체를 전달받아 상태를 화깅ㄴ 후 rollback하는 메서드
	public static void rollback(Connection conn) {
		try {
			if(conn != null && !conn.isClosed()) {
				conn.rollback();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
  //4 . Statement 관련 객체를 전달받아 반납시켜주는 메서드 
	public static void close(Statement stmt) {
		try {
			if(stmt != null && !stmt.isClosed()) {
				stmt.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
  //5 . Connection 관련 객체를 전달받아 반납시켜주는 메서드 
		public static void close(Connection conn) {
			try {
				if(conn != null && !conn.isClosed()) {
					conn.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		//6 . ResultSet 관련 객체를 전달받아 반납시켜주는 메서드 
				public static void close(ResultSet rset) {
					try {
						if(rset != null && !rset.isClosed()) {
							rset.close();
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}














}
