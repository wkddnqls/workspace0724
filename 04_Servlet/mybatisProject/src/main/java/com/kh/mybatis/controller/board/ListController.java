package com.kh.mybatis.controller.board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import com.kh.mybatis.model.vo.Board;
import com.kh.mybatis.common.vo.PageInfo;
import com.kh.mybatis.service.BoardService;

/**
 * Servlet implementation class ListController
 */
@WebServlet("/list.bo")
public class ListController extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
    	int currentPage = request.getParameter("cpage") != null ? 
		                  Integer.parseInt(request.getParameter("cpage")) : 1; //지금 보여줄 페이지(사용자가 요청한 페이지)
        int listCount = new BoardService().selectAllBoardCount();//현재 총 게시글 수
        

        PageInfo pi = new PageInfo(currentPage, listCount, 5, 5);
    	
    	
        // 1. 서비스 호출해서 게시글 목록 가져오기
        ArrayList<Board> list = new BoardService().selectAllBoard(pi);
        
        // 2. 결과를 request에 담아서 JSP로 포워딩
        request.setAttribute("boardList", list);
        request.setAttribute("pi", pi);
        request.getRequestDispatcher("views/board/listView.jsp").forward(request, response);
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
