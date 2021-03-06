package com.app.pojos;

import javax.persistence.*;

@Entity
@Table(name = "payment")
public class Payment 
{
	private Integer pId;
	private String payment_mode,payment_status;
	private Order order;
	
	public Payment() {}

	public Payment(String payment_mode, String payment_status) 
	{
		this.payment_mode = payment_mode;
		this.payment_status = payment_status;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payment_id")
	public Integer getpId() {
		return pId;
	}

	public void setpId(Integer pId) {
		this.pId = pId;
	}

	@Column(length = 20)
	public String getPayment_mode() {
		return payment_mode;
	}


	public void setPayment_mode(String payment_mode) {
		this.payment_mode = payment_mode;
	}

	@Column(length = 20)
	public String getPayment_status() {
		return payment_status;
	}

	public void setPayment_status(String payment_status) {
		this.payment_status = payment_status;
	}

	@OneToOne
	@JoinColumn(name = "order_id")
	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return "Payment [p_id=" + pId + ", payment_mode=" + payment_mode + ", payment_status=" + payment_status
				+ ", order=" + order + "]";
	}
	
	
}