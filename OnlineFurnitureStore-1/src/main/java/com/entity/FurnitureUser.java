package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "FurnitureUser")
@Inheritance(strategy = InheritanceType.JOINED)
public class FurnitureUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "uid")
	private int uId;

	@Column(name = "username", nullable = false)
	@Pattern(regexp = "^[a-zA-Z0-9.-_]{1,20}$", message = "Name must contain alphabets and  may contain (./-/_)  and length from 1 to 20 characters")
	private String username;

	@Column(name = "password", nullable = false)
	@Pattern(regexp = "^[a-zA-Z0-9.-_]{1,20}$", message = "Password must contain alphabets and  may contain (./-/_)  and length from 1 to 20 characters")
	private String password;

	@Column(name = "role", nullable = false)
	@Pattern(regexp = "^[A-Za-z ]{1,20}$", message = "Role must only be alphabets and whitespaces from 1 to 20 characters")
	private String role;

	public FurnitureUser() {
		super();
	}

	public FurnitureUser(int uId, String password, String role, String username) {
		super();
		this.uId = uId;
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public int getUId() {
		return uId;
	}

	public void setUId(int uId) {
		this.uId = uId;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return "User [uId=" + uId + ", password=" + password + ", role=" + role + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + uId;
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
		FurnitureUser other = (FurnitureUser) obj;
		if (uId != other.uId)
			return false;
		return true;
	}

}
