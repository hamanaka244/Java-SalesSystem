package jsys.sales.logic;

import java.sql.Connection;
import java.sql.SQLException;

import jsys.sales.common.SalesBusinessException;
import jsys.sales.common.SalesSystemException;
import jsys.sales.dao.ConnectionManager;
import jsys.sales.dao.CustomerDAO;
import jsys.sales.entity.Customer;

public class CustomerLogic {
	private CustomerDAO dao;
	
	 /**
     * 得意先情報をデータベースから検索する
     * @param custCode 検索する得意先コード
     * @return 検索結果のCustomerオブジェクト
     */
    public Customer findCustomer(String custCode) throws SalesBusinessException, SalesSystemException, ClassNotFoundException {
        Connection con = null;
        Customer customer = null;
        try {
            con = ConnectionManager.getConnection();
            dao = new CustomerDAO(con);
            customer = dao.findCustomer(custCode);
            
            if (customer == null) {
                throw new SalesBusinessException("該当する得意先コードは存在しません。");
            }
        } catch (SQLException e) {
            throw new SalesSystemException("システムエラーが発生しました。システム管理者に連絡してください。");
        } finally {
            closeConnection(con);
        }
        return customer;
    }

	
	public int insertCustomer(String custCode, String custName, String telNo, String postalCode, String address, String discountRate) throws SalesBusinessException, SalesSystemException, ClassNotFoundException {
	    Connection con = null;
        int result = 0;
        try {
            con = ConnectionManager.getConnection();
            dao = new CustomerDAO(con);
            result = dao.insertCustomer(custCode, custName, telNo, postalCode, address, discountRate);
        } catch (SQLException e) {
            throw new SalesSystemException("システムエラーが発生しました。");
        } finally {
            closeConnection(con);
        }
        return result;
    }
	
    public int updateCustomer(String custCode, String custName, String telNo, String postalCode, String address, String discountRate) throws SalesBusinessException, SalesSystemException, ClassNotFoundException {
        Connection con = null;
        int result = 0;
        try {
            con = ConnectionManager.getConnection();
            dao = new CustomerDAO(con);
            result = dao.updateCustomer(custCode, custName, telNo, postalCode, address, discountRate);
        } catch (SQLException e) {
            throw new SalesSystemException("システムエラーが発生しました。");
        } finally {
            closeConnection(con);
        }
        return result;
    }

    
    public int deleteCustomer(String custCode) throws SalesBusinessException, SalesSystemException, ClassNotFoundException {
        Connection con = null;
        int result = 0;
        try {
            con = ConnectionManager.getConnection();
            dao = new CustomerDAO(con);
            result = dao.deleteCustomer(custCode);
        } catch (SQLException e) {
            throw new SalesSystemException("システムエラーが発生しました。");
        } finally {
            closeConnection(con);
        }
        return result;
    }
	
    
    
    public int alldeleteCustomer(String custCode) throws SalesBusinessException, SalesSystemException, ClassNotFoundException {
        Connection con = null;
        int result = 0;
        try {
            con = ConnectionManager.getConnection();
            dao = new CustomerDAO(con);
            result = dao.alldeleteCustomer(custCode);
        } catch (SQLException e) {
            throw new SalesSystemException("システムエラーが発生しました。");
        } finally {
            closeConnection(con);
        }
        return result;
    }
	
    private void closeConnection(Connection con) throws SalesSystemException {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            throw new SalesSystemException("システムエラーが発生しました。");
        }
    }
}
	
	
	
	
	
	/*public int findCustomer(String custCode,String custName,String telNo,String postalCode,String address,String discountRate) throws SalesBusinessException, SalesSystemException, ClassNotFoundException{
		Connection con = null;
		int result = 0;
		try {
			con = ConnectionManager.getConnection();
			CustomerRegistDAO customerRegistDAO = new CustomerRegistDAO(con);
			result = customerRegistDAO.insertCustomer(custCode,custName,telNo,postalCode,address,discountRate);

			
			
			
			
			
			if(result == 0) {
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
		return result;
	}
	
}*/
