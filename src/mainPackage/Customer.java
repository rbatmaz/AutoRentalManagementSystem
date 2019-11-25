/**
 * 
 */
package mainPackage;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Rasim
 *
 */
public class Customer {
	
	private String fullName;
	private String driverLicenseNum;
	private String customerPhoneNumber;
	private String customerAddress;
	private Integer reservedCarId;
	private Integer checkoutCarId;
	
	public Customer(String fullName, String driverLicenseNum, String phoneNum, String address)
	{
		this.setFullName(fullName);
		this.setDriverLicenseNum(driverLicenseNum);
		this.setCustomerPhoneNumber(phoneNum);
		this.setCustomerAddress(address);
		this.setReservedCarId(null);
		this.setCheckoutCarId(null);
		// createCustomerDb(fullName,driverLicenseNum, phoneNum,address);
		
		
	}
	
	public void createCustomerDb(String fullName,String driverLicenseNum,String phoneNum,String address) 
	{
		// Created by Omer
	
		try {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arms", "root","");
		System.out.println("Connecting to database...");
		
		Statement stmt = conn.createStatement();
		
		System.out.println("Inserting new customer into db");
		
		String dbQuery = "INSERT INTO customer (fullName, driverLicenseNum, customerPhoneNumber, customerAddress, reservedCarId, checkoutCarId) "
				+ "VALUES ("+ "\"" + fullName + "\"" + " , "+ "\"" + driverLicenseNum+ "\"" + " , "+ "\"" + phoneNum+ "\"" + " , " + "\"" + address+ "\"" + ", null , null );";
		
		System.out.println(dbQuery);
		int rs = stmt.executeUpdate(dbQuery);   // En son burada kaldik Omer ile
		
		System.out.println(rs);
	
		conn.close();
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		
	}
	
	public boolean createCustomerDb(DatabaseManager dbManager) 
	{
		boolean result = false;
		try
		{
			String dbQuery = "INSERT INTO customer (fullName, driverLicenseNum, customerPhoneNumber, customerAddress, reservedCarId, checkoutCarId) "
					+ "VALUES ("+ "\"" + this.fullName + "\"" + " , "+ "\"" + this.driverLicenseNum + "\"" + " , "+ "\"" + this.customerPhoneNumber + "\"" + " , " + "\"" + this.customerAddress+ "\"" + ", null , null );";
			
			
			
			System.out.println(dbQuery);
			int isSuccess = dbManager.executeQuery(dbQuery);
			
			if (isSuccess == 1)
			{
				System.out.println("Customer has successfully been created in DB");
				result = true;
			}
			else
			{
				System.out.println("ERROR: Failed to write customer info in DB!");
				result = false;
				
			}
			
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		
		
		return result;	
		
		
		
	}
	
	// Attribute getter setters
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getDriverLicenseNum() {
		return driverLicenseNum;
	}
	public void setDriverLicenseNum(String driverLicenseNum) {
		this.driverLicenseNum = driverLicenseNum;
	}
	public String getCustomerPhoneNumber() {
		return customerPhoneNumber;
	}
	public void setCustomerPhoneNumber(String customerPhoneNumber) {
		this.customerPhoneNumber = customerPhoneNumber;
	}
	public String getCustomerAddress() {
		return customerAddress;
	}
	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}
	
	// Class methods
	
	public boolean reserveVehicle(Car carWillBeReserved, Customer currentCustomer, DatabaseManager dbManager)
	{
		try 
		{	
			String dbQuery = "UPDATE car SET isReserved = 1 WHERE ID = 2";
			
			int result = dbManager.executeQuery(dbQuery);

			System.out.println(result);	
		
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return true;
	}
	
	//-------------------------------------------------------------------------------------------------
	
//	public boolean selectVehicle(Car carWillBeReserved, Customer currentCustomer, DatabaseManager dbManager)
//	{
//		try {
//		Class.forName("com.mysql.jdbc.Driver");
//		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/arms", "root","");
//		System.out.println("Connecting to database...");
//		
//		Statement stmt = conn.createStatement();
//		
//		ResultSet rs = stmt.executeQuery("select * from car");
//	
//		
//
//		//String dbQuery = "UPDATE car SET isReserved = 0 WHERE ID = 2";
//		
//		
//		while(rs.next())  
//		{
//			System.out.println(rs.getString(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+ " "+ rs.getString(4));
//				
//		}
//		conn.close();
//		
//		}
//		catch(Exception e) {
//			System.out.println(e);
//		}
//		
//		return true;
//	}
//	
	
	
	
	public boolean cancelReservation()
	{
		// TBD
		return true;
	}

	/**
	 * @return the reservedCarId
	 */
	public Integer getReservedCarId() {
		return reservedCarId;
	}

	/**
	 * @param reservedCarId the reservedCarId to set
	 */
	public void setReservedCarId(Integer reservedCarId) {
		this.reservedCarId = reservedCarId;
	}

	/**
	 * @return the checkoutCarId
	 */
	public Integer getCheckoutCarId() {
		return checkoutCarId;
	}

	/**
	 * @param checkoutCarId the checkoutCarId to set
	 */
	public void setCheckoutCarId(Integer checkoutCarId) {
		this.checkoutCarId = checkoutCarId;
	}
	
	

}
