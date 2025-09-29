package jsys.sales.logic;

import java.sql.Connection;
import java.sql.SQLException;

import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.dao.ConnectionManager;
import jsys.sales.dao.EmployeeDAO;
import jsys.sales.entity.Employee;


public class LoginLogic {
	public Employee login(String employeeNo,String password) throws SalesBusinessException,SalesSystemException,ClassNotFoundException{
		Connection con = null;
		Employee employee = null;
		try {
			con = ConnectionManager.getConnection();
			EmployeeDAO employeeDAO = new EmployeeDAO(con);
			employee = employeeDAO.findEmployee(employeeNo, password);
			
			if(employee == null) {
				throw new SalesBusinessException("ログインに失敗しました。");
			}
		}catch(SQLException e) {
			throw new SalesSystemException("システムエラーが発生しました。システム管理者に連絡してください。");
		} finally {
			try {
				if (con != null) {
					con.close();
				}
			} catch(SQLException e) {
				throw new SalesSystemException("システムエラーが発生しました。システム管理者に連絡してください。");
			}
		}
		return employee;
	}

}
