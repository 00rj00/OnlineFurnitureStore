package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Address")
public class Address {
	@Id
	@Column(name = "addressid")
	private int addressId;
	@Column(name = "city", length = 20, nullable = false)
	@Pattern(regexp = "^[A-Za-z ]{1,20}$")
	@Size(max = 20, message = "City name should be less than 20 characters")
	private String city;
	@Column(name = "state", length = 20, nullable = false)
	@Pattern(regexp = "^[A-Za-z ]{1,20}$")
	@Size(max = 20, message = "State name should be less than 20 characters")
	private String state;
	@Column(name = "country", length = 20, nullable = false)
	@Pattern(regexp = "^[A-Za-z ]{1,20}$")
	@Size(max = 20, message = "Country name should be less than 20 characters")
	private String country;
	@Column(name = "pincode", length = 6, nullable = false)
	@Pattern(regexp = "^[0-9]{1,6}$")
	@Size(max = 6, message = "Pincode should be less than 6 characters")
	private String pincode;

	public int getAddressId() {
		return addressId;
	}

	public void setAddressId(int addressId) {
		this.addressId = addressId;
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

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public Address(int addressId, String city, String state, String country, String pincode) {
		super();
		this.addressId = addressId;
		this.city = city;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	public Address() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + addressId;
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
		Address other = (Address) obj;
		if (addressId != other.addressId)
			return false;
		return true;
	}

}
