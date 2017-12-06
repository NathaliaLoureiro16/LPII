package br.fundatec.natflix.convert;

import java.util.ArrayList;
import java.util.List;

import br.fundatec.natflix.dao.SerieEntity;
import br.fundatec.natflix.web.SerieBo;

public class NatflixConvert {

	public static List<SerieBo> convertListEntitytoBo(List<SerieEntity> entitys) {
		List<SerieBo> bos = new ArrayList<>();
		for (SerieEntity serieEntity : entitys) {
			SerieBo bo = new SerieBo();
			bo.setId(serieEntity.getId());
			bo.setTitulo(serieEntity.getTitulo());
			bo.setAnoLancamento(serieEntity.getAnoLancamento());
			bo.setDescricao(serieEntity.getDescricao());
			bo.setAtores(serieEntity.getAtores());
			bo.setCriacao(serieEntity.getCriacao());
			bo.setGenero(serieEntity.getGenero());
			bo.setTemporada(serieEntity.getTemporada());
			bos.add(bo);
		}
		return bos;
		

	}

	public static SerieEntity convertBotoEntity(SerieBo seBo) {
		// TODO Auto-generated method stub
		return null;
	}

	public static SerieBo convertEntitytoBo(SerieEntity se) {
		SerieBo bo = new SerieBo();
		bo.setId(bo.getId());
		bo.setTitulo(bo.getTitulo());
		bo.setAnoLancamento(bo.getAnoLancamento());
		bo.setDescricao(bo.getDescricao());
		bo.setAtores(bo.getAtores());
		bo.setCriacao(bo.getCriacao());
		bo.setGenero(bo.getGenero());
		bo.setTemporada(bo.getTemporada());
		
		return bo;
	}

}
