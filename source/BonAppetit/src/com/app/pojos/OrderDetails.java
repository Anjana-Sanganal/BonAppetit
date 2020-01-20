package com.app.pojos;


import javax.persistence.*;

@Entity
@Table(name = "order_details")
public class OrderDetails 
{
	private Integer odetailsId;
	private int quantity;
	private double price;
	private Order currentOrder;
	private Item item;
	
	public OrderDetails() { }
	
	
	public OrderDetails(int quantity, double price) {
		super();
		this.quantity = quantity;
		this.price = price;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "odetails_id")
	public Integer getOdetailsId() {
		return odetailsId;
	}


	public void setOdetailsId(Integer odetailsId) {
		this.odetailsId = odetailsId;
	}
	
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	public Order getCurrentOrder() {
		return currentOrder;
	}


	public void setCurrentOrder(Order currentOrder) {
		this.currentOrder = currentOrder;
	}
	
	@ManyToOne
	@JoinColumn(name = "item_id")
	public Item getItem() {
		return item;
	}


	public void setItem(Item item) {
		this.item = item;
	}


	@Override
	public String toString() {
		return "OrderDetails [odetails_id=" + odetailsId + ", quantity=" + quantity + ", price=" + price + ", order="
				+ currentOrder + "]";
	}
	
	
}