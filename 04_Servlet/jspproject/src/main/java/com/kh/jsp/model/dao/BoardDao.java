package com.kh.jsp.model.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.kh.js.model.vo.Board;
import com.kh.js.model.vo.Category;

import static com.kh.jsp.common.JDBCTemplate.*;

public class BoardDao {

    public ArrayList<Board> selectAllBoards(Connection conn) {
        ArrayList<Board> list = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT B.BOARD_NO, C.CATEGORY_NAME, B.BOARD_TITLE, M.MEMBER_NAME, "
                   + "B.COUNT, TO_CHAR(B.CREATE_DATE, 'YYYY-MM-DD') AS CREATE_DATE "
                   + "FROM BOARD B "
                   + "JOIN MEMBER M ON (B.BOARD_WRITER = M.MEMBER_NO) "
                   + "LEFT JOIN CATEGORY C ON (B.CATEGORY_NO = C.CATEGORY_NO) "
                   + "WHERE B.STATUS = 'Y' "
                   + "ORDER BY B.BOARD_NO DESC";

        try {
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            while (rs.next()) {
                Board b = new Board();
                b.setBoardNo(rs.getInt("BOARD_NO"));
                b.setCategoryName(rs.getString("CATEGORY_NAME"));
                b.setBoardTitle(rs.getString("BOARD_TITLE"));
                b.setBoardWriter(rs.getString("MEMBER_NAME"));
                b.setCount(rs.getInt("COUNT"));
                b.setCreateDate(rs.getString("CREATE_DATE"));
                list.add(b);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(rs);
            close(pstmt);
        }

        return list;
    }
    public List<Category> selectCategoryList(Connection conn) {
		List<Category> list = new ArrayList<>();
		String sql = "SELECT CATEGORY_NO, CATEGORY_NAME FROM CATEGORY ORDER BY CATEGORY_NO";

		try (PreparedStatement pstmt = conn.prepareStatement(sql);
			 ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				list.add(new Category(
						rs.getInt("CATEGORY_NO"),
						rs.getString("CATEGORY_NAME")
				));
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

    public int insertBoard(Connection conn, Board b) {
        int result = 0;
        String sql = "INSERT INTO BOARD VALUES(SEQ_BNO.NEXTVAL, 1, ?, ?, ?, ?, DEFAULT, DEFAULT, DEFAULT)";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, b.getCategoryNo());
            pstmt.setString(2, b.getBoardTitle());
            pstmt.setString(3, b.getBoardContent());
            pstmt.setInt(4, b.getWriterNo());
            result = pstmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}

