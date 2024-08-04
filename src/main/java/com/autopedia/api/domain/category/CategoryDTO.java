package com.autopedia.api.domain.category;

import jakarta.validation.constraints.*;

public class CategoryDTO {

	@NotNull(message = "{not.null.category.id.message}")
	@Min(value = 1, message = "{min.value.category.id.message}")
	private Integer id;

	private String name;

	private String description;

	public CategoryDTO() {
	}

	public CategoryDTO(Category category) {
		this.id = category.getId();
		this.name = category.getName();
		this.description = category.getDescription();
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}
