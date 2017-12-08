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

import br.fundatec.natflix.convert.NatflixConvert;
import br.fundatec.natflix.dao.SerieEntity;
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
		List<SerieDTO> seriesDTO = NatflixConvert.convertListBotoDTO(seriesBo);
		return ResponseEntity.ok(seriesDTO);
	}

	@GetMapping("/series/{id}")
	public ResponseEntity<SerieDTO> getSerieId(@PathVariable("id") long id) {
		try {
			SerieDTO serieDTO = NatflixConvert.convertBotoDTO(natflixService.getSerieByID(id));
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
		SerieBo serieBo = NatflixConvert.convertDTOtoBo(serieDTO);
		serieDTO = NatflixConvert.convertBotoDTO(natflixService.addSerie(serieBo));
		return ResponseEntity.ok(serieDTO);

	}

	@PutMapping("/series")
	public ResponseEntity<SerieDTO> attSerie(@RequestBody SerieDTO serieDTO) {
		SerieBo serieBo = NatflixConvert.convertDTOtoBo(serieDTO);
		serieDTO = NatflixConvert.convertBotoDTO(natflixService.addSerie(serieBo));
		return ResponseEntity.ok(serieDTO);
	}
	@PostMapping("/series/{id}/episodio")
	public ResponseEntity<EpisodioDTO>addEp(@RequestBody EpisodioDTO epDTO,@PathVariable("id") long id){
		EpisodioBo epBo = NatflixConvert.convertDTOtoBo(epDTO);
		epBo = natflixService.addEp(id,epBo);
		return ResponseEntity.ok(NatflixConvert.convertBotoDTO(epBo));
		
	}
}
