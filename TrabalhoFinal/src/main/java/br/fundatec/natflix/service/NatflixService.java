package br.fundatec.natflix.service;


import java.util.ArrayList;
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
		bo.setEpisodios(new ArrayList<EpisodioBo>());
		SerieEntity se = SerieConvert.convertBotoEntity(bo);
		se = nDao.addEattSerie(se);
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
		
		try {
			serieBo.getEpisodios().add(epBo);
			nDao.addEattSerie(SerieConvert.convertBotoEntity(serieBo));
			return epBo;
		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException();
		}
		
	}

	public List<EpisodioBo> pegaEpisodio() {
		List<EpisodioBo> episodioBo = EpConvert.convertListEpisodioEntitytoBo(nDao.getEpisodio());
		return episodioBo;
	}

	public void deletaEpisodio(long id) {
		nDao.deleteEpisodio(id);
		
	}
	public EpisodioBo attEpisodio(long id,EpisodioBo epBo) {
		return EpConvert.convertEntitytoBo(nDao.attEpisodio(EpConvert.convertBotoEntity(epBo)));
	}

}
