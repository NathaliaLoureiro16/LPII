package space.indietech.calculadora.convert;

import java.util.Date;

import space.indietech.calculadora.dao.CalculadoraEntity;
import space.indietech.calculadora.service.CalculadoraBO;
import space.indietech.calculadora.web.CalculadoraDTO;
import space.indietech.calculadora.web.CalculadoraDTORecebe;

public class CalculadoraConvert {
	public CalculadoraBO convertEntityBO(CalculadoraEntity entity) {
		CalculadoraBO bo = new CalculadoraBO();
		bo.setExpressao(entity.getExpressao());
		bo.setValor(entity.getValor());
		return bo;
	}

	public CalculadoraEntity convertBOEntity(CalculadoraBO bo) {
		CalculadoraEntity entity = new CalculadoraEntity();
		entity.setExpressao(bo.getExpressao());
		entity.setValor(bo.getValor());
		entity.setCriado_em(new Date());
		return entity;
	}
	public static CalculadoraBO convertDTORecebeBO(CalculadoraDTORecebe caldto) {
		CalculadoraBO bo = new CalculadoraBO();
		bo.setExpressao(caldto.getCalculo());
		return bo;
		
	}
	public static CalculadoraDTO convertBODTOenvia(CalculadoraBO bo) {
		CalculadoraDTO dto = new CalculadoraDTO();
		dto.setValor(bo.getValor());
		return dto;
		
	}
}
