package br.com.phamtecnologia.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/autenticar")
public class AutenticarController {

	@PostMapping
	public void post() {
		// TODO
	}
}
