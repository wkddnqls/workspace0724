package com.kh.jsp.controller.board;

import java.io.IOException;
import java.util.List;

import com.kh.js.model.vo.Category;
import com.kh.jsp.service.BoardService;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/enrollForm.bo")
public class EnrollController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Category> list = new BoardService().selectCategoryList();
		request.setAttribute("categoryList", list);
		request.getRequestDispatcher("/views/board/enrollForm.jsp").forward(request, response);
	}
}
