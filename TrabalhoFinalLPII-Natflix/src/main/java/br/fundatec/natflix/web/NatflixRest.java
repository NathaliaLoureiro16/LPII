package br.fundatec.natflix.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.fundatec.natflix.service.NatflixService;


@RestController
@RequestMapping(value = "/natflix")
public class NatflixRest {
	private NatflixService natflixService;
	
	@Autowired
	public NatflixRest(NatflixService natflixService) {
		this.natflixService = natflixService;
	} 
	

}
