package jsys.sales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jsys.sales.entity.Customer;

public class CustomerDAO {
	
	private Connection con;
	
	public CustomerDAO(Connection con) {
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
	
		
    // 新規登録メソッド (旧CustomerRegistDAO)
	public int insertCustomer (String custCode,String custName,String telNo,String postalCode,String address,String discountRate) throws SQLException {
		String sql = "INSERT INTO customerdb (customer_code, customer_name, customer_telno, customer_postalcode, customer_address, discount_rate) "
                + "VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement  pstmt  = null;
		int result = 0;

		try {
			//stmt = con.createStatement();質問なぜprepare？？
			//resurt = stmt.executeUpdate(sql);
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, custCode);
            pstmt.setString(2, custName);
            pstmt.setString(3, telNo);
            pstmt.setString(4, postalCode);
            pstmt.setString(5, address);
            pstmt.setInt(6, Integer.parseInt(discountRate)); // discountRateはint型なので変換
            
            result = pstmt.executeUpdate();

		} finally {
			if (pstmt != null) {
				pstmt.close();
			}
		}
		return result;
	}
	
	  // 修正メソッド
    public int updateCustomer(String custCode, String custName, String telNo, String postalCode, String address, String discountRate) throws SQLException {
        String sql = "UPDATE customerdb SET customer_name = ?, customer_telno = ?, customer_postalcode = ?, customer_address = ?, discount_rate = ? WHERE customer_code = ?";
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, custName);
            pstmt.setString(2, telNo);
            pstmt.setString(3, postalCode);
            pstmt.setString(4, address);
            pstmt.setInt(5, Integer.parseInt(discountRate));
            pstmt.setString(6, custCode);
            result = pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
        }
        return result;
    }

    // 削除メソッド (論理削除)
    public int deleteCustomer(String custCode) throws SQLException {
        String sql = "UPDATE customerdb SET delete_flag = 1 WHERE customer_code = ?";
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, custCode);
            result = pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
        }
        return result;
    }
    
    public int alldeleteCustomer(String custCode) throws SQLException {
        String sql = "DELETE FROM customerdb WHERE customer_code = ?";
        PreparedStatement pstmt = null;
        int result = 0;
        try {
            pstmt = con.prepareStatement(sql);
            pstmt.setString(1, custCode);
            result = pstmt.executeUpdate();
        } finally {
            if (pstmt != null) {
                pstmt.close();
            }
        }
        return result;
    }
}

