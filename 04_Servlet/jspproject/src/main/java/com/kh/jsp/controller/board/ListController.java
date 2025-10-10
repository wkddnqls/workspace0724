package com.kh.jsp.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.kh.js.model.vo.Board;
import com.kh.jsp.service.BoardService;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/list.bo")
public class ListController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 1. 서비스 호출해서 게시글 목록 가져오기
        ArrayList<Board> list = new BoardService().selectAllBoards();
        
        // 2. 결과를 request에 담아서 JSP로 포워딩
        request.setAttribute("boardList", list);
        request.getRequestDispatcher("views/board/listView.jsp").forward(request, response);
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
