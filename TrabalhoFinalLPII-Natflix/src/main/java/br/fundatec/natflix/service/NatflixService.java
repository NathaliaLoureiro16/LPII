package br.fundatec.natflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fundatec.natflix.convert.NatflixConvert;
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
		List<SerieBo> seriesBo = NatflixConvert.convertListEntitytoBo(nDao.getSeries());
		return seriesBo;
	}

	public SerieBo addSerie(SerieBo bo) {
		SerieEntity se = NatflixConvert.convertBotoEntity(bo);
		se = nDao.addSerie(se);
		bo = NatflixConvert.convertEntitytoBo(se);
		return bo;

	}

	public void deletaSerie(Long id) {
		nDao.deleteSerie(id);

	}

	public SerieBo getSerieByID(Long id) {
		SerieBo serieBo = NatflixConvert.convertEntitytoBo(nDao.getSerieByID(id));
		return serieBo;

	}

}
