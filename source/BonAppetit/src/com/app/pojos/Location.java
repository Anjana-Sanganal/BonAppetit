package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "location")
public class Location 
{
	private Integer locationId;
	private String locationName;
	private int pincode;
	
	public Location() {}

	public Location(String locationName, int pincode) {
		super();
		this.locationName = locationName;
		this.pincode = pincode;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "location_id")
	public Integer getLocationId() {
		return locationId;
	}

	public void setLocationId(Integer locationId) {
		this.locationId = locationId;
	}

	@Column(name = "location_name",length = 20)
	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Location [locationId=" + locationId + ", locationName=" + locationName + ", pincode=" + pincode + "]";
	}
	
	
}
