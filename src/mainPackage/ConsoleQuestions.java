package mainPackage;
import java.sql.Array;
import java.sql.ResultSet;
import java.lang.Character;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import java.util.regex.*;  
public class ConsoleQuestions
{
	// This class will behave as Front End of the App
	
	DatabaseManager dbManager;
	private Customer currentInteractedCustomer = null;

	

	
	
	public ConsoleQuestions(DatabaseManager dbManager){
		
		Map <Integer, CarCategory> CAR_CATEGORIES = new HashMap<>();
		
		//Add categories
		CAR_CATEGORIES.put(1, new CarCategory("ECONOMY"));
		CAR_CATEGORIES.put(2, new CarCategory("FULL SIZE"));
		CAR_CATEGORIES.put(3, new CarCategory("LUXURY"));
		CAR_CATEGORIES.put(4, new CarCategory("VAN"));
		CAR_CATEGORIES.put(5, new CarCategory("EXOTIC"));
		
				
		
		this.dbManager = dbManager;
		Scanner input = new Scanner(System.in);
		// Constructor Method  --> Is this really a constructor method?
		
		
		System.out.println("Are you a customer (enter c) or staff (enter s) ?"); // Baska birsey yazilirsa uyari ver
		char type = input.next().charAt(0);
		type = Character.toUpperCase(type);
		
		while(type != 'C') { // Buraya 'S' kismini nasil ekeyebilirim ???
			System.out.println("Your input is not valid. Please enter 'C' for customer or 'S' for staff");
			type = input.next().charAt(0);
			type =Character.toUpperCase(type);
		}
		
		if(Character.toUpperCase(type) == 'C') {
			this.currentInteractedCustomer = CustomerConsoleQuestions(CAR_CATEGORIES);
		}
		
		// Else kismina staff kismini mi yapmak lazim?
		
	}
	
