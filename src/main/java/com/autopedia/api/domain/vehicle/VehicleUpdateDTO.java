package com.autopedia.api.domain.vehicle;

import com.autopedia.api.domain.DTO;

import jakarta.validation.constraints.NotNull;

public class VehicleUpdateDTO implements DTO {
	
	@NotNull(message = "{not.null.vehicle.id.message}")
	private Integer id;
	
	private String model;
	private Double price;
	private String description;
	private String image;

	public VehicleUpdateDTO() {
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

}
