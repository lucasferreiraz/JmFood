package com.nesrux.jmfood.jpa;

import java.util.List;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;

import com.nesrux.jmfood.JmFoodApiApplication;
import com.nesrux.jmfood.domain.model.Cozinha;

public class ConsultaCozinhaMain {
	public static void main(String[] args) {
		ApplicationContext app = new SpringApplicationBuilder(JmFoodApiApplication.class).web(WebApplicationType.NONE)
				.run(args);

		CadastroCozinha cadastroCozinha = app.getBean(CadastroCozinha.class);

		List<Cozinha> cozinhas = cadastroCozinha.listar();
		
		for(Cozinha cozinha: cozinhas) {
			System.out.println(cozinha.getNome());
		}
	}

}
