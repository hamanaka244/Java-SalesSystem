package jsys.sales.web;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.entity.Employee;
import jsys.sales.logic.LoginLogic;


public class LoginAction implements ActionIF{
//ログイン画面のログインボタンが押された場合の処理を実行する。
	public String execute(HttpServletRequest request) {
		String page = "V101_02MainMenu.jsp";
		try {
			String employeeNo = request.getParameter("employeeNo");
			String password = request.getParameter("password");
			
			ArrayList<String>errorMessageList = new ArrayList<>();
			if(employeeNo == null || employeeNo.equals("")) {
				errorMessageList.add("従業員番号が未入力です。");
			}
			if(password == null || password.equals("")) {
				errorMessageList.add("パスワードが未入力です。");
			}
			if(!errorMessageList.isEmpty()) {
				throw new SalesBusinessException(errorMessageList);
			}
			
			
			LoginLogic logic = new LoginLogic();
			Employee employee = logic.login(employeeNo, password);
			
			
			HttpSession session = request.getSession(true);
			
			session.setAttribute("employee", employee);
		}catch(SalesBusinessException e) {
			request.setAttribute("errorMessage", e.getMessage());
			request.setAttribute("errorMessageList", e.getMessageList());
			page = "V101_01Login.jsp";
		}catch(SalesSystemException e) {
			request.setAttribute("errorMessage",e.getMessage());
			page = "V901_01SystemErrorPage.jsp";
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return page;
	}
}
