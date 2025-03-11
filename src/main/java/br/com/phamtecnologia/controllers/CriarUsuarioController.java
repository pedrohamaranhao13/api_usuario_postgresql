package br.com.phamtecnologia.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/criar-usuario")
public class CriarUsuarioController {
	
	@PostMapping
	public void post() {
		// TODO
	}

}
