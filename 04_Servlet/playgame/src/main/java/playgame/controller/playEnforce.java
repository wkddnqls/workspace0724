package playgame.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import static JDBC.common.*;
import sword.Dao.armorDao;
import sword.Dao.shieldDao;
import sword.Dao.swordDao;
/**
 * Servlet implementation class playEnforce
 */
@WebServlet("/playEnforce")
public class playEnforce extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public playEnforce() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}


	 protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        request.setCharacterEncoding("UTF-8");

	        // 1️⃣ 입력 받기
	        String name = request.getParameter("name"); // 강화할 장비 이름
	        int type = Integer.parseInt(request.getParameter("type")); // 장비 종류: 1=검, 2=방패, 3=갑옷
	        int num = Integer.parseInt(request.getParameter("num")); // 사용자 입력 숫자

	        swordDao sd = new swordDao();
	        shieldDao SED = new shieldDao();
	        armorDao AM = new armorDao();

	        Connection conn = common.go();
	        int randomNumber = (int) (Math.random() * 2) + 1;
	        String message;

	        // 2️⃣ 강화 로직
	        if (num == 0) {
	            message = "강화를 포기했습니다.";
	        } else if (num == randomNumber) {
	            int result = 0;
	            if (type == 1) {
	                result = sd.enhanceSword(name, conn);
	            } else if (type == 2) {
	                result = SED.enhanceshield(name, conn);
	            } else if (type == 3) {
	                result = AM.enhancearmor(name, conn);
	            }

	            if (result > 0) {
	                commit(conn);
	                message = "강화 성공! 🎉";
	            } else {
	                rollback(conn);
	                message = "DB 업데이트 실패 😢";
	            }
	        } else {
	            message = "강화 실패… 😢 (정답: " + randomNumber + ")";
	        }

	        close(conn);

	        // 3️⃣ JSP에 메시지 전달
	        request.setAttribute("message", message);
	        request.getRequestDispatcher("/views/playgame/GameView.jsp").forward(request, response);
	    }

}
