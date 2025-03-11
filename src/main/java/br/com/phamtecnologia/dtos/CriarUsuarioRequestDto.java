package br.com.phamtecnologia.dtos;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CriarUsuarioRequestDto {

	@Size(min = 8, max = 150, message = "Nome deve ter de 8 a 150 caracteres.")
	@NotBlank(message = "Preencha o nome.")
	private String nome;
	
	@Email(message = "Preencha um e-mail válido.")
	@NotBlank(message = "Preencha o e-mail.")
	private String email;
	
	@Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
		    message = "A senha deve ter no mínimo 8 caracteres, incluindo uma letra maiúscula, uma minúscula, um número e um caractere especial.")
	@NotBlank(message = "Preencha a senha.")
	private String senha;
}
