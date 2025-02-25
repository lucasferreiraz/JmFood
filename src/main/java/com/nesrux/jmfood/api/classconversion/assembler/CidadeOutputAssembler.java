package com.nesrux.jmfood.api.classconversion.assembler;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.nesrux.jmfood.api.model.dto.output.cidade.CidadeOutputDto;
import com.nesrux.jmfood.domain.model.endereco.Cidade;

@Component
public class CidadeOutputAssembler {
	@Autowired
	private ModelMapper modelMapper;

	public CidadeOutputDto toModel(Cidade cidade) {
		return modelMapper.map(cidade, CidadeOutputDto.class);
	}

	public List<CidadeOutputDto> toCollectionDto(List<Cidade> cidades) {
		return cidades.stream().map(cidade -> toModel(cidade)).collect(Collectors.toList());
	}

}
