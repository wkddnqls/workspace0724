package sword.Dao;

import static JDBC.common.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import JDBC.common;
import equipment.armorcollection;
import equipment.shieldcollection;
import equipment.swordcollection;

public class armorDao {
	
	public List<armorcollection> selectarmorAll(Connection conn) {

		ResultSet rset= null;
		ArrayList<armorcollection> list3 = new ArrayList<>();

		PreparedStatement pstmt = null;
		
		String sql = "SELECT * FROM ARMOR";
		
		try {
			
		    pstmt = conn.prepareStatement(sql);
		    rset = pstmt.executeQuery();
		    
		    while(rset.next())
		    {
		    	armorcollection a =new armorcollection();
		    	
		    	a.setArmorName(rset.getString("ARMOR_NAME"));
	        	a.setArmorNum(rset.getInt("ARMOR_NUM"));
	            a.setArmorInitiasl(rset.getString("ARMOR_INITIASL"));
	        	a.setArmorDate(rset.getTimestamp("ARMOR_DATE").toLocalDateTime());
	           a.setArmorUse(rset.getString("ARMOR_USE"));
		    	list3.add(a);
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
		
		
		
		return list3;
		
	}
	
public int insertarmor(armorcollection s,Connection conn) {
		
        int result = 0; 
		
		PreparedStatement pstmt = null;

		//실행할 SQL (sql뒤에 ; 없어야함 !!)
	    String sql = "INSERT INTO ARMOR VALUES(?,0,?,SYSDATE,'N')";

	    try {
			
		    
		    //아직 미완성 sql문으로 ?의 값을 전부 채워야함
		    pstmt = conn.prepareStatement(sql);
		    
			pstmt.setString(1, s.getArmorName());
			pstmt.setString(2, s.getArmorInitiasl());
		
			
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






public int deletearmor(armorcollection s,Connection conn) {
	
	
	
	
	int result = 0;
	PreparedStatement pstmt = null;
	
	String sql ="DELETE FROM ARMOR WHERE ARMOR_NAME=? ";
	

    try {
		pstmt = conn.prepareStatement(sql);
	
		
		
		pstmt.setString(1, s.getArmorName());
		
		
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

public ArrayList<armorcollection> selectkeywordarmor(armorcollection item, Connection conn) {
	
	ArrayList<armorcollection> list3 = new ArrayList<>();
	ResultSet rset= null;
	

	PreparedStatement pstmt = null;
	
	String sql = "SELECT * FROM ARMOR WHERE ARMOR_NAME LIKE'%' || ? ||'%'";
	
	try {
		
	    pstmt = conn.prepareStatement(sql);
	    pstmt.setString(1, item.getArmorName());
	    rset = pstmt.executeQuery();
	    
	    while(rset.next())
	    {
       
	    	armorcollection a =new armorcollection();
	    	a.setArmorName(rset.getString("ARMOR_NAME"));
        	a.setArmorNum(rset.getInt("ARMOR_NUM"));
            a.setArmorInitiasl(rset.getString("ARMOR_INITIASL"));
        	a.setArmorDate(rset.getTimestamp("ARMOR_DATE").toLocalDateTime());
           a.setArmorUse(rset.getString("ARMOR_USE"));
           list3.add(a);
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
	
	
	
	return list3;
	
}


public int updatearmor(armorcollection s,Connection conn) {
	
	
	
	
	int result = 0;
	PreparedStatement pstmt = null;
	
	String sql ="UPDATE ARMOR SET ARMOR_USE =? WHERE ARMOR_NAME=?";
	

    try {
		pstmt = conn.prepareStatement(sql);
	
		
		
		pstmt.setString(1, s.getArmorUse());
		pstmt.setString(2, s.getArmorName());
		
		
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


	public armorcollection selectamor(String armorName, Connection conn) {
		armorcollection armor = null;
	    String sql = "SELECT ARMOR_NAME, ARMOR_NUM, ARMOR_INITIASL,ARMOR_DATE, ARMOR_USE FROM ARMOR WHERE ARMOR_NAME = ?";
	   
	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, armorName);
	        ResultSet rset = pstmt.executeQuery();

	        if (rset.next()) {
	        	armor = new armorcollection();
	        	armor.setArmorName(rset.getString("ARMOR_NAME"));
	        	armor.setArmorNum(rset.getInt("ARMOR_NUM"));
	        	armor.setArmorInitiasl(rset.getString("ARMOR_INITIASL"));
	        	armor.setArmorDate(rset.getTimestamp("ARMOR_DATE").toLocalDateTime());
	        	armor.setArmorUse(rset.getString("ARMOR_USE"));
	        
	        }

	        close(rset);
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return armor;
	}
	
	
	public int enhancearmor(String armorName, Connection conn) {
	    int result = 0;
	    String sql = "UPDATE ARMOR SET ARMOR_NUM = ARMOR_NUM + 1 WHERE ARMOR_NAME = ?";

	    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
	        pstmt.setString(1, armorName);
	        result = pstmt.executeUpdate(); 
	   
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return result;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

