package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Cart")
public class Cart {

	@Id
	private int cartId;

	@Column(name = "OrderNum", nullable = false, length = 50)
	private int orderNum;

	@ManyToOne(targetEntity = Customer.class, optional = false)
	private Customer customer;

	@ManyToOne(targetEntity = Furniture.class, optional = false)
	private Furniture furniture;

	@Column(name = "Quantity", nullable = false, length = 50)
	@NotBlank(message = "Quantity should not be blank")
	private int quantity;

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getOrderNum() {
		return orderNum;
	}

	public void setOrderNum(int orderNum) {
		this.orderNum = orderNum;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Furniture getFurniture() {
		return furniture;
	}

	public void setFurniture(Furniture furniture) {
		this.furniture = furniture;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Cart(int cartId, int orderNum, Customer customer, Furniture furniture, int quantity) {
		super();
		this.cartId = cartId;
		this.orderNum = orderNum;
		this.customer = customer;
		this.furniture = furniture;
		this.quantity = quantity;
	}

	public Cart() {
		super();
	}

	@Override
	public String toString() {
		return "Cart [cartId=" + cartId + ", orderNum=" + orderNum + ", customer=" + customer + ", furniture="
				+ furniture + ", quantity=" + quantity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + cartId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cart other = (Cart) obj;
		if (cartId != other.cartId)
			return false;
		return true;
	}

}
