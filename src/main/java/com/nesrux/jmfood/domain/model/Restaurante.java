package com.nesrux.jmfood.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurante {

	// Essa annotation define uma geração de valor, e a "estratégia"
	// esta setada como identity, que significa que ele passa a
	// resposabilidade para o provedor de persistencia, que nesse
	// caso é o mysql

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false) //Por padrão é true
	private BigDecimal taxaFrete;

	// Vai criar uma coluna na tabela restaurante com o nome Cozinha_ID
	// Essa coluna vai ser uma FK da tabela Cozinha
	@ManyToOne
	// Se eu quiser renomear essa coluna é necessario
	// utilizar a anotação joinColumn que esencialmente faz o mesmo
	// Com a opção de renomear a coluna
	@JoinColumn(name = "cozinha_id", nullable = false)
	private Cozinha cozinha;

}
