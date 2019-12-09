/**
 * 
 */
package mainPackage;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Rasim
 *
 */
public class Staff {
	private String fullName;
	private String staffPhoneNumber;
	private String staffAddress;
	
	
	
//	public inspectionReport(DatabaseManager dbManager){
//		
//				
//		
//		this.dbManager = dbManager;
//		Scanner input = new Scanner(System.in);
//		// Constructor Method
//		System.out.println("Are you a customer(enter c) or staff(enter s)?");
//		char type = input.next().charAt(0);
//		
//		if(Character.toLowerCase(type) == 'c') {
//			CustomerConsoleQuestions(CAR_CATEGORIES);
//		}
//		
//		
//		
//	}
//	
	
	
	
	
	
	
	public boolean checkOutVehicle(Car carWillBeCheckedOut, Customer currentCustomer)
	{
		// Missing implementation
		return true;
	}
	
	
	public boolean reserveVehicle(Car carWillBeReserved, Customer currentCustomer)
	{
		// Implementation
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
		return true;
	}


	public String getFullName() {
		return fullName;
	}


	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

}
