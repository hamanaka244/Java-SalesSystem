package jsys.sales.web;

import javax.servlet.http.HttpServletRequest;

import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.entity.Customer;
import jsys.sales.logic.CustomerLogic; 

public class CustomerAction implements ActionIF{
	public String execute(HttpServletRequest request) {
		String page = null;
		//String page = "V202_02CustomerRegistRequestView.jsp";
		try {       
			String custCode = request.getParameter("custCode");
			String custName = request.getParameter("custName");
			String telNo = request.getParameter("telNo");
			String postalCode = request.getParameter("postalCode");
			String address = request.getParameter("address");
			String discountRate = request.getParameter("discountRate");
			String buttonId = request.getParameter("buttonId"); // ボタンIDを取得

			CustomerLogic logic = new CustomerLogic();
			Customer customer = null;
            int result = 0;
            
            if ("検索".equals(buttonId)) {
                customer = logic.findCustomer(custCode); // 検索ロジックを呼び出し
                if (customer != null) {
                    request.setAttribute("customer", customer);
                    page = "V202_02CustomerRegistRequestView.jsp";
                }
	            } else if ("新規登録".equals(buttonId)) { 
	                result = logic.insertCustomer(custCode, custName, telNo, postalCode, address, discountRate);
	                customer = new Customer(custCode, custName, telNo, postalCode, address, Integer.parseInt(discountRate));
	                page = "V202_02CustomerRegistRequestView.jsp";
	            } else if ("修正".equals(buttonId)) {
	                result = logic.updateCustomer(custCode, custName, telNo, postalCode, address, discountRate);
	                customer = new Customer(custCode, custName, telNo, postalCode, address, Integer.parseInt(discountRate));
	                page = "V202_02CustomerRegistRequestView.jsp";
	            } else if ("削除".equals(buttonId)) {
	                result = logic.deleteCustomer(custCode);
	                customer = new Customer(); // 削除した得意先コードを画面表示
	                customer.setCustCode(custCode);
	                page = "V202_02CustomerRegistRequestView.jsp";
	            } else if ("完全削除".equals(buttonId)) {
	                result = logic.alldeleteCustomer(custCode);
	                customer = new Customer(); 
	                customer.setCustCode(custCode);
	                page = "V202_03CustomerDeleteRequestView.jsp";
	            }
               
            request.setAttribute("customer", customer); 
	            
		   } catch(SalesBusinessException e) {
	           request.setAttribute("errorMessage", e.getMessage());
	           // エラーが発生した場合は、元の画面に戻す
	           if ("V201_01_01".equals(request.getParameter("buttonId"))) {
	               page = "V201_01CustomerFindView.jsp";
	           } else {
	               page = "V202_01CustomerRegistView.jsp";
	           }
	       } catch(SalesSystemException e) {
	           request.setAttribute("errorMessage", e.getMessage());
	           page = "V901_01SystemErrorPage.jsp";
	       } catch(ClassNotFoundException e) {
	           e.printStackTrace();
	           page = "V901_01SystemErrorPage.jsp";
	       }
			
			return page;
		}

}
