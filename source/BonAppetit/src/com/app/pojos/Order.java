package com.app.pojos;

import java.util.*;

import javax.persistence.*;

@Entity
@Table(name = "orders")
public class Order 
{
	private Integer orderId;
	private String status;
	private double totalAmount;
	private User user;
	private Date oDate;
	private Payment payment;
	private Hotel hotel;
	private List<OrderDetails> orderDetails = new ArrayList<>();
	
	
	public Order() {}
	
	
	public Order(String status, double totalAmount, Date oDate) {
		super();
		this.status = status;
		this.totalAmount = totalAmount;
		this.oDate = oDate;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	public Integer getOrderId() {
		return orderId;
	}


	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	@Column(length = 20)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
	@Column(name = "total_amount")
	public double getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}


	@ManyToOne
	@JoinColumn(name = "user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name = "order_date")
	public Date getoDate() {
		return oDate;
	}
	public void setoDate(Date oDate) {
		this.oDate = oDate;
	}
	
	@OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "hotel_id")
	public Hotel getHotel() {
		return hotel;
	}


	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	@OneToMany(mappedBy = "currentOrder",cascade = CascadeType.ALL,orphanRemoval = true)
	public List<OrderDetails> getOrderDetails() {
		return orderDetails;
	}


	public void setOrderDetails(List<OrderDetails> orderDetails) {
		this.orderDetails = orderDetails;
	}	
	
	//convenience method
	public void addOrderDetails(OrderDetails o)
	{
		orderDetails.add(o);
		o.setCurrentOrder(this);
	}
	
	public void removeOrderDetails(OrderDetails o)
	{
		orderDetails.remove(o);
		o.setCurrentOrder(null);
	}


	@Override
	public String toString() {
		return "Order [order_id=" + orderId + ", status=" + status + ", total_amount=" + totalAmount + ", user="
				+ user + ", o_date=" + oDate + ", payment=" + payment + "]";
	}

	
}