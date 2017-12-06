package br.fundatec.natflix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fundatec.natflix.convert.NatflixConvert;
import br.fundatec.natflix.dao.NatflixDao;
import br.fundatec.natflix.dao.SerieEntity;
import br.fundatec.natflix.web.SerieBo;

@Component
public class NatflixService {
	private NatflixDao nDao;
	
	@Autowired
	public NatflixService(NatflixDao nDao){
		this.nDao = nDao;
	}

	public List<SerieBo> pegaSeries() {
	List<SerieBo> seriesBo = NatflixConvert.convertListEntitytoBo(nDao.getSeries())
		return seriesBo;
	}
	
	public SerieBo addSerie(SerieBo seBo) {
		SerieEntity se = NatflixConvert.convertBotoEntity(seBo);
		se = nDao.addSerie(se);
		seBo = NatflixConvert.convertEntitytoBo(se);
		return seBo;
		
	}
//acrecentaserie

	//deletaseries
}
