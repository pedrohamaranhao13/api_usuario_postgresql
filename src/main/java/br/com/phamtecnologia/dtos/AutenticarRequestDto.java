package br.com.phamtecnologia.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AutenticarRequestDto {
	
	
	@Email(message = "Preencha um e-mail válido.")
	@NotBlank(message = "Preencha o e-mail.")
	private String email;
	
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
		    message = "A senha deve ter no mínimo 8 caracteres, incluindo uma letra maiúscula, uma minúscula, um número e um caractere especial.")
	@NotBlank(message = "Preencha a senha.")
	private String senha;

}
