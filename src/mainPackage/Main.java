/**
 * 
 */
package mainPackage;

import java.sql.*;

/**
 * @author Rasim
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		DatabaseManager dbManager = new DatabaseManager();
		// Customer interactions
		ConsoleQuestions frontEnd = new ConsoleQuestions(dbManager);

		
		
		// TODO Auto-generated method stub
		
			
		
		
		// Create customer
		//Customer randomCustomer = new Customer("cristiano ranoldo", "D1234 2345", "647784546", "446 Havendale");
		//boolean result = randomCustomer.createCustomerDb(dbManager);
		//Car randomCar = new Car("Toyota", "Rav", 2019, 15000, "Green", "Automatic", 5, 10);
		//boolean carCreateResult = randomCar.createCarDb(dbManager);
		//boolean operationSuccess = randomCustomer.reserveVehicle(randomCar, randomCustomer, dbManager);
		
		
		
//		ResultSet results_2 = dbManager.executeQuery(myConnection, "INSERT INTO `car` (`make`, `model`, `year`, `milageBeforeRent`, `milageAfterRent`, `color`, `transmission`, `seatNumber`, `ID`) VALUES ('Toyota', 'Corolla', '2011', '132235', '0', 'Gray', 'Automatic', '5', '');");
//		ResultSet results_3 = dbManager.executeQuery(myConnection, "INSERT INTO `car` (`make`, `model`, `year`, `milageBeforeRent`, `milageAfterRent`, `color`, `transmission`, `seatNumber`, `ID`) VALUES ('Kia', 'Soul', '2018', '20234', '0', 'White', 'Automatic', '5', NULL);");
//		ResultSet results_4 = dbManager.executeQuery(myConnection, "dfgdfbfdbgbgf");
		// UPDATE `car` SET `isReserved` = '1' WHERE `car`.`ID` = 2;
		// "DELETE FROM `car` WHERE `car`.`ID` = 1"
		// UPDATE `car` SET `milageAfterRent` = '21456', `pickUpDate` = '2019-11-22', `dropOffDate` = '2019-11-28' WHERE `car`.`ID` = 2;
		

	}

}
