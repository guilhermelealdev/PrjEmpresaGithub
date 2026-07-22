package com.guilhermef.br.services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilhermef.br.entities.Funcionario;
import com.guilhermef.br.repositories.FuncionarioRepository;
import com.guilhermef.br.requestDTOs.FuncionarioRequest;
import com.guilhermef.br.responseDTOs.FuncionarioResponse;
import com.guilhermef.br.utils.DateUtil;

@Service
public class FuncionarioService {
	private final FuncionarioRepository funcionarioRepository;

	@Autowired
	public FuncionarioService(FuncionarioRepository funcionarioRepository) {
		this.funcionarioRepository = funcionarioRepository;
	}

	public FuncionarioResponse salvar(FuncionarioRequest dto) {

		Funcionario funcionario = new Funcionario();
		funcionario.setNome(dto.getNome());
		funcionario.setEmail(dto.getEmail());
		funcionario.setGithub(dto.getGithub());
		funcionario.setCargo(dto.getCargo());
		funcionario.setSetor(dto.getSetor());

		Funcionario salvo = funcionarioRepository.save(funcionario);

		return new FuncionarioResponse(salvo.getNome(), salvo.getIdFuncionario(), salvo.getGithub(), salvo.getCargo(),
				dto.getSetor());
	}

	public void deletar(Long id) {
		funcionarioRepository.deleteById(id);
	}

	public FuncionarioResponse getById(Long id) {
		Funcionario funcionario = funcionarioRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Funcionário não encontrado"));

		return new FuncionarioResponse(funcionario.getNome(), funcionario.getIdFuncionario(), funcionario.getGithub(),
				funcionario.getCargo(), funcionario.getSetor());

	}

	public List<FuncionarioResponse> listar() {
		return funcionarioRepository.findAll().stream()
				.map(funcionario -> new FuncionarioResponse(funcionario.getNome(), funcionario.getIdFuncionario(),
						funcionario.getGithub(), funcionario.getCargo(), funcionario.getSetor()))
				.collect(Collectors.toList());
	}

	public Funcionario atualizar(Long id, FuncionarioRequest funcionarioAtualizado) {
		Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);

		if (funcionarioOptional.isPresent()) {
			Funcionario funcionario = funcionarioOptional.get();
			funcionario.setNome(funcionarioAtualizado.getNome());
			funcionario.setEmail(funcionarioAtualizado.getEmail());
			funcionario.setGithub(funcionarioAtualizado.getGithub());
			funcionario.setCargo(funcionarioAtualizado.getCargo());
			funcionario.setSetor(funcionarioAtualizado.getSetor());

			return funcionarioRepository.save(funcionario);
		}
		return null;

	}

	public Funcionario checkIn(Long id) {
		Optional<Funcionario> funcionarioOptional = funcionarioRepository.findById(id);

		if (funcionarioOptional.isPresent()) {
			Funcionario funcionario = funcionarioOptional.get();
			funcionario.setUltimoCheckIn(new DateUtil().formatLocalTimeToDatabaseStyle(LocalDateTime.now()));

			return funcionarioRepository.save(funcionario);
		}
		return null;

	}

}
