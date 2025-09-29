package jsys.sales.test;

import java.sql.Connection;
import java.sql.SQLException;

import jsys.sales.dao.ConnectionManager;
import jsys.sales.dao.EmployeeDAO;
import jsys.sales.entity.Employee;

public class TestEmployeeDAO01_01 {

	public static void main(String[] args) {
		Connection con = null;
		
		try {
			try {
				con = ConnectionManager.getConnection();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		try {
			EmployeeDAO empDAO = new EmployeeDAO(con);
			Employee employee = empDAO.findEmployee("H20001","zy0001");
			
			System.out.println("従業員番号(H20001):" + employee.getEmployeeNo());
			System.out.println("従業員名(安藤直也):" + employee.getEmployeeName());
			System.out.println("パスワード(zy0001):" + employee.getPassword());
			
		} catch(SQLException e) {
			System.out.println("SQLExceptionがスローされました。");
			e.printStackTrace();
		} finally {
			try {
				if(con != null) {
					con.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
