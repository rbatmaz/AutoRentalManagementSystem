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
	
	
	public Customer() {
		
	}
	
	public Customer(String fullName, String driverLicenseNum, String phoneNum, String address, Integer reservedCarId, Integer checkoutCarId)
	{
		this.setFullName(fullName);
		this.setDriverLicenseNum(driverLicenseNum);
		this.setCustomerPhoneNumber(phoneNum);
		this.setCustomerAddress(address);
		this.setReservedCarId(reservedCarId);
		this.setCheckoutCarId(checkoutCarId);
	}


	public Customer(String fullName, String driverLicenseNum, String phoneNum, String address)
	{
		this.setFullName(fullName);
		this.setDriverLicenseNum(driverLicenseNum);
		this.setCustomerPhoneNumber(phoneNum);
		this.setCustomerAddress(address);
		this.setReservedCarId(null);
		this.setCheckoutCarId(null);
	}
	
	
	public Customer(int rentDay, boolean insurance, boolean prefilled, boolean rentGps) {
		// TODO Auto-generated constructor stub
		
		this.setRentDay(rentDay);
		this.setInsurance(insurance);
		this.setPrefilled(prefilled);
		this.setRentGps(rentGps);
		
	}

	public boolean createCustomerDb(DatabaseManager dbManager){

		boolean result = false;
		try	{
			String dbQuery = "INSERT INTO customer (fullName, driverLicenseNum, customerPhoneNumber, customerAddress, reservedCarId, checkoutCarId) "
					+ "VALUES ("+ "\"" + this.fullName + "\"" + " , "+ "\"" + this.driverLicenseNum + "\"" + " , "+ "\"" + this.customerPhoneNumber + "\"" + " , " + "\"" + this.customerAddress+ "\"" +
					","+ this.reservedCarId +"," + this.checkoutCarId +");";
			
			
			
			System.out.println(dbQuery);
			int isSuccess = dbManager.updateTable(dbQuery);
			
			if (isSuccess == 1)	{
				System.out.println("Customer has successfully been created in DB");
				result = true;
			}
			else{
				System.out.println("ERROR: Failed to write customer info in DB!");
				result = false;
				
			}
			
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		return result;	
	}
	
	public String getCustomerInfo() {
		
		String info = "customer name = " + this.fullName + "\n" + "customer driver license = " + this.driverLicenseNum
		+ "\n" + "customer phone number = " +  this.customerPhoneNumber + "\n" + "customer address = " + this.customerAddress
		+ "\n" + "reserved car = " + this.reservedCarId + "\n" + "checked out car = " + this.checkoutCarId + "\n";
		
		return info;
	}
	

	
	// Attribute getter setters
	//public Customer(int rentDay, char insurance, char prefilled, char rentGps)
	
	public int setRentDay(int rentDay) {
		return rentDay;
	}
	
	public char setInsurance0(char insurance0) {
		return insurance0;
	}
	
	public boolean setInsurance(boolean insurance) {
		return insurance;
	}
	
	public char setPrefilled0(char prefilled0) {
		return prefilled0;
	}
	
	public boolean setPrefilled(boolean prefilled) {
		return prefilled;
	}
	
	public char setRentGps0(char rentGps0) {
		return rentGps0;
	}
	
	public boolean setRentGps(boolean rentGps) {
		return rentGps;
	}
	
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
			
			int result = dbManager.updateTable(dbQuery);

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
