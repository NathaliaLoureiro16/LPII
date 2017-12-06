package br.fundatec.natflix.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fundatec.natflix.convert.NatflixConvert;
import br.fundatec.natflix.dao.SerieEntity;
import br.fundatec.natflix.service.NatflixService;

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
	  public ResponseEntity<SerieDTO> getSerieId(@PathVariable("id") Long id){
		  natflixService.getSerieByID(id);
		return ResponseEntity.ok(SerieDTO); 
	}


	@DeleteMapping("/{id}")
	public ResponseEntity<SerieEntity> delete(@PathVariable("id") Long id) {
		natflixService.deletaSerie(id);
		return ResponseEntity.noContent().build();

	}
}
