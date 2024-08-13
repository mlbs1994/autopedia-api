package com.autopedia.api.domain.vehicle;

import com.autopedia.api.domain.DTO;
import com.autopedia.api.domain.category.CategoryDTO;
import com.autopedia.api.domain.manufacturer.ManufacturerDTO;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

public class VehicleDTO implements DTO{

	private Integer id;

	@NotBlank(message = "{not.blank.message}")
	private String model;

	@NotNull(message = "{not.null.year.message}")
	private Integer year;

	private String motor;
	private String transmission;

	@NotNull(message = "{not.null.price.message}")
	private double price;

	private String description;
	private String image;

	@NotNull(message = "{not.null.category.message}")
	@Valid
	private CategoryDTO category;

	@NotNull(message = "{not.null.manufacturer.message}")
	@Valid
	private ManufacturerDTO manufacturer;

	public VehicleDTO() {
	}

	public VehicleDTO(Vehicle vehicle) {
		this.id = vehicle.getId();
		this.model = vehicle.getModel();
		this.year = vehicle.getYear();
		this.motor = vehicle.getMotor();
		this.transmission = vehicle.getTransmission();
		this.price = vehicle.getPrice();
		this.description = vehicle.getDescription();
		this.image = vehicle.getImage();
		this.category = new CategoryDTO(vehicle.getCategory());
		this.manufacturer = new ManufacturerDTO(vehicle.getManufacturer());
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
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

	public CategoryDTO getCategory() {
		return category;
	}

	public void setCategory(CategoryDTO category) {
		this.category = category;
	}

	public ManufacturerDTO getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(ManufacturerDTO manufacturer) {
		this.manufacturer = manufacturer;
	}

}
