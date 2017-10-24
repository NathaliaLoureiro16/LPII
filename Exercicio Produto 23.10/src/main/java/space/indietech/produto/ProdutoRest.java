package space.indietech.produto;

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

@RestController
@RequestMapping(value = "/produtos")
public class ProdutoRest {

	private ProdutoService produtoService;

	@Autowired
	public ProdutoRest(ProdutoService produtoService) {
		this.produtoService = produtoService;
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> getAll() {
		return ResponseEntity.ok(produtoService.getLista());
	}

	@GetMapping("/{codigo}")
	public ResponseEntity<Produto> get(@PathVariable("codigo") int codigo) {
		try {
			return ResponseEntity.ok(produtoService.getProdutoCodigo(codigo));
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();
		}
	}

	@PutMapping("/{codigo}")
	public ResponseEntity<Produto> savePF(@PathVariable("codigo") int codigo, @RequestBody Produto produto) {
		return ResponseEntity.ok(produtoService.addProdutoList(codigo, produto));

	}

	@DeleteMapping("/{codigo}")
	public ResponseEntity<Produto> delete(@PathVariable("codigo") int codigo) {
		produtoService.deletaProduto(codigo);
		return ResponseEntity.ok().build();
	}

	@GetMapping("/{codigo}/{desconto}")
	public ResponseEntity<ProdutoDesconto> getProcDesconto(@PathVariable("codigo") int codigo,
			@PathVariable("desconto") double desconto) {
		try {
			return ResponseEntity.ok(produtoService.retornaProdutoDesconto(codigo, desconto));
		} catch (RuntimeException e) {
			return ResponseEntity.notFound().build();

		}

	}

}
