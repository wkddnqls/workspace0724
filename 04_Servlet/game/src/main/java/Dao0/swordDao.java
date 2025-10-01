package Dao0;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBC.common;
import equipment0.swordcollection;

import static JDBC.common.*;

public class swordDao {
	
	
	public List<swordcollection> selectswordAll(Connection conn) {
	
		ResultSet rset= null;
		ArrayList<swordcollection> list = new ArrayList<>();
	
		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM SWORD";
		
		try {
			
		    pstmt = conn.prepareStatement(sql);
		    rset = pstmt.executeQuery();
		    
		    while(rset.next())
		    {
		    	swordcollection s =new swordcollection();
		    	
		    	s.setSwordName(rset.getString("SWORD_NAME"));
		    	s.setSwordNum(rset.getInt("SWORD_NUM"));
		    	s.setSwordInitiasl(rset.getString("SWORD_INITIASL"));
		    	s.setSwordDate(rset.getTimestamp("SWORD_DATE").toLocalDateTime());
		    	s.setSwordUse(rset.getString("SWORD_USE"));
		    	list.add(s);
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

	
	public int insertsword(swordcollection s,Connection conn) {
		
        int result = 0; 
		
		PreparedStatement pstmt = null;

		//실행할 SQL (sql뒤에 ; 없어야함 !!)
	    String sql = "INSERT INTO SWORD VALUES(?,0,?,SYSDATE,'N')";

	    try {
			
		    
		    //아직 미완성 sql문으로 ?의 값을 전부 채워야함
		    pstmt = conn.prepareStatement(sql);
		    
			pstmt.setString(1, s.getSwordName());
			pstmt.setString(2, s.getSwordInitiasl());
		
			
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
	
	public int deletesword(swordcollection s,Connection conn) {
		
		
		
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql ="DELETE FROM SWORD WHERE SWORD_NAME=? ";
		

	    try {
			pstmt = conn.prepareStatement(sql);
		
			
			
			pstmt.setString(1, s.getSwordName());
			
			
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
	
	public ArrayList<swordcollection> selectkeywordsword(swordcollection item, Connection conn) {
		
		ArrayList<swordcollection> list = new ArrayList<>();
		ResultSet rset= null;
		

		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM SWORD WHERE SWORD_NAME LIKE'%' || ? ||'%'";
		
		try {
			
		    pstmt = conn.prepareStatement(sql);
		    pstmt.setString(1,item.getSwordName());
		    rset = pstmt.executeQuery();
		    
		    while(rset.next())
		    {
		    	
		    	swordcollection s=new swordcollection();
		    	s.setSwordName(rset.getString("SWORD_NAME"));
		    	s.setSwordNum(rset.getInt("SWORD_NUM"));
		    	s.setSwordInitiasl(rset.getString("SWORD_INITIASL"));
		    	s.setSwordDate(rset.getTimestamp("SWORD_DATE").toLocalDateTime());
		    	s.setSwordUse(rset.getString("SWORD_USE"));
		    	list.add(s);
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
	
	public int updatesword(swordcollection s,Connection conn) {
		
		
		
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		String sql ="UPDATE SWORD SET SWORD_USE =? WHERE SWORD_NAME=?";
		

	    try {
			pstmt = conn.prepareStatement(sql);
		
			
			
			pstmt.setString(1, s.getSwordUse());
			pstmt.setString(2, s.getSwordName());
			
			
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
	
// 강화쪽 기능들 
	
	public swordcollection selectSword(String swordName, Connection conn) {
	    swordcollection sword = null;
	    String sql = "SELECT SWORD_NAME, SWORD_NUM, SWORD_INITIASL, SWORD_DATE, SWORD_USE FROM SWORD WHERE SWORD_NAME = ?";
	   
	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, swordName);
	        ResultSet rset = pstmt.executeQuery();

	        if (rset.next()) {
	            sword = new swordcollection();
	            sword.setSwordName(rset.getString("SWORD_NAME"));
	            sword.setSwordNum(rset.getInt("SWORD_NUM"));
	            sword.setSwordInitiasl(rset.getString("SWORD_INITIASL"));
	            sword.setSwordDate(rset.getTimestamp("SWORD_DATE").toLocalDateTime());
	            sword.setSwordUse(rset.getString("SWORD_USE"));
	        
	        }

	        close(rset);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return sword;
	}
	
	
	public int enhanceSword(String swordName, Connection conn) {
	    int result = 0;
	    String sql = "UPDATE SWORD SET SWORD_NUM = SWORD_NUM + 1 WHERE SWORD_NAME = ?";

	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, swordName);
	        result = pstmt.executeUpdate(); // 1이면 성공, 0이면 실패
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return result;
	}
	
	
	
	
	
	
}
