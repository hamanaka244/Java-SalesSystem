package jsys.sales.dao;

import java. sql. Connection;
import java. sql. PreparedStatement;
import java. sql. ResultSet;
import java. sql. SQLException;

import jsys. sales. entity. Employee;


public class EmployeeDAO {

	private Connection con;

	
	public EmployeeDAO (Connection con) {
		this. con = con;
	}

	
	
	
	
	
public Employee findEmployee (String employeeNo, String password) throws SQLException {

		String sql = "SELECT employee_no, employee_name, password FROM employeedb WHERE employee_no=? and password=?";
		PreparedStatement stmt = null;
		ResultSet res = null;
		Employee employee = null;

		try {
			stmt = con. prepareStatement (sql) ;
			stmt. setString (1, employeeNo) ;
			stmt. setString (2, password) ;
			res = stmt. executeQuery () ;

			if (res. next ()) {
				employee = new Employee(
						res. getString ("employee_no"),
						res. getString ("employee_name"),
						res. getString ("password")) ;
			}	
			
		} finally {
			if (res != null) {
				res.close();
			}
			if (stmt !=null) {
				stmt.close();
			}
		}
		return employee;
	}
}
