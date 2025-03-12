package br.com.phamtecnologia.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.phamtecnologia.dtos.RecuperarSenhaRequestDto;
import br.com.phamtecnologia.dtos.RecuperarSenhaResponseDto;
import br.com.phamtecnologia.entities.Usuario;
import br.com.phamtecnologia.repositories.UsuarioRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/recuperar-senha")
public class RecuperarSenhaController {
	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@PostMapping
	public ResponseEntity<RecuperarSenhaResponseDto> post(@RequestBody @Valid RecuperarSenhaRequestDto dto) {

		RecuperarSenhaResponseDto response = new RecuperarSenhaResponseDto();
		
		try {
			
			Optional<Usuario> optional = usuarioRepository.findByEmail(dto.getEmail());
			
			if (optional.isEmpty()) {
				response.setStatus(400);
				response.setMensagem("Usuário não encontrado. Verifique o e-mail informado.");
			}
			else {
				
			}
			
		} catch (Exception e) {
			response.setStatus(500);
			response.setMensagem("Falha ao recuperar senha do usuário: " + e.getMessage());
		}
		
		return ResponseEntity.status(response.getStatus())
				.body(response);
	}

}
