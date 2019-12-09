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
	
	private String fullName = "";
	private String driverLicenseNum = "";
	private String customerPhoneNumber = "";
	private String customerAddress = "";
	private Integer reservedCarId = -1;
	private Integer checkoutCarId = -1;
	private boolean isInsuranceWanted;
	private boolean isPrefillWanted;
	private boolean isGpsWanted;
	private Integer rentDay;
	
	
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
		
		this.rentDay = rentDay;
		this.isInsuranceWanted = insurance;
		this.isPrefillWanted = prefilled;
		this.isGpsWanted = rentGps;
		
	}

	public boolean createCustomerDb(DatabaseManager dbManager){

		boolean result = false;
		try	{
			String dbQuery = "INSERT INTO customer ("
					+ "fullName,"
					+ "driverLicenseNum, "
					+ "customerPhoneNumber, "
					+ "customerAddress, "
					+ "reservedCarId, "
					+ "checkoutCarId) "
					+ "VALUES ("+ "\"" + 
					this.fullName + "\"" + " , "+ "\"" + 
					this.driverLicenseNum + "\"" + " , "+ "\"" + 
					this.customerPhoneNumber + "\"" + " , " + "\"" + 
					this.customerAddress+ "\"" + ","+ 
					this.reservedCarId +"," + 
					this.checkoutCarId +");";
			
			
			
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

	/**
	 * @return the isInsuranceWanted
	 */
	public boolean isInsuranceWanted() {
		return isInsuranceWanted;
	}

	/**
	 * @param isInsuranceWanted the isInsuranceWanted to set
	 */
	public void setInsuranceWanted(boolean isInsuranceWanted) {
		this.isInsuranceWanted = isInsuranceWanted;
	}

	/**
	 * @return the isPrefillWanted
	 */
	public boolean isPrefillWanted() {
		return isPrefillWanted;
	}

	/**
	 * @param isPrefillWanted the isPrefillWanted to set
	 */
	public void setPrefillWanted(boolean isPrefillWanted) {
		this.isPrefillWanted = isPrefillWanted;
	}

	/**
	 * @return the isGpsWanted
	 */
	public boolean isGpsWanted() {
		return isGpsWanted;
	}

	/**
	 * @param isGpsWanted the isGpsWanted to set
	 */
	public void setGpsWanted(boolean isGpsWanted) {
		this.isGpsWanted = isGpsWanted;
	}

	/**
	 * @return the rentDay
	 */
	public Integer getRentDay() {
		return rentDay;
	}

	/**
	 * @param rentDay the rentDay to set
	 */
	public void setRentDay(Integer rentDay) {
		this.rentDay = rentDay;
	}

	public boolean IsExistingCustomer() {
		boolean isExistingCustomer = false;
		
//		System.out.println("Please enter your driver license number?"); // Driver license validate et. Yanlis yazilmissa uyari ver ...
//		String driverLicenseNum = input.nextLine().toUpperCase();
//		newCustomer.setDriverLicenseNum(driverLicenseNum);
		
		String query =  "SELECT * from customer;";
		
		ResultSet result = dbManager.executeSQL(query);
		
		try {
			while(result.next()) {
				if(result.getString(2).contentEquals(driverLicenseNum)){
					isExistingCustomer = true;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		
		
		return isExistingCustomer;
	}

	
	
	

}
