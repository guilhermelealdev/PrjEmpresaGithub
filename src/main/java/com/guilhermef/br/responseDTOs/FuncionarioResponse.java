package com.guilhermef.br.responseDTOs;

import com.guilhermef.br.entities.Setor;

import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotBlank;

public class FuncionarioResponse {

	@NotBlank
	private String nome;

	private Long idFuncionario;

	@NotBlank
	private String github;

	@NotBlank
	private String cargo;

	@OneToOne
	private Setor setor;

	public FuncionarioResponse(@NotBlank String nome, Long idFuncionario, @NotBlank String github,
			@NotBlank String cargo, Setor setor) {
		this.nome = nome;
		this.idFuncionario = idFuncionario;
		this.github = github;
		this.cargo = cargo;
		this.setor = setor;
	}

	public FuncionarioResponse() {

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
