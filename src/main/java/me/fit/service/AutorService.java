package me.fit.service;

import java.util.List;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import me.fit.model.rest.client.Autor;

@Dependent
public class AutorService {

	@Inject
	private EntityManager em;
	
	@Transactional
	public List<Autor> getAllAutori(){
		return em.createNamedQuery(Autor.GET_ALL, Autor.class).getResultList();
	}
}
