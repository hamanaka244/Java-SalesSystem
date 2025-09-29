package jsys.sales.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutAction implements ActionIF{
	
	public String execute(HttpServletRequest request) {
		String page = "/V101_01Login.jsp";
		
		HttpSession session = request.getSession();
		session.invalidate();
		
		return page;
	}
}
