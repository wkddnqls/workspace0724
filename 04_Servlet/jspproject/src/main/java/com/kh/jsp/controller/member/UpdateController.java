package com.kh.jsp.controller.member;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.kh.js.model.vo.Member;
import com.kh.jsp.service.MemberService;

/**
 * Servlet implementation class UpdateController
 */
@WebServlet("/update.me")
public class UpdateController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		
		String userId = request.getParameter("userId");
		String phone = request.getParameter("phone"); // "010~" || ""
		String email = request.getParameter("email");  // "~~" || ""
		String address = request.getParameter("address"); // "~~" || ""
        String[] interestArr = request.getParameterValues("interest"); // ["sports...] || null
		
		//String[] -> string
		String interest = "";
		if(interestArr != null) {
			interest = String.join(",", interestArr);
		}
		

		Member updateMember = Member.UpdateMember(userId, phone, email, address,interest);
		
		updateMember = new MemberService().UpdateMember(updateMember);
		
		if(updateMember == null) { //로그인 실패 -> 에러문구 보여지는 에러페이지로 포워딩
			request.setAttribute("errorMsg", "회원수정에 실패하였습니다.");
			
			//포워딩방식 -> 해당 url이 변경되지 않는다.
			// 기본적으로 localhost:8000/jsp/login.me의 url을 유지하면서 로그인 실패 페이지를 보여준다.
			// 로그인실패는 해당 요청에대한 실패이므로 url을 유지하도록한다.
			//이럴때는 포워드를 사용하면 됨.
			request.getRequestDispatcher("views/common/error.jsp").forward(request, response);
		} else { //로그인 성공 -> 성공메세지를 포함해서 메인으로 이동
			//로그인 성공메세지
			HttpSession session = request.getSession();
			session.setAttribute("loginMember", session);
			session.setAttribute("alertMsg", "로그인 성공");
			
			//request.getRequestDispatcher("/index.jsp").forward(request, response);
			//url재요청 방식
			//기존에 해당페이지를 응답하는 url이 존재한다면 굳이 해당 url을 유지하면서
			//다른 화면을 보여주는 것이 아니라 내가 응답을 원하는 url에 다시 요청하도록 한다.
			//응답페이지 -> index.jsp -> url : /jsp
			//성공시 메인화면(localhost:8000/jsp)으로 url재요청을 응답으로 보낸다.
			response.sendRedirect(request.getContextPath()+"/myPage.jsp");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
