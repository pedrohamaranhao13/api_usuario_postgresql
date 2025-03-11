package br.com.phamtecnologia.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RecuperarSenhaRequestDto {

	@Email(message = "Preencha um e-mail válido.")
	@NotBlank(message = "Preencha o e-mail.")
	private String email;
}
