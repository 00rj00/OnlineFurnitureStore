package com.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Furniture")
public class Furniture {

	@Id
	@Column(name = "furnitureid")
	private long furnitureId;

	@Column(name = "FurnitureName", nullable = false, length = 50)
	@Pattern(regexp = "^[A-Za-z ]{1,20}$")
	@Size(max = 30, message = "Furntiure Name should be less than or equal to 50 characters")
	@NotBlank(message = "Furntiure Name should not be blank")
	private String furnitureName;

	@Column(name = "FurnitureColor", nullable = false, length = 50)
	@Pattern(regexp = "^[A-Za-z ]{1,50}$")
	@Size(max = 50, message = "FurnitureColor should be less than or equal to 50 characters")
	@NotBlank(message = "FurnitureColor should not be blank")
	private String furnitureColor;

	@Column(name = "FurnitureModel", nullable = false, length = 50)
	@Pattern(regexp = "^[A-Za-z ]{1,50}$")
	@Size(max = 50, message = "FurnitureModel should be less than or equal to 50 characters")
	@NotBlank(message = "FurnitureModel should not be blank")
	private String furnitureModel;

	@Column(name = "price", nullable = false)
	@DecimalMin(value = "100.0", message = "Price must be a number at least 100")
	private double price;

	public long getFurnitureId() {
		return furnitureId;
	}

	public void setFurnitureId(long furnitureId) {
		this.furnitureId = furnitureId;
	}

	public String getFurnitureName() {
		return furnitureName;
	}

	public void setFurnitureName(String furnitureName) {
		this.furnitureName = furnitureName;
	}

	public String getFurnitureColor() {
		return furnitureColor;
	}

	public void setFurnitureColor(String furnitureColor) {
		this.furnitureColor = furnitureColor;
	}

	public String getFurnitureModel() {
		return furnitureModel;
	}

	public void setFurnitureModel(String furnitureModel) {
		this.furnitureModel = furnitureModel;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Furniture(long furnitureId, String furnitureName, String furnitureColor, String furnitureModel,
			double price) {
		super();
		this.furnitureId = furnitureId;
		this.furnitureName = furnitureName;
		this.furnitureColor = furnitureColor;
		this.furnitureModel = furnitureModel;
		this.price = price;
	}

	public Furniture() {
		super();
	}

	@Override
	public String toString() {
		return "Furniture [furnitureId=" + furnitureId + ", furnitureName=" + furnitureName + ", furnitureColor="
				+ furnitureColor + ", furnitureModel=" + furnitureModel + ", price=" + price + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (furnitureId ^ (furnitureId >>> 32));
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
		Furniture other = (Furniture) obj;
		if (furnitureId != other.furnitureId)
			return false;
		return true;
	}

}
