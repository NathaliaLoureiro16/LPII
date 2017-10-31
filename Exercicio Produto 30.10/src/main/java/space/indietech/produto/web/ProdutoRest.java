package space.indietech.produto.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import space.indietech.produto.ProdutoConvert;
import space.indietech.produto.dao.ProdutoEntity;
import space.indietech.produto.service.ProdutoBO;
import space.indietech.produto.service.ProdutoService;

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoRest {

	private ProdutoService produtoService;

	@Autowired
	public ProdutoRest(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@GetMapping
	public List<ProdutoDTO> getAll() {
		List<ProdutoDTO> produtosDTO = new ProdutoConvert().convertBODTO(produtoService.getLista());
		return produtosDTO;
	}
		
		
//
//	@GetMapping("/{codigo}") 
//	public ResponseEntity<ProdutoEntity> get(@PathVariable("codigo") Long codigo) {
//		try {
//			return ResponseEntity.ok(produtoService.getProdutoCodigo(codigo));
//		} catch (RuntimeException e) {
//			return ResponseEntity.notFound().build();
//		}
//	}

	@PutMapping
	public ResponseEntity<ProdutoEntity> savePF(@RequestBody ProdutoEntity produto) {
		return ResponseEntity.ok(produtoService.addProdutoList(produto));

	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<ProdutoEntity> delete(@PathVariable("codigo") Long codigo) {
		produtoService.deletaProduto(codigo);
		return ResponseEntity.ok().build();
	}

}
