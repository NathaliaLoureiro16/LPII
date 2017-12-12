package br.fundatec.natflix.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fundatec.natflix.convert.EpConvert;
import br.fundatec.natflix.service.EpisodioBo;
import br.fundatec.natflix.service.SerieBo;

@Component
public class NatflixDao {
	private EntityManager em;

	@Autowired
	public NatflixDao(EntityManager em) {
		this.em = em;
	}

	@Transactional
	public SerieEntity addEattSerie(SerieEntity se) {
		return em.merge(se);
	}

	public SerieEntity getSerieByID(long id) {
		SerieEntity serie = em.find(SerieEntity.class, id);
		if (serie != null) {
			return serie;
		}
		throw new RuntimeException();
	}

	public List<SerieEntity> getSeries() {
		return em.createQuery("from SerieEntity").getResultList();
	}

	@Transactional
	public void deleteSerie(long id) {
		SerieEntity se = em.find(SerieEntity.class, id);
		if (se != null) {
			em.remove(se);
		}

	}

	@Transactional
	public EpisodioEntity addEp(EpisodioEntity epEntity) {
		return em.merge(epEntity);

	}

	public List<EpisodioEntity> getEpisodio() {
		return em.createQuery("from EpisodioEntity").getResultList();
	}

	public void deleteEpisodio(long id) {
		EpisodioEntity ep = em.find(EpisodioEntity.class, id);
		if (ep != null) {
			em.remove(ep);

		}
	}
	@Transactional
	public EpisodioEntity  attEpisodio(EpisodioEntity att) {
			return em.merge(att);
	}
	
}
