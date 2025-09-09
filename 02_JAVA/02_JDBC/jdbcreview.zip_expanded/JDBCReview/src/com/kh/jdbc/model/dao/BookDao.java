package com.kh.jdbc.model.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.kh.jdbc.common.JDBCTemplate.*;
import com.kh.jdbc.model.vo.Book;


public class BookDao {
	private Properties prop = new Properties();
	
	
	
	public BookDao() {
		super();
		try {
			prop.loadFromXML(new FileInputStream("resources/book-query.xml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public int insertBook(Book book, Connection conn) {
		//book추가 -> int
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertBook");
		
		try {
			pstmt= conn.prepareStatement(sql);
			pstmt.setString(1, book.getTitle());
			pstmt.setString(2, book.getAuthor());
			pstmt.setString(3, book.getPublisher());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<Book> selectBook(Connection conn){
	    //select문 (여러개) -> ResultSet -> ArrayList에 담기
			
			ResultSet rset= null;
			ArrayList<Book> list = new ArrayList<>();
		
			PreparedStatement pstmt = null;
			
			String sql = "SELECT * FROM BOOK";
			
			try {
				
			    pstmt = conn.prepareStatement(sql);
			    rset = pstmt.executeQuery();
			    
			    while(rset.next())
			    {
			    	Book m =new Book();
			    	
			    	m.setBookId(rset.getLong("BOOK_ID"));
			        m.setTitle(rset.getString("TITLE"));       // ✅ BOOK_TITLE → TITLE
			        m.setAuthor(rset.getString("AUTHOR"));     // ✅ BOOK_AUTHOR → AUTHOR
			        m.setPublisher(rset.getString("PUBLISHER")); // ✅ BOOK_PUBLISHER → PUBLISHER

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
