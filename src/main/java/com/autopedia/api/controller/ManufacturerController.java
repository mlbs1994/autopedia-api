package com.autopedia.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autopedia.api.domain.DTO;
import com.autopedia.api.domain.manufacturer.ManufacturerDTO;
import com.autopedia.api.domain.manufacturer.ManufacturerService;

@RestController
@RequestMapping("/manufacturers")
public class ManufacturerController {
	
	@Autowired
	ManufacturerService manufacturerService;

	@GetMapping("list")
	public ResponseEntity<Page<DTO>> list(@PageableDefault(size = 10, sort="name") Pageable pagination){
		Page<DTO> manufacturersList = manufacturerService.findAll(pagination, ManufacturerDTO::new);
		return ResponseEntity.ok(manufacturersList);	
	}
	
}
