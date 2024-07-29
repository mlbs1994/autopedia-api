package com.autopedia.api.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.autopedia.api.vehicle.Vehicle;
import com.autopedia.api.vehicle.VehicleDTO;
import com.autopedia.api.vehicle.VehicleDeleteDTO;
import com.autopedia.api.vehicle.VehicleRepository;
import com.autopedia.api.vehicle.VehicleSummaryDTO;
import com.autopedia.api.vehicle.VehicleUpdateDTO;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@GetMapping
	public VehicleDTO get(@RequestParam Integer id) {
		Vehicle vehicle = vehicleRepository.findById(id).get();
		return new VehicleDTO(vehicle);
	}
	
	@GetMapping("summary")
	public List<VehicleSummaryDTO> summaryList() {
		return vehicleRepository.findAll().stream().map(VehicleSummaryDTO::new).collect(Collectors.toList());
	}
	
	@GetMapping("list")
	public List<VehicleDTO> list() {
		return vehicleRepository.findAll().stream().map(VehicleDTO::new).collect(Collectors.toList());
	}
	
	@PostMapping
	@Transactional
	public void add(@RequestBody VehicleDTO vehicleData) {
		vehicleRepository.save(new Vehicle(vehicleData));
	}
	
	@PutMapping
	@Transactional
	public void update(@RequestBody VehicleUpdateDTO vehicleData) {
		Vehicle vehicle = vehicleRepository.getReferenceById(vehicleData.getId());
		vehicle.updateVehicle(vehicleData);
	}
	
	@DeleteMapping
	@Transactional
	public void delete(@RequestBody VehicleDeleteDTO vehicleData) {
		vehicleRepository.deleteById(vehicleData.getId());
	}
	
	
	
}
