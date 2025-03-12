package br.com.phamtecnologia.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.phamtecnologia.dtos.AutenticarRequestDto;
import br.com.phamtecnologia.dtos.AutenticarResponseDto;
import br.com.phamtecnologia.entities.Usuario;
import br.com.phamtecnologia.repositories.UsuarioRepository;
import br.com.phamtecnologia.services.JwtTokenService;
import br.com.phamtecnologia.services.MD5Service;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/autenticar")
public class AutenticarController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@Autowired
	MD5Service md5Service;
	
	@Autowired
	JwtTokenService jwtTokenService;

	@PostMapping
	public ResponseEntity<AutenticarResponseDto> post(@RequestBody @Valid AutenticarRequestDto dto) {
		
		AutenticarResponseDto response = new AutenticarResponseDto();
		
		try {
			
			Optional<Usuario> optional = usuarioRepository.findByEmailAndSenha(dto.getEmail(), md5Service.encrypt(dto.getSenha()));
			
			if (optional.isEmpty()) {
				response.setStatus(401);
				response.setMensagem("Acesso negado. Usuário não encontrado.");
			}
			else {
				
				Usuario usuario = optional.get();
				
				response.setStatus(200);
				response.setMensagem("Usuário autenticado com sucesso.");
				response.setIdUsuario(usuario.getIdUsuario());
				response.setNome(usuario.getNome());
				response.setEmail(usuario.getEmail());
				response.setAccessToken(jwtTokenService.getToken(usuario.getEmail()));
				
			}
			
		} catch (Exception e) {

			response.setStatus(500);
			response.setMensagem("Falha ao autenticar o usuário: " + e.getMessage());
		}

		
		return ResponseEntity.status(response.getStatus())
				.body(response);
	}
}
