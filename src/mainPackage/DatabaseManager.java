
package mainPackage;

import java.sql.*;

public class DatabaseManager {

	// This class is supposed to handle DB CRUD operations
	private Connection dbConnection;
	private Statement statement;
	
	public DatabaseManager() {
				this.createDbConnection();
	}
		
	
	public void createDbConnection() {
		
		try	{
			Class.forName("com.mysql.jdbc.Driver");  
			this.dbConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/arms","root","");
			this.statement = this.dbConnection.createStatement();  
		}
		catch(Exception e)	{
			System.out.println(e);
		} 		
	}
	
	public ResultSet executeSQL(String query) {
		
		ResultSet rs = null;
		try {
			rs = this.statement.executeQuery(query);
		} catch (Exception e) {

			System.out.println(e);
		}
		
		return rs;
		
	}
	
	public int updateTable(String query)
	{
		int result = 0;
		
		try
		{
			 result = this.statement.executeUpdate(query);
		}
		catch(Exception e)
		{
			System.out.println(e);
		} 	
		
		return result;
				
	}
	
	
	

}
