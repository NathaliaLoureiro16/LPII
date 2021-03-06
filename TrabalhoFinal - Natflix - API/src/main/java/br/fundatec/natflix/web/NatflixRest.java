package br.fundatec.natflix.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fundatec.natflix.convert.EpConvert;
import br.fundatec.natflix.convert.SerieConvert;
import br.fundatec.natflix.service.EpisodioBo;
import br.fundatec.natflix.service.NatflixService;
import br.fundatec.natflix.service.SerieBo;

@RestController
@RequestMapping(value = "/natflix")
public class NatflixRest {

	private NatflixService natflixService;

	@Autowired
	public NatflixRest(NatflixService natflixService) {
		this.natflixService = natflixService;
	}

	@GetMapping("/series")
	public ResponseEntity<List<SerieDTO>> getSerie() {
		List<SerieBo> seriesBo = natflixService.pegaSeries();
		List<SerieDTO> seriesDTO = SerieConvert.convertListBotoDTO(seriesBo);
		return ResponseEntity.ok(seriesDTO);
	}

	@GetMapping("/series/{id}")
	public ResponseEntity<SerieDTO> getSerieId(@PathVariable("id") long id) {
		try {
			SerieDTO serieDTO = SerieConvert.convertBotoDTO(natflixService.getSerieByID(id));
			return ResponseEntity.ok(serieDTO);
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
			
		}
		
	}

	@DeleteMapping("/series/{id}")
	public ResponseEntity<SerieDTO> delete(@PathVariable("id") long id) {
		natflixService.deletaSerie(id);
		return ResponseEntity.noContent().build();

	}

	@PostMapping("/series")
	public ResponseEntity<SerieDTO> addSerie(@RequestBody SerieDTO serieDTO) {
		SerieBo serieBo = SerieConvert.convertDTOtoBo(serieDTO);
		serieDTO = SerieConvert.convertBotoDTO(natflixService.addSerie(serieBo));
		return ResponseEntity.ok(serieDTO);

	}

	@PutMapping("/series")
	public ResponseEntity<SerieDTO> attSerie(@RequestBody SerieDTO serieDTO) {
		SerieBo serieBo = SerieConvert.convertDTOtoBo(serieDTO);
		serieDTO = SerieConvert.convertBotoDTO(natflixService.addSerie(serieBo));
		return ResponseEntity.ok(serieDTO);
	}
	//==========================================================================================================//
	@PostMapping("/series/{id}/episodio")
	public ResponseEntity<EpisodioDTO>addEp(@RequestBody EpisodioDTO epDTO,@PathVariable("id") long id){
		EpisodioBo epBo = EpConvert.convertDTOtoBo(epDTO);
		epBo = natflixService.addEp(id,epBo);
		return ResponseEntity.ok(EpConvert.convertBotoDTO(epBo));
		
	}
	@GetMapping("/series/{id}/episodio")
	public ResponseEntity<List<EpisodioDTO>> getEpisodio(@PathVariable("id")long id) {
		List<EpisodioBo> episodioBo = natflixService.pegaEpisodio();
		List<EpisodioDTO> episodioDTO = EpConvert.convertListEpisodioBotoDTO(episodioBo);
		return ResponseEntity.ok(episodioDTO);
	}
	@PutMapping("/series/{id}/episodio/{idEp}")
	public ResponseEntity<EpisodioDTO> attEpisodio(@RequestBody EpisodioDTO episodioDTO,@PathVariable("id")long id,@PathVariable ("idEp") long idEp) {
		episodioDTO.setId(idEp);
		EpisodioBo episodioBo = EpConvert.convertDTOtoBo(episodioDTO);
		episodioDTO = EpConvert.convertBotoDTO(natflixService.attEpisodio(idEp, episodioBo));
		return ResponseEntity.ok(episodioDTO);
	}

}
