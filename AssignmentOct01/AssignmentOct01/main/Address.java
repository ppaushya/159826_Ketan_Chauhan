package main;

public class Address {
	
	private String streetName;
	private String area;
	private String city;
	private String state;
	
	public Address() {
		super();
	}
	
	public Address(String streetName, String area, String city, String state) {
		super();
		this.streetName = streetName;
		this.area = area;
		this.city = city;
		this.state = state;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	
}
