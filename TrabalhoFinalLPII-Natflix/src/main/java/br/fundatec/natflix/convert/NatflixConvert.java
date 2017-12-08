package br.fundatec.natflix.convert;

import java.util.ArrayList;
import java.util.List;

import br.fundatec.natflix.dao.EpisodioEntity;
import br.fundatec.natflix.dao.SerieEntity;
import br.fundatec.natflix.service.EpisodioBo;
import br.fundatec.natflix.service.SerieBo;
import br.fundatec.natflix.web.EpisodioDTO;
import br.fundatec.natflix.web.SerieDTO;

public class NatflixConvert {

	public static List<SerieBo> convertListEntitytoBo(List<SerieEntity> entitys) {
		List<SerieBo> bos = new ArrayList<>();
		for (SerieEntity serieEntity : entitys) {
			SerieBo bo = new SerieBo();
			bo.setEpisodios(convertListEpisodioEntitytoBo(serieEntity.getEpisodios()));
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

	public static SerieEntity convertBotoEntity(SerieBo bo) {
		SerieEntity entity = new SerieEntity();
		entity.setEpisodios(convertListEpisodioBotoEntity(bo.getEpisodios()));
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
		bo.setEpisodios(convertListEpisodioEntitytoBo(entity.getEpisodios()));
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

	public static List<SerieDTO> convertListBotoDTO(List<SerieBo> Bo) {
		List<SerieDTO> dtos = new ArrayList<>();
		for (SerieBo seriesBo : Bo) {
			SerieDTO dto = new SerieDTO();
			dto.setEpisodios(convertListEpisodioBotoDTO(seriesBo.getEpisodios()));
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

	public static SerieDTO convertBotoDTO(SerieBo bo) {
		SerieDTO dto = new SerieDTO();
		dto.setEpisodios(convertListEpisodioBotoDTO(bo.getEpisodios()));
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
		Bo.setEpisodios(convertListEpisodioDTOtoBo(dto.getEpisodios()));
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
	// -------------------------------------------------------------------------------------------------------------//

	public static EpisodioBo convertDTOtoBo(EpisodioDTO epDTO) {
		EpisodioBo bo = new EpisodioBo();
		bo.setId(epDTO.getId());
		bo.setTitulo(epDTO.getTitulo());
		bo.setDescricao(epDTO.getDescricao());
		bo.setDuracao(epDTO.getDuracao());

		return bo;
	}

	public static EpisodioEntity convertBotoEntity(EpisodioBo epBo) {
		EpisodioEntity epEntity = new EpisodioEntity();
		epEntity.setId(epBo.getId());
		epEntity.setTitulo(epBo.getTitulo());
		epEntity.setDescricao(epBo.getDescricao());
		epEntity.setDuracao(epBo.getDuracao());

		return epEntity;
	}

	public static EpisodioBo convertEntitytoBo(EpisodioEntity epEntity) {
		EpisodioBo bo = new EpisodioBo();
		bo.setId(epEntity.getId());
		bo.setTitulo(epEntity.getTitulo());
		bo.setDescricao(epEntity.getDescricao());
		bo.setDuracao(epEntity.getDuracao());
		return bo;
	}
	public static EpisodioDTO convertBotoDTO(EpisodioBo episodioBo) {
		EpisodioDTO dto = new EpisodioDTO();
		dto.setId(episodioBo.getId());
		dto.setTitulo(episodioBo.getTitulo());
		dto.setDescricao(episodioBo.getDescricao());
		dto.setDuracao(episodioBo.getDuracao());
		return dto;
	}

	private static List<EpisodioEntity> convertListEpisodioBotoEntity(List<EpisodioBo> episodiosBo) {
		List<EpisodioEntity> tity = new ArrayList<>();
		for (EpisodioBo episodioBo : episodiosBo) {
			tity.add(convertBotoEntity(episodioBo));

		}
		return tity;
	}

	private static List<EpisodioDTO> convertListEpisodioBotoDTO(List<EpisodioBo> episodios) {
		List<EpisodioDTO> dtos = new ArrayList<>();
		for (EpisodioBo episodioBo : episodios) {
			dtos.add(convertBotoDTO(episodioBo));

		}
		return dtos;
	}

List EpisodioDTOtoBo
List EpisodioEntitytoBo

}
