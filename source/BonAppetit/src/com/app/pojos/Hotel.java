package com.app.pojos;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "hotel")
public class Hotel 
{
	private Integer hotel_id;
	private String name;
	private Location locationId;
	private List<Order> orders = new ArrayList<>();
	private List<Item> items = new ArrayList<>();
	
	public Hotel() {}
	
	
	public Hotel(String name, Location locationId) {
		super();
		this.name = name;
		this.locationId = locationId;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hotel_id")
	public Integer getHotel_id() {
		return hotel_id;
	}
	public void setHotel_id(Integer hotel_id) {
		this.hotel_id = hotel_id;
	}
	
	@Column(length = 20)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	@OneToOne
	@JoinColumn(name = "location_id")
	public Location getLocationId() {
		return locationId;
	}


	public void setLocationId(Location locationId) {
		this.locationId = locationId;
	}


	@OneToMany(mappedBy = "hotel",cascade = CascadeType.ALL)
	public List<Order> getOrders() {
		return orders;
	}

	
	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@OneToMany(mappedBy = "currentHotel",cascade = CascadeType.ALL)
	public List<Item> getItems() {
		return items;
	}


	public void setItems(List<Item> items) {
		this.items = items;
	}


	@Override
	public String toString() {
		return "Hotel [hotel_id=" + hotel_id + ", name=" + name + ", locationId=" + locationId + "]";
	}
	
	
}