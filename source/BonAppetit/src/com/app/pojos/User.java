package com.app.pojos;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class User 
{
	private Integer userId;
	private String name,email,password,confirmPassword;
	private Role role;
	private String phoneNumber;
	private String address;
	private Location location;
	private List<Order> orders = new ArrayList<>();
	
	public User() {}
		
	public User(String name, String email, String password, String confirmPassword, Role role, String phoneNumber,
			String address, Location location) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.role = role;
		this.phoneNumber = phoneNumber;
		this.address = address;
		this.location = location;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}


	@Column(length = 20)
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@Column(length = 20,unique = true)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(length = 20,nullable = false)
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Transient
	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Column(length = 20,name = "phone_number")
	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(length = 100)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	@OneToOne
	@JoinColumn(name = "location_id")
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@OneToMany(mappedBy = "user",cascade = CascadeType.ALL,orphanRemoval = true)
	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + ", email=" + email + ", role=" + role + ", phoneNumber="
				+ phoneNumber + ", address=" + address + ", location=" + location + "]";
	}

	
	
}