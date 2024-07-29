package com.autopedia.api.category;

import jakarta.persistence.*;

@Table(name = "category")
@Entity(name = "Category")
public class Category {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	private String description;

	public Category() {
	}

	public Category(CategoryDTO data) {
		this.id = data.getId();
		this.name = data.getName();
		this.description = data.getDescription();
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
