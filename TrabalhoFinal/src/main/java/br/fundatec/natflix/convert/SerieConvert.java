package br.fundatec.natflix.convert;

import java.util.ArrayList;
import java.util.List;

import br.fundatec.natflix.dao.SerieEntity;
import br.fundatec.natflix.service.SerieBo;
import br.fundatec.natflix.web.SerieDTO;

public class SerieConvert {

//===============================================================================================\\	
	public static SerieEntity convertBotoEntity(SerieBo bo) {
		SerieEntity entity = new SerieEntity();
		entity.setId(bo.getId());
		entity.setTitulo(bo.getTitulo());
		entity.setAnoLancamento(bo.getAnoLancamento());
		entity.setDescricao(bo.getDescricao());
		entity.setAtores(bo.getAtores());
		entity.setCriacao(bo.getCriacao());
		entity.setGenero(bo.getGenero());
		entity.setTemporada(bo.getTemporada());
		return entity;
	}

	public static SerieBo convertEntitytoBo(SerieEntity entity) {
		SerieBo bo = new SerieBo();
		bo.setId(entity.getId());
		bo.setTitulo(entity.getTitulo());
		bo.setAnoLancamento(entity.getAnoLancamento());
		bo.setDescricao(entity.getDescricao());
		bo.setAtores(entity.getAtores());
		bo.setCriacao(entity.getCriacao());
		bo.setGenero(entity.getGenero());
		bo.setTemporada(entity.getTemporada());

		return bo;
	}
	//===============================================================================================\\
	public static SerieDTO convertBotoDTO(SerieBo bo) {
		SerieDTO dto = new SerieDTO();
		dto.setId(bo.getId());
		dto.setTitulo(bo.getTitulo());
		dto.setAnoLancamento(bo.getAnoLancamento());
		dto.setDescricao(bo.getDescricao());
		dto.setAtores(bo.getAtores());
		dto.setCriacao(bo.getCriacao());
		dto.setGenero(bo.getGenero());
		dto.setTemporada(bo.getTemporada());
		return dto;
	}
	public static SerieBo convertDTOtoBo(SerieDTO dto) {
		SerieBo Bo = new SerieBo();
		Bo.setId(dto.getId());
		Bo.setTitulo(dto.getTitulo());
		Bo.setAnoLancamento(dto.getAnoLancamento());
		Bo.setDescricao(dto.getDescricao());
		Bo.setAtores(dto.getAtores());
		Bo.setCriacao(dto.getCriacao());
		Bo.setGenero(dto.getGenero());
		Bo.setTemporada(dto.getTemporada());
		return Bo;
	}
	//===============================================================================================\\

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
	public static List<SerieDTO> convertListBotoDTO(List<SerieBo> Bo) {
		List<SerieDTO> dtos = new ArrayList<>();
		for (SerieBo seriesBo : Bo) {
			SerieDTO dto = new SerieDTO();
			dto.setId(seriesBo.getId());
			dto.setTitulo(seriesBo.getTitulo());
			dto.setAnoLancamento(seriesBo.getAnoLancamento());
			dto.setDescricao(seriesBo.getDescricao());
			dto.setAtores(seriesBo.getAtores());
			dto.setCriacao(seriesBo.getCriacao());
			dto.setGenero(seriesBo.getGenero());
			dto.setTemporada(seriesBo.getTemporada());

			dtos.add(dto);

		}
		return dtos;
	}
}
