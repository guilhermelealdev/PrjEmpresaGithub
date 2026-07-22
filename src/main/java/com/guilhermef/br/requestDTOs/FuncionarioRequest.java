package com.guilhermef.br.requestDTOs;

import com.guilhermef.br.entities.Setor;

import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class FuncionarioRequest {
	@NotBlank
	private String nome;

	@Email
	private String email;

	private Long idFuncionario;

	@NotBlank
	private String github;

	@NotBlank
	private String cargo;

	@OneToOne
	private Setor setor;

	public FuncionarioRequest() {
	}

	public FuncionarioRequest(@NotBlank String nome, @Email String email, Long idFuncionario, @NotBlank String github,
			@NotBlank String cargo, Setor setor) {
		super();
		this.nome = nome;
		this.email = email;
		this.idFuncionario = idFuncionario;
		this.github = github;
		this.cargo = cargo;
		this.setor = setor;
	}

	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
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
