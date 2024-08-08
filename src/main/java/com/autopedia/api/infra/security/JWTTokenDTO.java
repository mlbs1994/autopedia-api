package com.autopedia.api.infra.security;

public class JWTTokenDTO {

	private String token;
	
	public JWTTokenDTO(String tokenJWT) {
		token = tokenJWT;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
