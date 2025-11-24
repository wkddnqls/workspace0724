package Controller0;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


import JDBC.PageInfo;
import Service0.Service;
import equipment0.equipmentcollection;
import equipment0.swordcollection;
import equipment0.shieldcollection;
import equipment0.armorcollection;

/**
 * Servlet implementation class EquipmentListController
 */
@WebServlet("/equipList.ep")
public class EquipmentListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EquipmentListController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    Service service = new Service(); 
	   // equipmentcollection eqList = service.selectAll(); 

	    int currentPage = request.getParameter("cpage") != null ? 
                Integer.parseInt(request.getParameter("cpage")) : 1; //지금 보여줄 페이지(사용자가 요청한 페이지)
         int listSwordCount = service.selectAllSwordCount();
         int listShieldCount = service.selectAllSwordCount();
         int listArmorCount = service.selectAllSwordCount();
         
         
         PageInfo Swordpi = new PageInfo(currentPage, listSwordCount, 3, 5);
         PageInfo Shieldpi = new PageInfo(currentPage, listShieldCount, 3, 5);  
         PageInfo Armorpi = new PageInfo(currentPage, listArmorCount, 3, 5);
         
         ArrayList<swordcollection> Swordlist = new Service().SwordselectAll(Swordpi);
         ArrayList<shieldcollection> Shieldlist = new Service().ShieldselectAll(Shieldpi);
         ArrayList<armorcollection> Armorlist = new Service().ArmorselectAll(Armorpi);
         
         
         
         
         
         
         
         
         request.setAttribute("swordList", Swordlist);
	   request.setAttribute("shieldList", Shieldlist);
	    request.setAttribute("armorList", Armorlist);
	    
	    request.setAttribute("Swordpi", Swordpi); 
	    request.setAttribute("Shieldpi", Shieldpi); 
	    request.setAttribute("Armorpi", Armorpi); 
	    
	    
	    
	    
	    request.getRequestDispatcher("/equipment/equipment_list.jsp").forward(request, response);
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
