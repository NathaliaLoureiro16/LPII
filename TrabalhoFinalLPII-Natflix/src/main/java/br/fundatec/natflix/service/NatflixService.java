package br.fundatec.natflix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.fundatec.natflix.dao.NatflixDao;

@Component
public class NatflixService {
	private NatflixDao nDao;
	
	@Autowired
	public NatflixService(NatflixDao nDao){
		this.nDao = nDao;
	}
	

}
