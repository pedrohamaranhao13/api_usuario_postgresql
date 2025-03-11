package br.com.phamtecnologia.dtos;

import lombok.Data;

@Data
public class CriarUsuarioResponseDto {

	private Integer status;
	private String mensagem;
	private Integer idUsuario;
	private String nome;
	private String email;
}
