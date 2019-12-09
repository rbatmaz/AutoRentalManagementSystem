/**
 * 
 */
package mainPackage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Rasim
 *
 */
public class Car {
	private String make;
	private String model;
	private int year;
	private int milageBeforeRent;  // [km]
	private Integer milageAfterRent = null;   // [km]
	private String color;
	private String transmission;
	private int seatNumber;
	private int rentRate;
	private boolean isReserved;
	private boolean isInsuranced;
	private boolean isCheckedOut;
	private boolean isPrefilled;
	private boolean isRentGps;
	private String category;
	
	
	private static List<String> CATEGORY_TYPES = Arrays.asList("ECONOMY", "FULL SIZE", "LUXURY", "VAN", "EXOTIC");
	

	
	public Car(String make,String model, int year, int milageBeforeRent, String color, String transmission, 
			int seatNumber, int rentRate, String category ) {
		
		if(CATEGORY_TYPES.contains(category) == false) {
			throw new IllegalArgumentException("The given category " + category  + " is not valid.");
		}
		this.make = make;
		this.model = model;
		this.year = year;
		this.milageBeforeRent = milageBeforeRent;

		this.color = color;
		this.transmission = transmission;
		this.seatNumber = seatNumber;
		this.rentRate = rentRate;
		this.isReserved = false;
		this.isCheckedOut = false;
		this.isInsuranced = false;
		this.setCategory(category);
		this.setModel(model);
		
	
	}
	
	public boolean createCarDb(DatabaseManager dbManager) 
	{
		boolean result = false;
		try
		{
			String dbQuery = "INSERT INTO car (make, model, year, color, transmission, seatNumber, rentRate, isReserved, isCheckedOut, category) "
					+ "VALUES ("+ "\"" + this.make + "\"" + " , "+ "\"" + this.model + "\"" + " , "+ this.year  + 
				" , "+ "\"" + this.color + "\"" + " , "+ "\"" + this.transmission + "\"" + "," + this.seatNumber + "," + this.rentRate 	+ ","+ this.isReserved +"," + this.isCheckedOut + " , " + this.category +");";
			
			
			
			System.out.println(dbQuery);
			int isSuccess = dbManager.updateTable(dbQuery);
			
			if (isSuccess == 1)
			{
				System.out.println("Car has successfully been created in DB");
				result = true;
			}
			else
			{
				System.out.println("ERROR: Failed to write car info in DB!");
				result = false;
				
			}
			
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		
		
		return result;	
		
		
		
	}
	
	
	
	
	
	public String getTransmissionType() {
		return transmission;
	}
	public void setTransmissionType(String transmissionType) {
		this.transmission = transmissionType;
	}
	/**
	 * @return the milageAfterRent
	 */
	public int getMilageAfterRent() {
		return milageAfterRent;
	}
	/**
	 * @param milageAfterRent the milageAfterRent to set
	 */
	public void setMilageAfterRent(int milageAfterRent) {
		this.milageAfterRent = milageAfterRent;
	}
	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}
	/**
	 * @param make the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}
	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * @param model the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}
	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		this.year = year;
	}
	/**
	 * @return the milageBeforeRent
	 */
	public int getMilageBeforeRent() {
		return milageBeforeRent;
	}
	/**
	 * @param milageBeforeRent the milageBeforeRent to set
	 */
	public void setMilageBeforeRent(int milageBeforeRent) {
		this.milageBeforeRent = milageBeforeRent;
	}
	/**
	 * @return the color
	 */
	public String getColor() {
		return color;
	}
	/**
	 * @param color the color to set
	 */
	public void setColor(String color) {
		this.color = color;
	}
	/**
	 * @return the seatNumber
	 */
	public int getSeatNumber() {
		return seatNumber;
	}
	/**
	 * @param seatNumber the seatNumber to set
	 */
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	/**
	 * @return the rentRate
	 */
	public int getRentRate() {
		return rentRate;
	}
	/**
	 * @param rentRate the rentRate to set
	 */
	public void setRentRate(int rentRate) {
		this.rentRate = rentRate;
	}
	/**
	 * @return the isReserved
	 */
	public boolean isReserved() {
		return isReserved;
	}
	/**
	 * @param isReserved the isReserved to set
	 */
	public void setReserved(boolean isReserved) {
		this.isReserved = isReserved;
	}
	/**
	 * @return the isCheckedOut
	 */
	public boolean isCheckedOut() {
		return isCheckedOut;
	}
	/**
	 * @param isCheckedOut the isCheckedOut to set
	 */
	public void setCheckedOut(boolean isCheckedOut) {
		this.isCheckedOut = isCheckedOut;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	public boolean isInsuranced() {
		return isInsuranced;
	}
	
	public void setInsuranced(boolean isInsuranced) {
		this.isInsuranced = isInsuranced;
	}
	
	
}
