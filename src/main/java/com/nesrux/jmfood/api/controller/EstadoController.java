package com.nesrux.jmfood.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nesrux.jmfood.api.classconversion.assembler.EstadoOutputAssembler;
import com.nesrux.jmfood.api.classconversion.dissasembler.EstadoInputDisassembler;
import com.nesrux.jmfood.api.model.dto.input.estado.EstadoInputDto;
import com.nesrux.jmfood.api.model.dto.output.estado.EstadoOutputDto;
import com.nesrux.jmfood.domain.model.endereco.Estado;
import com.nesrux.jmfood.domain.service.CadastroEstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private CadastroEstadoService estadoService;

	@Autowired
	private EstadoInputDisassembler inputDisassembler;

	@Autowired
	private EstadoOutputAssembler outputAssembler;

	@GetMapping
	public List<EstadoOutputDto> listar() {
		return outputAssembler.toCollectionDto(estadoService.acharTodos());
	}

	@GetMapping("/{estadoId}")
	public EstadoOutputDto buscar(@PathVariable Long estadoId) {
		return outputAssembler.toModel(estadoService.acharOuFalhar(estadoId));
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public EstadoOutputDto adicionar(@RequestBody @Valid EstadoInputDto estadoDto) {
		Estado estado = inputDisassembler.toDomainObject(estadoDto);
		estadoService.salvar(estado);
		
		EstadoOutputDto outputDto = outputAssembler.toModel(estado);
		
		return outputDto;

	}

	@PutMapping("{estadoId}")
	public Estado atualizar(@PathVariable Long estadoId, @RequestBody @Valid EstadoInputDto estado) {
		Estado estadoAtual = estadoService.acharOuFalhar(estadoId);

		//BeanUtils.copyProperties(estado, estadoAtual, "id");
		inputDisassembler.copyTodomainObject(estado, estadoAtual);

		Estado estadoSalvo = estadoService.salvar(estadoAtual);

		return estadoSalvo;

	}

	@DeleteMapping("{estadoId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deletar(@PathVariable Long estadoId) {
		estadoService.excluir(estadoId);
	}

}
