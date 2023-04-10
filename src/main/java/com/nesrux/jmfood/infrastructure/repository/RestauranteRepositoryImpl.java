package com.nesrux.jmfood.infrastructure.repository;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.stereotype.Repository;

import com.nesrux.jmfood.domain.model.Restaurante;
import com.nesrux.jmfood.domain.repository.CustomizedRestauranteRepository;

@Repository
public class RestauranteRepositoryImpl implements CustomizedRestauranteRepository {
	// Essa classe só vai funcionar por causa do sufixo Impl que faz o bind desse
	// método find com o método no controller
	@PersistenceContext
	private EntityManager manager;

	@Override
	public List<Restaurante> find(String nome, BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();

		CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class);
		criteria.from(Restaurante.class);//FROM Restaurante

		TypedQuery<Restaurante> query =  manager.createQuery(criteria);
		
		return query.getResultList();
		
	}
}