	public static boolean isNumeric(String strNum) {
	    if (strNum == null) {
	        return false;
	    }
	    try {
	        double d = Double.parseDouble(strNum);
	    } catch (NumberFormatException nfe) {
	        return false;
	    }
	    return true;
	}
	
	
	public Customer CustomerConsoleQuestions(Map <Integer, CarCategory> CAR_CATEGORIES) { // BU nedir? Omere sor ???
		Scanner input = new Scanner(System.in);
		Customer newCustomer = new Customer();

		boolean isExistingCustomer = false;
		
		System.out.println("Please enter your driver license number?"); 
		String driverLicenseNum = input.nextLine().toUpperCase(); 

		while(Character.isLetter(driverLicenseNum.charAt(0)) == false || driverLicenseNum.length() != 15 ) {
			System.out.println("Your input format is wrong. Please start typing with the first letter of your last name and the length should be 15 character.");
			driverLicenseNum = input.nextLine().toUpperCase();
		}
		newCustomer.setDriverLicenseNum(driverLicenseNum);
		
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
		
		if(isExistingCustomer == false) {
			
			
			System.out.println("Please enter your full name?");
			String fullName = input.nextLine().toUpperCase();
			
			while(fullName.contains(" ") == false) {
				
				System.out.println("Your input format is wrong. Please provide your first name and last name.");
				fullName = input.nextLine().toUpperCase();
				
			}
				
			
			

			
			
			
			
			newCustomer.setFullName(fullName);
		
			System.out.println("Please enter your phone number?"); // Baska birsey yazilirsa uyari ver
			String customerPhoneNumber = input.nextLine();
			
			Pattern p = Pattern.compile("^\\(?([0-9]{3})\\)?[-. ]*([0-9]{3})[-. ]*([0-9]{4})$");
			
			Matcher m = p.matcher(customerPhoneNumber);
					
			while(m.matches() == false) {
				
				System.out.println("Your input format is wrong. Please provide your phone number again.");
				customerPhoneNumber = input.nextLine();
				m = p.matcher(customerPhoneNumber);
				
				
			}
			
			
			
			newCustomer.setCustomerPhoneNumber(customerPhoneNumber);
			

			
			System.out.println("Please enter your address?");
			String customerAddress = input.nextLine().toUpperCase();
			Pattern addressPattern =  Pattern.compile("^[#.0-9a-zA-Z\\s,-]+$");
			
			Matcher adressMatcher = addressPattern.matcher(customerAddress);
			
			while(adressMatcher.matches() == false) {
				
				System.out.println("Your input format is wrong. Please provide your address again.");
				customerAddress = input.nextLine();
				adressMatcher = addressPattern.matcher(customerAddress);
			}
			newCustomer.setCustomerAddress(customerAddress);
		}
		
		else 
		{
			try {
				newCustomer = new Customer(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getInt(5) );
			} catch (Exception e) {
				System.out.println(e);
			}
		
		}
		
		
		
		System.out.println("Please choose car category.\n 1)ECONOMY \n 2)FULL SIZE \n 3)LUXURY \n 4)VAN \n 5)EXOTIC \n");
		String category = input.nextLine();
		 ArrayList<Integer> catArr = new ArrayList<Integer>(5);
		 
		 for(int i=0; i <= 5; i++) {
			 catArr.add(i);
		 }
		
		
		while(isNumeric(category) ==false  || catArr.contains(Integer.parseInt(category)) == false) {
			System.out.println("Your input format is wrong. Please enter a number from 1 to 5.");
			System.out.println("1)ECONOMY \n 2)FULL SIZE \n 3)LUXURY \n 4)VAN \n 5)EXOTIC \n");
			category = input.nextLine();
			
		}
		
		Integer insuranceCost = CAR_CATEGORIES.get(Integer.parseInt(category)).getInsuranceCost();
		Integer preFilledCost = CAR_CATEGORIES.get(Integer.parseInt(category)).getPreFilledGasCost();
		
		
			
		query =  "SELECT ID,make,model,color,transmission,seatNumber,rentRate from car where Category=" + '"' + CAR_CATEGORIES.get(Integer.parseInt(category)).getCategory() + '"' + ";";
		
		result = dbManager.executeSQL(query);
		ArrayList<Integer> carIdList = new ArrayList<Integer>();
		
		try {
			System.out.println("Please enter ID of the car that you want to rent");
			System.out.printf("%-12s%-12s%-20s%-12s%-18s%-12s%s\n",
					"ID",
					"MAKE",
					"MODEL",
					"COLOR", 
					"TRANSMISSION", 
					"SEAT NO", 
					"RATE");
			
			while(result.next()) {
				
				System.out.printf("%-12s%-12s%-20s%-12s%-18s%-12s%s\n",
						String.valueOf(result.getInt(1)),
						result.getString(2).toUpperCase(),
						result.getString(3).toUpperCase(),
						result.getString(4).toUpperCase(),
						result.getString(5).toUpperCase(),
						String.valueOf(result.getInt(6)),
						String.valueOf(result.getInt(7))
						);  
				
				carIdList.add(result.getInt(1));
				

			}
			
		} 
		
		catch (Exception e) {
			System.out.println(e);
		}
		
		String reservedCarId = input.nextLine();
		
		
		while( isNumeric(reservedCarId) == false || carIdList.contains(Integer.parseInt(reservedCarId)) == false) {
			
			System.out.println("Your input ID does not exist. Please enter again.");
			reservedCarId = input.nextLine();
			
			
		}
		
		newCustomer.setReservedCarId(Integer.parseInt(reservedCarId));
		

		
		System.out.println("How many days would you like to rent the car?"); // Write the model of the car later ... Yanlis yazilirsa hata ver
		
		String rentDay = input.nextLine();
		
		
		
		while(isNumeric(rentDay) == false || Integer.parseInt(rentDay) >= 1000) {
			if(isNumeric(rentDay) == false) {
				System.out.println("Your input format is wrong. Please provide a number.");
				
			}
			else{
				System.out.println("A car cannot be rented more than 1000 days. Please enter a valid period of time.");
				
			}
			
			rentDay = input.nextLine();
			
		}

		
		newCustomer.setRentDay(Integer.parseInt(rentDay));
	
	
		
		
		System.out.println("Would you like to get insurance with an extra cost of " + insuranceCost + " CAD per day ? (Y/N)");
		
		 ArrayList<String> yesNoArr = new ArrayList<String>(2);
		
		 yesNoArr.add("Y");
		 yesNoArr.add("N");

		
		String insuranceWanted = input.nextLine().toUpperCase();
	
	
		while(yesNoArr.contains(insuranceWanted) == false ) {
			System.out.println("Your input is not valid. Please enter (Y/N)");

			insuranceWanted = input.nextLine().toUpperCase();
			
		}
		
		if(insuranceWanted.equals("Y")) 
		{
			newCustomer.setInsuranceWanted(true);
		}
		else
		{
			newCustomer.setInsuranceWanted(false);
		}
		
		
		
		System.out.println("Would you like your car prefilled with an extra cost of " + preFilledCost + " CAD ? (Y/N)" );
		String prefilled0 = input.nextLine().toUpperCase();

		
		
		while(yesNoArr.contains(prefilled0) == false ) {
			System.out.println("Your input is not valid. Please enter (Y/N)");
			System.out.println(prefilled0);
			prefilled0 = input.nextLine().toUpperCase();

		}
		
		if(prefilled0.equals("Y")) 
		{
			newCustomer.setPrefillWanted(true);
		}
		else
		{
			newCustomer.setPrefillWanted(false);
		}
		
		System.out.println("Would you like to rent GPS with an extra cost of 5 CAD per day? (Y/N)"); // Y veya N disinda birsey yazilirsa hata ver.
		String rentGps0 = input.nextLine().toUpperCase();

		
		
		while(yesNoArr.contains(rentGps0) == false) {
			System.out.println("Your input is not valid. Please enter (Y/N)");
			rentGps0 = input.nextLine().toUpperCase();

		}
		
		
		if(rentGps0.equals("Y")) 
		{
			newCustomer.setGpsWanted(true);
		}
		else
		{
			newCustomer.setGpsWanted(false);
		}
		
		newCustomer.setRentalCost(dbManager, CAR_CATEGORIES);
		

		
		return newCustomer;
	}


	/**
	 * @return the currentInteractedCustomer
	 */
	public Customer getCurrentInteractedCustomer() {
		return currentInteractedCustomer;
	}


	/**
	 * @param currentInteractedCustomer the currentInteractedCustomer to set
	 */
	public void setCurrentInteractedCustomer(Customer currentInteractedCustomer) {
		this.currentInteractedCustomer = currentInteractedCustomer;
	}




	
	
}
