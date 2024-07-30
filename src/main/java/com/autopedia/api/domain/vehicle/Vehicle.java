package com.autopedia.api.domain.vehicle;

import jakarta.persistence.*;

import com.autopedia.api.domain.category.Category;
import com.autopedia.api.domain.manufacturer.Manufacturer;

@Table(name = "vehicle")
@Entity(name = "Vehicle")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String model;
	private Integer year;
	private String motor;
	private String transmission;
	private Double price;
	private String description;
	private String image;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "manufacturer_id", nullable = false)
	private Manufacturer manufacturer;

	public Vehicle() {
	}

	public Vehicle(VehicleDTO data) {
		this.model = data.getModel();
		this.year = data.getYear();
		this.motor = data.getMotor();
		this.transmission = data.getTransmission();
		this.price = data.getPrice();
		this.description = data.getDescription();
		this.image = data.getImage();
		this.category = new Category(data.getCategory());
		this.manufacturer = new Manufacturer(data.getManufacturer());
	}
	
	public void updateVehicle(VehicleUpdateDTO data) {
		if (data.getModel() != null)
			this.model = data.getModel();
		if (data.getPrice() != null)
			this.price = data.getPrice();
		if (data.getDescription() != null)
			this.description = data.getDescription();
		if (data.getImage() != null)
			this.image = data.getImage();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public String getTransmission() {
		return transmission;
	}

	public void setTransmission(String transmission) {
		this.transmission = transmission;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

}
