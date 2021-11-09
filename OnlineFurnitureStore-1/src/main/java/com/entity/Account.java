package com.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name = "Acccount")
public class Account {
	@Id
	private int accountid;
	@Pattern(regexp = "^[0-9]{1,14}$", message = "The account number must be a number and must have 14 number")
	private String accountNo;
	@NotBlank(message = "Account balance should not be blank")
	private String accountBalance;

	public int getAccountid() {
		return accountid;
	}

	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public String getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(String accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Account() {
		super();
	}

	public Account(int accountid, String accountNo, String accountBalance) {
		super();
		this.accountid = accountid;
		this.accountNo = accountNo;
		this.accountBalance = accountBalance;
	}

	@Override
	public String toString() {
		return "Account [accountid=" + accountid + ", accountNo=" + accountNo + ", accountBalance=" + accountBalance
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + accountid;
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
		Account other = (Account) obj;
		if (accountid != other.accountid)
			return false;
		return true;
	}

}
