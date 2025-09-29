package jsys.sales.entity;

import java.io.Serializable;

public class Employee implements Serializable{
	
	private String employeeNo;
	
	private String employeeName;
	
	private String password;
	
	public Employee() {
	}

	public Employee(String employeeNo, String employeeName, String password) {
		this.employeeNo = employeeNo;
		this.employeeName = employeeName;
		this.password = password;
	}
	
	
	public String getEmployeeNo() {
		return employeeNo;
	}

	public void setEmployeeNo(String employeeNo) {
		this.employeeNo = employeeNo;
	}

	
	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
}
