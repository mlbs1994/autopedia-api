package com.autopedia.api.domain.vehicle;

import com.autopedia.api.domain.vehicle.*;
import com.autopedia.api.domain.CrudService;
import org.springframework.stereotype.Service;

@Service
public class VehicleService extends CrudService<Vehicle, Long, VehicleRepository<Vehicle, Integer>> {

    public CarService(CarRepository repository) {
        super(repository);
    }

    // Métodos específicos para CarService podem ser adicionados aqui
}
