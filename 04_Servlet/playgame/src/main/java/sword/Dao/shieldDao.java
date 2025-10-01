package sword.Dao;

import static JDBC.common.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBC.common;
import equipment.shieldcollection;
import equipment.swordcollection;


public class shieldDao {
	
	public List<shieldcollection> selectshieldAll(Connection conn) {

		ResultSet rset= null;
		ArrayList<shieldcollection> list2 = new ArrayList<>();

		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM SHIELD";
		
		try {
			
		    pstmt = conn.prepareStatement(sql);
		    rset = pstmt.executeQuery();
		    
		    while(rset.next())
		    {
		    	shieldcollection s =new shieldcollection();
		    	
		    	s.setShieldName(rset.getString("SHIELD_NAME"));
	        	s.setShieldNum(rset.getInt("SHIELD_NUM"));
	            s.setShieldInitiasl(rset.getString("SHIELD_INITIASL"));
	        	s.setShieldDate(rset.getTimestamp("SHIELD_DATE").toLocalDateTime());
	           s.setShieldUse(rset.getString("SHIELD_USE"));
		    	list2.add(s);
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
		
		
		
		return list2;
		
	}
	
public int insertshield(shieldcollection s,Connection conn) {
		
        int result = 0; 
		
		PreparedStatement pstmt = null;

		//실행할 SQL (sql뒤에 ; 없어야함 !!)
	    String sql = "INSERT INTO SHIELD VALUES(?,0,?,SYSDATE,'N')";

	    try {
			
		    
		    //아직 미완성 sql문으로 ?의 값을 전부 채워야함
		    pstmt = conn.prepareStatement(sql);
		    
			pstmt.setString(1, s.getShieldName());
			pstmt.setString(2, s.getShieldInitiasl());
		
			
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






public int deleteshield(shieldcollection s,Connection conn) {
	
	
	
	
	int result = 0;
	PreparedStatement pstmt = null;
	
	String sql ="DELETE FROM SHIELD WHERE SHIELD_NAME=? ";
	

    try {
		pstmt = conn.prepareStatement(sql);
	
		
		
		pstmt.setString(1, s.getShieldName());
		
		
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

public ArrayList<shieldcollection> selectkeywordshield(shieldcollection item, Connection conn) {
	
	ArrayList<shieldcollection> list2 = new ArrayList<>();
	ResultSet rset= null;
	

	PreparedStatement pstmt = null;
	
	String sql = "SELECT * FROM SHIELD WHERE SHIELD_NAME LIKE'%' || ? ||'%'";
	
	try {
		
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1,  item.getShieldName());
	    rset = pstmt.executeQuery();
	    
	    while(rset.next())
	    {
       
	    	shieldcollection s =new shieldcollection();
	    	s.setShieldName(rset.getString("SHIELD_NAME"));
        	s.setShieldNum(rset.getInt("SHIELD_NUM"));
            s.setShieldInitiasl(rset.getString("SHIELD_INITIASL"));
        	s.setShieldDate(rset.getTimestamp("SHIELD_DATE").toLocalDateTime());
           s.setShieldUse(rset.getString("SHIELD_USE"));
	    	list2.add(s);
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
	
	
	
	return list2;
	
}


public int updateshield(shieldcollection s,Connection conn) {
	
	
	
	
	int result = 0;
	PreparedStatement pstmt = null;
	
	String sql ="UPDATE SHIELD SET SHIELD_USE =? WHERE SHIELD_NAME=?";
	

    try {
		pstmt = conn.prepareStatement(sql);
	
		
		
		pstmt.setString(1, s.getShieldUse());
		pstmt.setString(2, s.getShieldName());
		
		
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






// 강화 기능


	public shieldcollection selectshield(String shieldName, Connection conn) {
		shieldcollection shield = null;
	    String sql = "SELECT SHIELD_NAME, SHIELD_NUM, SHIELD_INITIASL, SHIELD_DATE, SHIELD_USE FROM SHIELD WHERE SHIELD_NAME = ?";
	   
	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, shieldName);
	        ResultSet rset = pstmt.executeQuery();

	        if (rset.next()) {
	        	shield = new shieldcollection();
	        	shield.setShieldName(rset.getString("SHIELD_NAME"));
	        	shield.setShieldNum(rset.getInt("SHIELD_NUM"));
	        	shield.setShieldInitiasl(rset.getString("SHIELD_INITIASL"));
	        	shield.setShieldDate(rset.getTimestamp("SHIELD_DATE").toLocalDateTime());
	            shield.setShieldUse(rset.getString("SHIELD_USE"));
	        
	        }

	        close(rset);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return shield;
	}
	
	
	public int enhanceshield(String shieldName, Connection conn) {
	    int result = 0;
	    String sql = "UPDATE SHIELD SET SHIELD_NUM = SHIELD_NUM + 1 WHERE SHIELD_NAME = ?";

	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, shieldName);
	        result = pstmt.executeUpdate(); 
	   
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
