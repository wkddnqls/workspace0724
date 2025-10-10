package com.kh.jsp.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import com.kh.jsp.model.dao.BoardDao;
import com.kh.js.model.vo.Board;
import com.kh.js.model.vo.Category;

import static com.kh.jsp.common.JDBCTemplate.*;

public class BoardService {

    public ArrayList<Board> selectAllBoards() {
        Connection conn = getConnection();
        ArrayList<Board> list = new BoardDao().selectAllBoards(conn);
        close(conn);
        return list;
    }
    
    public List<Category> selectCategoryList() {
		Connection conn = getConnection();
		List<Category> list = new BoardDao().selectCategoryList(conn);
		close(conn);
		return list;
	}

	public int insertBoard(Board b) {
		Connection conn = getConnection();
		int result = new BoardDao().insertBoard(conn, b);

		if (result > 0) commit(conn);
		else rollback(conn);

		close(conn);
		return result;
	}
}