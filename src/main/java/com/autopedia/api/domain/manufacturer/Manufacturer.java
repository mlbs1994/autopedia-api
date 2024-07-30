package com.autopedia.api.domain.manufacturer;

import jakarta.persistence.*;

@Table(name = "manufacturer")
@Entity(name = "Manufacturer")
public class Manufacturer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;

	public Manufacturer() {
	}

	public Manufacturer(ManufacturerDTO data) {
		this.id = data.getId();
		this.name = data.getName();
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
