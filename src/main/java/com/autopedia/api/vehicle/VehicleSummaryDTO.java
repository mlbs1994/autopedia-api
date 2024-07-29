package com.autopedia.api.vehicle;

public class VehicleSummaryDTO {

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
