package com.guilhermef.br.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.guilhermef.br.entities.Funcionario;
import com.guilhermef.br.requestDTOs.FuncionarioRequest;
import com.guilhermef.br.responseDTOs.FuncionarioResponse;
import com.guilhermef.br.services.FuncionarioService;

@RestController
@RequestMapping("/funcionarios")
public class FuncionarioController {
	private final FuncionarioService funcionarioService;

	@Autowired
	public FuncionarioController(FuncionarioService funcionarioService) {
		this.funcionarioService = funcionarioService;
	}

	@PostMapping
	public FuncionarioResponse salvar(@RequestBody FuncionarioRequest funcionario) {
		return funcionarioService.salvar(funcionario);
	}

	@GetMapping("/{id}")
	public FuncionarioResponse getById(Long id) {
		return funcionarioService.getById(id);
	}

	@GetMapping
	public List<FuncionarioResponse> listar() {
		return funcionarioService.listar();
	}

	@DeleteMapping("/{id}")
	public void deletar(Long id) {
		funcionarioService.deletar(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Funcionario> atualizar(Long id, @RequestBody FuncionarioRequest funcionario) {
		Funcionario atualizado = funcionarioService.atualizar(id, funcionario);

		if (atualizado != null) {
			return ResponseEntity.ok(atualizado);
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}/check-in")
	public ResponseEntity<Funcionario> checkIn(Long id) {
		Funcionario atualizado = funcionarioService.checkIn(id);

		if (atualizado != null) {
			return ResponseEntity.ok(atualizado);
		}

		return ResponseEntity.notFound().build();
	}

}
