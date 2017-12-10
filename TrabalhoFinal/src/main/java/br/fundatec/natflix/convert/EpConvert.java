package br.fundatec.natflix.convert;

import java.util.ArrayList;
import java.util.List;

import br.fundatec.natflix.dao.EpisodioEntity;
import br.fundatec.natflix.service.EpisodioBo;
import br.fundatec.natflix.web.EpisodioDTO;

public class EpConvert {

	public static EpisodioBo convertDTOtoBo(EpisodioDTO epDTO) {
		EpisodioBo bo = new EpisodioBo();
		bo.setId(epDTO.getId());
		bo.setTitulo(epDTO.getTitulo());
		bo.setDescricao(epDTO.getDescricao());
		bo.setDuracao(epDTO.getDuracao());

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
	// ==========================================================================================================//
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
	// ==========================================================================================================//
	public static List<EpisodioEntity> convertListEpisodioBotoEntity(List<EpisodioBo> epiBo) {
		List<EpisodioEntity> tity = new ArrayList<>();
		for (EpisodioBo episodioBo : epiBo) {
			EpisodioEntity epEntity = new EpisodioEntity();
			epEntity.setId(episodioBo.getId());
			epEntity.setTitulo(episodioBo.getTitulo());
			epEntity.setDescricao(episodioBo.getDescricao());
			epEntity.setDuracao(episodioBo.getDuracao());
			tity.add(epEntity);

		}
		return tity;
	}
	private static List<EpisodioDTO> convertListEpisodioBotoDTO(List<EpisodioBo> epBo) {
		List<EpisodioDTO> dtos = new ArrayList<>();
		for (EpisodioBo episodioBo : epBo) {
			EpisodioDTO dto = new EpisodioDTO();
			dto.setId(episodioBo.getId());
			dto.setTitulo(episodioBo.getTitulo());
			dto.setDescricao(episodioBo.getDescricao());
			dto.setDuracao(episodioBo.getDuracao());
			dtos.add(dto);
		}
		return dtos;
	}

}

