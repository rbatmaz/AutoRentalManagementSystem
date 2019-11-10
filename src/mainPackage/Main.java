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
		
		Connection myConnection = dbManager.createDbConnection();
		
		ResultSet results = dbManager.executeQuery(myConnection, "select * from car");
//		ResultSet results_2 = dbManager.executeQuery(myConnection, "INSERT INTO `car` (`make`, `model`, `year`, `milageBeforeRent`, `milageAfterRent`, `color`, `transmission`, `seatNumber`, `ID`) VALUES ('Toyota', 'Corolla', '2011', '132235', '0', 'Gray', 'Automatic', '5', '');");
//		ResultSet results_3 = dbManager.executeQuery(myConnection, "INSERT INTO `car` (`make`, `model`, `year`, `milageBeforeRent`, `milageAfterRent`, `color`, `transmission`, `seatNumber`, `ID`) VALUES ('Kia', 'Soul', '2018', '20234', '0', 'White', 'Automatic', '5', NULL);");
//		ResultSet results_4 = dbManager.executeQuery(myConnection, "dfgdfbfdbgbgf");
		// "DELETE FROM `car` WHERE `car`.`ID` = 1"
		
		try {
			while(results.next())  
			{
				System.out.println(results.getString(1)+"  "+results.getString(2)+"  "+results.getInt(3));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		
		int x = 5;
		

	}

}
