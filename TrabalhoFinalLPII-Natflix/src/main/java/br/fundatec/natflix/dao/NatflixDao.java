package br.fundatec.natflix.dao;


import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;

public class NatflixDao {
	private EntityManager em;

	@Autowired
	public NatflixDao(EntityManager em) {
		this.em = em;
	}
	@Transactional
	public void bla(SerieEntity se) {
		em.merge(se);
	}
}

