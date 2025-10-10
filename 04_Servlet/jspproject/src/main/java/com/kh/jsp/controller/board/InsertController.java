package com.kh.jsp.controller.board;


import java.io.IOException;

import com.kh.jsp.service.BoardService;
import com.kh.js.model.vo.Board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/insert.bo")
public class InsertController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		int categoryNo = Integer.parseInt(request.getParameter("categoryNo"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		int writerNo = ((Integer) request.getSession().getAttribute("loginUserNo")); // 세션에서 가져오기

		Board b = new Board();
		b.setCategoryNo(categoryNo);
		b.setBoardTitle(title);
		b.setBoardContent(content);
		b.setWriterNo(writerNo);

		int result = new BoardService().insertBoard(b);

		if (result > 0) {
			request.getSession().setAttribute("alertMsg", "게시글 등록 완료!");
			response.sendRedirect(request.getContextPath() + "/list.bo");
		} else {
			request.setAttribute("errorMsg", "게시글 등록 실패");
			request.getRequestDispatcher("/views/common/error.jsp").forward(request, response);
		}
	}
}

