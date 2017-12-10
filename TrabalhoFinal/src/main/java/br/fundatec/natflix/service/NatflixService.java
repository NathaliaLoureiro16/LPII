package br.fundatec.natflix.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fundatec.natflix.convert.EpConvert;
import br.fundatec.natflix.convert.SerieConvert;
import br.fundatec.natflix.dao.NatflixDao;
import br.fundatec.natflix.dao.SerieEntity;
import br.fundatec.natflix.web.SerieDTO;

@Component
public class NatflixService {
	private NatflixDao nDao;

	@Autowired
	public NatflixService(NatflixDao nDao) {
		this.nDao = nDao;
	}

	public List<SerieBo> pegaSeries() {
		List<SerieBo> seriesBo = SerieConvert.convertListEntitytoBo(nDao.getSeries());
		return seriesBo;
	}

	public SerieBo addSerie(SerieBo bo) {
		SerieEntity se = SerieConvert.convertBotoEntity(bo);
		se = nDao.addSerie(se);
		bo = SerieConvert.convertEntitytoBo(se);
		return bo;

	}

	public void deletaSerie(long id) {
		nDao.deleteSerie(id);

	}

	public SerieBo getSerieByID(Long id) {
		SerieBo serieBo = SerieConvert.convertEntitytoBo(nDao.getSerieByID(id));
		return serieBo;

	}
//========================================================================================================\\
	public EpisodioBo addEp(long id, EpisodioBo epBo) {
		SerieBo serieBo = getSerieByID(id);
		epBo = EpConvert.convertEntitytoBo(nDao.addEp(EpConvert.convertBotoEntity(epBo)));
		serieBo.getEpisodios().add(epBo);
		addSerie(serieBo);
		return epBo;
	}

}
