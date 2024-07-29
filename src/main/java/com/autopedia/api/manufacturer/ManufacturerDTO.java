package com.autopedia.api.manufacturer;

public class ManufacturerDTO {

	private Integer id;
	private String name;
	
	public ManufacturerDTO() {
	}

	public ManufacturerDTO(Manufacturer manufacturer) {
		this.id = manufacturer.getId();
		this.name = manufacturer.getName();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
