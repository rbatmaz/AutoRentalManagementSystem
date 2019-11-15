/**
 * 
 */
package mainPackage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Rasim
 *
 */
public class Customer {
	
	private String fullName;
	private String driverLicenseNum;
	private String customerPhoneNumber;
	private String customerAddress;
	
	public Customer(String fullName, String driverLicenseNum, String phoneNum, String address)
	{
		this.fullName = fullName;
		this.driverLicenseNum = driverLicenseNum;
		this.customerPhoneNumber = phoneNum;
		this.customerAddress = address;
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
		Connection myConnection = dbManager.createDbConnection();
		String dbQuery = "UPDATE 'car' SET 'isReserved' = '0' WHERE 'car'.'ID' = 2";
		
		
		ResultSet results = dbManager.executeQuery(myConnection, dbQuery);
		
		try {
			while(results.next())  
			{
				System.out.println(results.getString(1)+"  "+results.getString(2)+"  "+results.getInt(3));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		
		return true;
	}
	
	public boolean cancelReservation()
	{
		// TBD
		return true;
	}
	
	

}
