package com.guilhermef.br.responseDTOs;

import jakarta.validation.constraints.NotEmpty;




public class FuncionarioResponse {
	
	@NotEmpty
	private String nome;
	
	private Long idFuncionario;
	
	@NotEmpty
	private String github;
	
	@NotEmpty
	private String cargo;
	
	

	public FuncionarioResponse(@NotEmpty String nome, Long idFuncionario, @NotEmpty String github,
			@NotEmpty String cargo) {
		this.nome = nome;
		this.idFuncionario = idFuncionario;
		this.github = github;
		this.cargo = cargo;
	}

	public FuncionarioResponse() {
		
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Long getIdFuncionario() {
		return idFuncionario;
	}

	public void setIdFuncionario(Long idFuncionario) {
		this.idFuncionario = idFuncionario;
	}

	public String getGithub() {
		return github;
	}

	public void setGithub(String github) {
		this.github = github;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
}
