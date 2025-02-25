package com.nesrux.jmfood.api.classconversion.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nesrux.jmfood.api.model.dto.output.cozinha.CozinhaOutputDto;
import com.nesrux.jmfood.domain.model.restaurante.Cozinha;

@Component
public class CozinhaOutputAssembler {

	@Autowired
	private ModelMapper modelMapper;

	public CozinhaOutputDto toModel(Cozinha cozinha) {
		return modelMapper.map(cozinha, CozinhaOutputDto.class);
	}

	public List<CozinhaOutputDto> toCollectionDto(List<Cozinha> cozinhas) {
		return cozinhas.stream().map(cozinha -> toModel(cozinha)).collect(Collectors.toList());
	}

}
