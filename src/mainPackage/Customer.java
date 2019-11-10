/**
 * 
 */
package mainPackage;

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
	
	public boolean reserveVehicle(Car carWillBeReserved, Customer currentCustomer)
	{
		// IMplemenattion
		return true;
	}
	
	public boolean cancelReservation()
	{
		// TBD
		return true;
	}
	
	

}
