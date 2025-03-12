package br.com.phamtecnologia.services;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtTokenService {

	
	@Value("${jwt.secretkey}")
	String jwtSecretKey;
	
	public String getToken(String emailUsuario) {
		
		return Jwts.builder()
				.setSubject(emailUsuario)
				.setIssuedAt(new Date())
				.signWith(SignatureAlgorithm.HS256, jwtSecretKey)
				.compact();
	}
	
	
}
