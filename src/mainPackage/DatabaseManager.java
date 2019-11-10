
package mainPackage;

import java.sql.*;

public class DatabaseManager {

	// This class is supposed to handle DB CRUD operations
	
	public DatabaseManager()
	{
		System.out.println("Constructor method is getting executed...");
	}
		
	
	public Connection createDbConnection()
	{
		Connection dbConnection = null;
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");  
			dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/arms","root",""); 
		}
		catch(Exception e)
		{
			System.out.println(e);
		} 		
		return dbConnection;
	}
	
	public ResultSet executeQuery(Connection dbConnection, String query)
	{
		ResultSet resultOfTheQuery = null;
		
		try
		{
			Statement stmt=dbConnection.createStatement();  
			resultOfTheQuery=stmt.executeQuery(query); 	
		}
		catch(Exception e)
		{
			System.out.println(e);
		} 		
		
		
		return resultOfTheQuery;		
	}
	
	
	

}
