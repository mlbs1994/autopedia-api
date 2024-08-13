package com.autopedia.api.domain.vehicle;

import com.autopedia.api.domain.DTO;

public class VehicleSummaryDTO implements DTO {

	private String model;
	private String manufacturer;

	public VehicleSummaryDTO() {
	}
	
	public VehicleSummaryDTO(Vehicle vehicle) {
		this.model = vehicle.getModel();
		this.manufacturer = vehicle.getManufacturer().getName();
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

}
