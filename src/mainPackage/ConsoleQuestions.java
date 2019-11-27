package mainPackage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class ConsoleQuestions
{
	// This class will behave as Front End of the App
	
	DatabaseManager dbManager;
	
	
	public ConsoleQuestions(DatabaseManager dbManager)
	{
		this.dbManager = dbManager;
		Scanner input = new Scanner(System.in);
		// Constructor Method
		System.out.println("Are you a customer(enter c) or staff(enter s)?");
		char type = input.next().charAt(0);
		
		if(type == 'c') {
			CustomerConsoleQuestions();
		}
		
		
		
	}
	
	
	public Customer CustomerConsoleQuestions() {
		Scanner input = new Scanner(System.in);
		Customer newCustomer = new Customer();

		boolean isExistedCustomer = false;
		
		System.out.println("Please enter your driver license number?");
		String driverLicenseNum = input.nextLine();
		
		String query =  "SELECT * from car;";
		
		ResultSet rs = dbManager.executeSQL(query);
		
		try {
			while(rs.next()) {
				if(rs.getString(2).contentEquals(driverLicenseNum)){
					isExistedCustomer = true;
					break;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		if(isExistedCustomer == false) {
			System.out.println("Please enter your full name?");
			String fullName = input.nextLine();
		
			System.out.println("Please enter your phone number?");
			String customerPhoneNumber = input.nextLine();
		
			System.out.println("Please enter your address?");
			String customerAddress = input.nextLine();
			
			newCustomer = new Customer(fullName,driverLicenseNum, customerPhoneNumber, customerAddress);
			
		}
		else {
			
			
			try {
				newCustomer = new Customer(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getInt(5), rs.getInt(6) );
			} catch (Exception e) {
				System.out.println(e);
			}
		
		}
	
	
		System.out.println(newCustomer.getCustomerInfo());
		newCustomer.createCustomerDb(this.dbManager);
		return null;
	}

	
	
}
