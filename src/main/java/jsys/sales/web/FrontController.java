package jsys.sales.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = {"/jsysFC"})
public class FrontController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		String path = "/WEB-INF/jsp/";
		String page = null;
		ActionIF action = null;
		
		request.setCharacterEncoding("UTF-8");
		String buttonId = request.getParameter("buttonId");
		
		if(buttonId == null || buttonId.equals("")) {
			buttonId = "V101_01";
		}
		
		switch (buttonId) {
			case "V101_01":
				page = "V101_01Login.jsp";
				break;
			
			case "V101_01_01":
				action = new LoginAction();
				page = action.execute(request);
				break;
			
			case "M01":
				page = "V101_02MainMenu.jsp";
				break;
				
			case "M01_01":
				page = "V200_01CustomerManagementMenu.jsp";
				break;
		
			case "M01_02":	
				page = "V300_01OrderTotalMenu.jsp";
				break;
				
			case "M01_03":
				action = new LogoutAction();
				page = action.execute(request);
				break;	
				
			case "M02":
				page = "V200_01CustomerManagementMenu.jsp";
				break;	
				
			case "M02_01":
				page = "V201_01CustomerFindView.jsp";
				break;	
				
			case "M02_02":
				page = "V202_01CustomerRegistView.jsp";
				break;		
			
			case "M02_03":
				page = "V203_01CustomerDeleteView.jsp";
				break;	
			
			case "M02_04":
				page = "V204_01CustomerChangeView.jsp";
				break;		
				
			case "M02_05":
//				action = new CustomerListAction();
				page = action.execute(request);	
				break;
			
			case "V201_02_01":
				page = "V201_01CustomerFindView.jsp";
				break;
				
			case "V201_01_01":
				action = new CustomerFindAction();
				page = action.execute(request);	
				break;
			
			case "検索":
				action = new CustomerAction();
				page = action.execute(request);	
			break;
				
			case "新規登録":
			    action = new CustomerAction();
				page = action.execute(request);	
				break;
				
			case "修正":
			    action = new CustomerAction();
				page = action.execute(request);	
				break;
				
			case "削除":
				action = new CustomerAction();
				page = action.execute(request);	
				break;	
			
			case "完全削除":
				action = new CustomerAction();
				page = action.execute(request);	
				break;		

			case "V202_02_01":
				page = "V202_01CustomerRegistView.jsp";
				break;	
				
				
			case "V203_01_01":
//				action = new CustomerDeleteFindAction();
				page = action.execute(request);	
				break;		
				
			case "V203_01_02":
//				action = new CustomerDeleteExecuteAction();
				page = action.execute(request);	
				break;		
				
			case "V203_02_01":
				page = "V203_01CustomerDeleteView.jsp";
				break;	
				
			case "V204_01_01":
//				action = new CustomerChangeFindAction();
				page = action.execute(request);	
				break;	
				
			case "V204_01_02":
//				action = new CustomerChangeExecuteAction();
				page = action.execute(request);	
				break;	
				
			case "V204_02_01":
				page = "V204_01CustomerChangeView.jsp";
				break;		
				
			case "M03":
				page = "V300_01OrderTotalMenu.jsp";
				break;		
				
			case "M03_01":
				page = "V301_01MonthlyOrderTotalView.jsp";
				break;	
			
			case "M03_02":
				page = "V302_01YearlyOrderTotalView.jsp";
				break;	
			
			case "M03_03":
				page = "V303_01OrderTotalByItemView.jsp";
				break;	
				
			case "V301_01_01":
//				action = new MonthlyOrderTotalAction();
				page = action.execute(request);	
				break;		
			
			case "V302_01_01":
//				action = new YearlyOrderTotalAction();
				page = action.execute(request);	
				break;			
				
			case "V303_01_01":
//				action = new OrderTotalByItemAction();
				page = action.execute(request);	
				break;		
				
			case "V901_01_01":
				page = "V101_01Login.jsp";
				break;		
				
			default:
				page = "V101_01Login.jsp";
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher(path + page);
		rd.forward(request, response);
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException{
		doPost(request, response);
	}

}
