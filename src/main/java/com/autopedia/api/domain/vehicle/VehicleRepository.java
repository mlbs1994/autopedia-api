package com.autopedia.api.domain.vehicle;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("vehicleRepo")
public interface VehicleRepository extends JpaRepository<Vehicle, Integer>{
}
