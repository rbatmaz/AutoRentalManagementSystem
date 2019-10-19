/**
 * 
 */
package mainPackage;

/**
 * @author Rasim
 *
 */
public class Car {
	private int year;
	private int milageBeforeRent;  // [km]
	private int milageAfterRent;   // [km]
	private String color;
	private String type;
	private String transmissionType;
	private String make;
	private String model;
	private int seatNumber;
	// private int location;
	
	public String getTransmissionType() {
		return transmissionType;
	}
	public void setTransmissionType(String transmissionType) {
		this.transmissionType = transmissionType;
	}

}
