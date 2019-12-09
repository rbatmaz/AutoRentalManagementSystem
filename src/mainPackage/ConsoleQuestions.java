package mainPackage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class ConsoleQuestions
{
	// This class will behave as Front End of the App
	
	DatabaseManager dbManager;
	

	
	
	public ConsoleQuestions(DatabaseManager dbManager){
		Map <Integer, String> CAR_CATEGORIES = new HashMap<>();
		
		//Add categories
		CAR_CATEGORIES.put(1, "ECONOMY");
		CAR_CATEGORIES.put(2, "FULL SIZE");
		CAR_CATEGORIES.put(3, "LUXURY");
		CAR_CATEGORIES.put(4, "VAN");
		CAR_CATEGORIES.put(5, "EXOTIC");
		
				
		
		this.dbManager = dbManager;
		Scanner input = new Scanner(System.in);
		// Constructor Method  --> Is this really a constructor method?
		
		
		System.out.println("Are you a customer(enter c) or staff(enter s)?"); // Baska birsey yazilirsa uyari ver
		char type = input.next().charAt(0);
		
		if(Character.toLowerCase(type) == 'c') {
			CustomerConsoleQuestions(CAR_CATEGORIES);
		}
		
		// Else kismina staff kismini mi yapmak lazim?
		
	}
	
	
	public Customer CustomerConsoleQuestions(Map <Integer, String> CAR_CATEGORIES) { // BU nedir? Omere sor ???
		Scanner input = new Scanner(System.in);
		Customer newCustomer = new Customer();

		boolean isExistingCustomer = false;
		
		System.out.println("Please enter your driver license number?"); // Driver license validate et. Yanlis yazilmissa uyari ver ...
		String driverLicenseNum = input.nextLine().toUpperCase();
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
			newCustomer.setFullName(fullName);
		
			System.out.println("Please enter your phone number?"); // Baska birsey yazilirsa uyari ver
			String customerPhoneNumber = input.nextLine();
			newCustomer.setCustomerPhoneNumber(customerPhoneNumber);
		
			System.out.println("Please enter your address?");
			String customerAddress = input.nextLine().toUpperCase();
			newCustomer.setCustomerAddress(customerAddress);
			
		// newCustomer = new Customer(fullName,driverLicenseNum, customerPhoneNumber, customerAddress);
			
		}
		
		else 
		{
			
			
			try {
				newCustomer = new Customer(result.getString(1), result.getString(2), result.getString(3), result.getString(4), result.getInt(5), result.getInt(6) );
			} catch (Exception e) {
				System.out.println(e);
			}
		
		}
	
	
		System.out.println(newCustomer.getCustomerInfo());
		if(isExistingCustomer== false) 
		{
			newCustomer.createCustomerDb(this.dbManager);
		}
		
		System.out.println("Please choose car category.\n 1)ECONOMY \n 2)FULL SIZE \n 3)LUXURY \n 4)VAN \n 5)EXOTIC \n");
		Integer category = input.nextInt();
		
			
		query =  "SELECT make,model,color,transmission,seatNumber,rentRate from car where Category=" + '"' + CAR_CATEGORIES.get(category) + '"' + ";";
		
		result = dbManager.executeSQL(query);
		
		try {
			System.out.println("Please enter ID of the car that you want to rent");
			System.out.printf("%-12s%-20s%-12s%-18s%-12s%s\n",
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
						String.valueOf(result.getInt(7)));  

			}
		} 
		
		catch (Exception e) {
			System.out.println(e);
		}

		boolean insurance= false;
		boolean prefilled=false;
		boolean rentGps=false;
		
		
		System.out.println("How many days would you like to rent the car?"); // Write the model of the car later ... Yanlis yazilirsa hata ver
		int rentDay = input.nextInt();
		
		System.out.println("Would you lie to get insurance with an extra cost of 45 CAD per day ? (Y/N)"); // Bu fiyati arabanin cinsine gore degistirebilirim. Y veya N disinda birsey yazilirsa hata ver.
		char insurance0 = input.next().charAt(0);
		
		if(insurance0 == 'Y') {
		 insurance = true;
		}
		
		System.out.println("Would you like your car prefilled with an extra cost of 50 CAD ? (Y/N)" ); // Bu fiyati arabanin buyuklugune gore degistirebilirim. Y veya N disinda birsey yazilirsa hata ver.
		char prefilled0 = input.next().charAt(0);
		
		if(prefilled0 == 'Y') {
			prefilled = true;
		}
		
		System.out.println("Would you like to rent GPS with an extra cost of 5 CAD per day? (Y/N)"); // Y veya N disinda birsey yazilirsa hata ver.
		char rentGps0 = input.next().charAt(0);
		
		if(rentGps0 == 'Y') {
			rentGps = true;
		}
		
		
		// newCustomer = new Customer(rentDay,insurance,prefilled,rentGps);

		
		return newCustomer;
	}

	
	
}
