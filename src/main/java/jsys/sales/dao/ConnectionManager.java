package jsys.sales.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionManager {

	private static final String URL = "jdbc:mysql://localhost:3306/jsysdb";
	
	private static final String USER = "root";
	
	private static final String PASSWORD = "pass";
	
	public static Connection getConnection() throws SQLException, ClassNotFoundException{
		Connection con = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(URL,USER,PASSWORD);
		} catch(SQLException e) {
			e.printStackTrace();
			throw e;
		}
		
		return con;
	}
	
	
	
}
