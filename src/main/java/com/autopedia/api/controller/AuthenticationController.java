package com.autopedia.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.autopedia.api.domain.user.AuthenticationDTO;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/login")
public class AuthenticationController {
	
	@Autowired
	private AuthenticationManager manager;
	
	@PostMapping
	public ResponseEntity<Void> doLogin(@RequestBody @Valid AuthenticationDTO credentials) {
		Authentication token = new UsernamePasswordAuthenticationToken(credentials.getLogin(), credentials.getPassword());
		manager.authenticate(token);
		
		return ResponseEntity.ok().build();
	}

}
