package jsys.sales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jsys.sales.entity.Customer;

public class CustomerFindDAO {
	
	private Connection con;
	
	public CustomerFindDAO(Connection con) {
		this.con = con;
	}

	public Customer findCustomer (String custCode) throws SQLException { 
		  String sql = "SELECT customer_code,customer_name,customer_telno,customer_postalcode,customer_address,discount_rate FROM customerdb WHERE customer_code = ? AND delete_flag = 0"; 
		  PreparedStatement stmt = null; 
		  ResultSet res = null; 
		  Customer customer = null; 
		  try { 
		   stmt = con.prepareStatement(sql); 
		   stmt.setString(1,custCode); 
		   res = stmt.executeQuery(); 
		   if (res.next()) { 
		    customer = new Customer ( 
		      res.getString("customer_code"), 
		      res.getString("customer_name"), 
		      res.getString("customer_telno"), 
		      res.getString("customer_postalcode"), 
		      res.getString("customer_address"), 
		      res.getInt("discount_rate")); 
		   } 
		  } finally { 
		   if (res != null) { 
		    res.close(); 
		   } 
		   if (stmt != null) { 
		    stmt.close(); 
		   } 
		  } 
		   
		  return customer;
	}
	
}