package com.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "card")
public class Card {

	@Id
	@Column(name = "id")
	private long id;

	@Column(name = "card_name", nullable = false)
	@NotBlank(message = "Card Name Should Not Be Blank")
	@Pattern(regexp = "^[A-Za-z ]{3,30}$")
	@Size(max = 30, message = "Card name should be less than 30 characters")
	private String cardName;

	@Column(name = "card_number", nullable = false, unique = true)
	@NotNull(message = "Card Number Should Not Be Null")
	private String cardNumber;

	@Column(name = "card_expiry_date", nullable = false)
	@NotNull(message = "Card Expiry Date Should Not Be Null")
	private LocalDate cardExpiry;

	@Column(name = "cvv", nullable = false)
	@Pattern(regexp = "^[0-9]{4}$")
	//@Size(max = 10, message = "Card cvv number should be 4 characters")
	//@NotNull(message = "Card Cvv Number Should Not Be Null")
	private int cvv;

	public Card() {
		super();
	}

	public Card(long id, String cardName, String cardNumber, LocalDate cardExpiry, int cvv) {
		super();
		this.id = id;
		this.cardName = cardName;
		this.cardNumber = cardNumber;
		this.cardExpiry = cardExpiry;
		this.cvv = cvv;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCardName() {
		return cardName;
	}

	public void setCardName(String cardName) {
		this.cardName = cardName;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getCardExpiry() {
		return cardExpiry;
	}

	public void setCardExpiry(LocalDate cardExpiry) {
		this.cardExpiry = cardExpiry;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	@Override
	public String toString() {
		return "Card [id=" + id + ", cardName=" + cardName + ", cardNumber=" + cardNumber + ", cardExpiry=" + cardExpiry
				+ ", cvv=" + cvv + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Card other = (Card) obj;
		if (id != other.id)
			return false;
		return true;
	}

}