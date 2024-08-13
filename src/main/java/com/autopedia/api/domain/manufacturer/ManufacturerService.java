package com.autopedia.api.domain.manufacturer;

import org.springframework.stereotype.Service;

import com.autopedia.api.domain.CrudService;

@Service
public class ManufacturerService extends CrudService<Manufacturer, Integer>{

	public ManufacturerService(ManufacturerRepository repo) {
		super(repo);
	}

}
