package com.autopedia.api.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.autopedia.api.domain.DTO;
import com.autopedia.api.domain.vehicle.Vehicle;
import com.autopedia.api.domain.vehicle.VehicleDTO;
import com.autopedia.api.domain.vehicle.VehicleRepository;
import com.autopedia.api.domain.vehicle.VehicleService;
import com.autopedia.api.domain.vehicle.VehicleSummaryDTO;
import com.autopedia.api.domain.vehicle.VehicleUpdateDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {
	
	@Autowired
	VehicleService vehicleService;
	
	@Autowired
	VehicleRepository repo;
	
	@GetMapping("/{id}")
	public ResponseEntity<VehicleDTO> detail(@PathVariable Integer id) {
		Vehicle vehicle = repo.getReferenceById(id);
		return ResponseEntity.ok(new VehicleDTO(vehicle));
	}
	
	@GetMapping("summary")
	public ResponseEntity<Page<DTO>> summaryList(@PageableDefault(size = 10, sort="model") Pageable pagination) {
		Page<DTO> vehiclesSummarized = vehicleService.findAll(pagination, VehicleSummaryDTO::new);
		return ResponseEntity.ok(vehiclesSummarized);
	}
	
	@GetMapping("list")
	public ResponseEntity<Page<DTO>> list(@PageableDefault(size = 10, sort="model") Pageable pagination) {
		Page<DTO> vehiclesList = vehicleService.findAll(pagination, VehicleDTO::new);
		return ResponseEntity.ok(vehiclesList);		
	}
	
	@PostMapping
	@Transactional
	public ResponseEntity<VehicleDTO> add(@RequestBody @Valid VehicleDTO vehicleData, UriComponentsBuilder uriComponentBuilder) {
		Vehicle vehicle = new Vehicle(vehicleData);
		vehicleService.save(vehicle);
		
		URI uri = uriComponentBuilder.path("/vehicles/{id}").buildAndExpand(vehicle.getId()).toUri();
		
		return ResponseEntity.created(uri).body(new VehicleDTO(vehicle));
	}
	
	@PutMapping
	@Transactional
	public ResponseEntity<VehicleDTO> update(@RequestBody @Valid VehicleUpdateDTO vehicleData) {
		Vehicle vehicle = vehicleService.findById(vehicleData.getId());
		vehicle.updateVehicle(vehicleData);
		
		return ResponseEntity.ok(new VehicleDTO(vehicle));
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		vehicleService.deleteById(id);
		
		return ResponseEntity.noContent().build();
	}
	
	
	
}
