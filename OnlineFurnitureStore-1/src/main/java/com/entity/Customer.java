package com.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Customer")
public class Customer extends FurnitureUser {

	@Column(name = "name", nullable = false, length = 20)
	@Pattern(regexp = "^[A-Za-z ]{1,20}$")
	@Size(max = 30, message = "Name should be less than or equal to 30 characters")
	@NotBlank(message = "Name should not be blank")
	private String name;

	@OneToOne(targetEntity = Address.class, cascade = CascadeType.ALL)
	@JoinColumn(name = "addressid", referencedColumnName = "addressId")
	private Address address;

	@Column(name = "contactno", unique = true, nullable = false, length = 10)
	@Pattern(regexp = "^[6|7|8|9]{1}[0-9]{9}$")
	@Size(max = 10, message = "Contact number must be 10 numbers")
	private String contactNo;

	/*
	 * @Column(name = "email", unique = true, nullable = true, length = 25)
	 * 
	 * @Pattern(regexp = "^[A-Z0-9+_.-]+@[A-Z0-9.-]+$")
	 * 
	 * @Size(max = 100, message = "Enter a valid email")
	 */
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Customer(String name, int addressid, String city, String state, String country, String pincode,
			String contactNo, String email) {
		super();
		this.name = name;
		this.address = new Address(addressid, city, state, country, pincode);
		this.contactNo = contactNo;
		this.email = email;
	}

	public Customer(String name, Address address, String contactNo, String email) {
		super();
		this.name = name;
		this.address = address;
		this.contactNo = contactNo;
		this.email = email;
	}

	public Customer() {
		super();
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", address=" + address + ", contactNo=" + contactNo + ", email=" + email
				+ "]";
	}

}
