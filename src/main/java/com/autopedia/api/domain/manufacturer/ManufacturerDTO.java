package com.autopedia.api.domain.manufacturer;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class ManufacturerDTO {

	@NotNull(message = "{not.null.manufacturer.id.message}")
	@Min(value = 1, message = "{min.value.manufacturer.id.message}")
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
