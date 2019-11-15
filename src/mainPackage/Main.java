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
		
		
		// TODO Auto-generated method stub
		
		DatabaseManager dbManager = new DatabaseManager();	
		
		
		// Create customer
		Customer randomCustomer = new Customer("John Bush", "D1234 2345", "647784546", "446 Havendale");
		Car randomCar = new Car();
		
		boolean operationSuccess = randomCustomer.reserveVehicle(randomCar, randomCustomer, dbManager);
		
		
		
//		ResultSet results_2 = dbManager.executeQuery(myConnection, "INSERT INTO `car` (`make`, `model`, `year`, `milageBeforeRent`, `milageAfterRent`, `color`, `transmission`, `seatNumber`, `ID`) VALUES ('Toyota', 'Corolla', '2011', '132235', '0', 'Gray', 'Automatic', '5', '');");
//		ResultSet results_3 = dbManager.executeQuery(myConnection, "INSERT INTO `car` (`make`, `model`, `year`, `milageBeforeRent`, `milageAfterRent`, `color`, `transmission`, `seatNumber`, `ID`) VALUES ('Kia', 'Soul', '2018', '20234', '0', 'White', 'Automatic', '5', NULL);");
//		ResultSet results_4 = dbManager.executeQuery(myConnection, "dfgdfbfdbgbgf");
		// UPDATE `car` SET `isReserved` = '1' WHERE `car`.`ID` = 2;
		// "DELETE FROM `car` WHERE `car`.`ID` = 1"
		// UPDATE `car` SET `milageAfterRent` = '21456', `pickUpDate` = '2019-11-22', `dropOffDate` = '2019-11-28' WHERE `car`.`ID` = 2;
		
		
		
		int x = 5;
		

	}

}
