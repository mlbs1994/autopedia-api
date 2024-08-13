package com.autopedia.api.domain.vehicle;

import com.autopedia.api.domain.CrudService;
import org.springframework.stereotype.Service;

@Service
public class VehicleService extends CrudService<Vehicle, Integer>{
	
	public VehicleService(VehicleRepository repo) {
		super(repo);
	}

}
