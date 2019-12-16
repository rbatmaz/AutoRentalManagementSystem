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
		
		/*dbMAnager is going to create a single connection to the database. Only dbManager object is going
		 to be used to create connection with Database.		
		*/
		DatabaseManager dbManager = new DatabaseManager();
		
		/*dbManager is passed as argument to console questions to make connection to database. Because 	
		 interaction with customer requires database operations such as READ, for ex: 
		 bring all the economy cars from the database
		 */	
		ConsoleQuestions frontEnd = new ConsoleQuestions(dbManager);
		
		
		
		Customer currentCustomer = frontEnd.getCurrentInteractedCustomer();
		
		System.out.println("Rental cost  for "+ currentCustomer.getFullName() +" is " +currentCustomer.getRentalCost() + ".");
		
		// Check whether existing customer... If yes, UPDATE, otherwise CREATE new one.
		// by looking at Driver License
		
		boolean isAlreadyExisting = currentCustomer.IsExistingCustomer(dbManager); // TODO: This method should be implemented
		
		if (isAlreadyExisting)
		{
			// UPDATE
		}
		else
		{
			boolean isSuccess = currentCustomer.createCustomerDb(dbManager);
		}

	}

}
