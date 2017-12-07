package br.fundatec.natflix.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NatflixDao {
	private EntityManager em;

	@Autowired
	public NatflixDao(EntityManager em) {
		this.em = em;
	}

	@Transactional
	public SerieEntity addSerie(SerieEntity se) {
		return em.merge(se);
	}

	public SerieEntity getSerieByID(long id) {
		SerieEntity serie = new SerieEntity();
		serie = em.find(SerieEntity.class, id);
		return serie;
	}
	public List<SerieEntity> getSeries(){
		return em.createQuery("from SerieEntity").getResultList();
	}
	
	@Transactional
	public void deleteSerie(long id) {
		SerieEntity se = em.find(SerieEntity.class, id);
		if(se != null) {
			em.remove(se);
		}
		

	}
}
