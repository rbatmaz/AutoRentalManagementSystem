/**
 * 
 */
package mainPackage;


/**
 * @author Rasim
 *
 */
public class Car {
	private String make;
	private String model;
	private int year;
	private int milageBeforeRent;  // [km]
	private int milageAfterRent;   // [km]
	private String color;
	private String transmission;
	
	private int seatNumber;
	// private int location;
	
	public String getTransmissionType() {
		return transmission;
	}
	public void setTransmissionType(String transmissionType) {
		this.transmission = transmissionType;
	}

}
