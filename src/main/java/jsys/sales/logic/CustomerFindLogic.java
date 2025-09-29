package jsys.sales.logic;

import java.sql.Connection;
import java.sql.SQLException;

import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.dao.ConnectionManager;
import jsys.sales.dao.CustomerFindDAO;
import jsys.sales.entity.Customer;


public class CustomerFindLogic {

	public Customer findCustomer(String custcord) throws SalesBusinessException, SalesSystemException, ClassNotFoundException{
		Connection con = null;
		Customer customer = null;
		try {
			con = ConnectionManager.getConnection();
			CustomerFindDAO customerfindDAO = new CustomerFindDAO(con);
			customer = customerfindDAO.findCustomer(custcord);
			
			if(customer == null) {
				throw new SalesBusinessException("該当する得意先コードは存在しません。");
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
		return customer;
	}
	
}
