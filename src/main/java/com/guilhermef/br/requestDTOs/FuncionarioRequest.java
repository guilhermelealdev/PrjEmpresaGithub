package com.guilhermef.br.requestDTOs;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;


public class FuncionarioRequest {
	@NotEmpty
	private String nome;
	
	@Email
	private String email;
	
	private Long idFuncionario;
	
	@NotEmpty
	private String github;
	
	@NotEmpty
	private String cargo;
	
	public FuncionarioRequest() {
	}



	public FuncionarioRequest(@NotEmpty String nome, @Email String email, Long idFuncionario, @NotEmpty String github,
			@NotEmpty String cargo) {
		super();
		this.nome = nome;
		this.email = email;
		this.idFuncionario = idFuncionario;
		this.github = github;
		this.cargo = cargo;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
