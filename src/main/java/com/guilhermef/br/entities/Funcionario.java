package com.guilhermef.br.entities;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="tb_funcionarios")
public class Funcionario {
	
	@NotEmpty
	private String nome;
	
	@Email
	private String email;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long idFuncionario;
	
	@NotEmpty
	private String github;
	
	@DateTimeFormat
	@NotEmpty
	private String ultimoCheckIn;
	
	@NotEmpty
	private String cargo;

	public Funcionario() {
	}

	public Funcionario(@NotEmpty String nome, @Email String email, Long idFuncionario, @NotEmpty String github,
			@NotEmpty String ultimoCheckIn, @NotEmpty String cargo) {
		this.nome = nome;
		this.email = email;
		this.idFuncionario = idFuncionario;
		this.github = github;
		this.ultimoCheckIn = ultimoCheckIn;
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

	public String getUltimoCheckIn() {
		return ultimoCheckIn;
	}

	public void setUltimoCheckIn(String ultimoCheckIn) {
		this.ultimoCheckIn = ultimoCheckIn;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
	
	
}
