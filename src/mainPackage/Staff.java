/**
 * 
 */
package mainPackage;

/**
 * @author Rasim
 *
 */
public class Staff {
	private String fullName;
	private String staffPhoneNumber;
	private String staffAddress;
	
	
	public boolean checkOutVehicle(Car carWillBeCheckedOut, Customer currentCustomer)
	{
		// MIssing implementation
		return true;
	}
	
	
	public boolean reserveVehicle(Car carWillBeReserved, Customer currentCustomer)
	{
		// IMplemenattion
		return true;
	}
	
	public boolean createInventory(Car car)
	{
		// Create an entry in DB for the given car
		return true;
	}
	
	public boolean deleteInventory(Car car)
	{
		// Delete the entry in DB for the given car
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
