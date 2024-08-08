package com.autopedia.api.infra.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

@Service
public class TokenService {
	
	@Value("${autopedia.api.token.secret}")
	private String secret;
	
	public String generateToken(String username) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(secret);
			return JWT.create()
					.withIssuer("Autopedia API")
					.withSubject(username)
					.withExpiresAt(expirationDate())
					.sign(algorithm);
		} catch (JWTCreationException exception) {
			throw new RuntimeException("Error generating JWT Token ", exception);
		}
	}

	private Instant expirationDate() {
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}

}
