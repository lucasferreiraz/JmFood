package com.nesrux.jmfood.api.model.dto.input.restaurante;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CozinhaIdInputDto {
	@NotNull
	private Long id;
}
