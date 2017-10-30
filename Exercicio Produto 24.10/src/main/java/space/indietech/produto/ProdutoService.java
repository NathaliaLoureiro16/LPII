package space.indietech.produto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoService {
	private ProdutoDao pDao;

	@Autowired
	public ProdutoService(ProdutoDao pDao) {
		this.pDao = pDao;
	}
	public List<Produto> getLista() {
		return pDao.getListaProduto();
	}

	public Produto getProdutoCodigo(Long codigo) {
		List<Produto> minhaLista = getLista();
		for (Produto produto : minhaLista) {
			if (produto.getCodigo() == codigo) {
				return produto;
			}
		}
		throw new RuntimeException();
	}

	public Produto addProdutoList(Produto produto) {
		produto = pDao.setProdutoLista(produto);
		return produto;
	}

	public void deletaProduto(Long codigo) {
		pDao.deletarProduto(codigo);
	}

	public  ProdutoDesconto retornaProdutoDesconto(Long codigo, double desconto) {
		Produto produto = getProdutoCodigo(codigo);
		ProdutoDesconto produtoDesconto = new ProdutoDesconto();
		produtoDesconto.setCodigo(codigo);
		produtoDesconto.setDesconto(desconto);
		produtoDesconto.setNome(produto.getNome());
		produtoDesconto.setValor(produto.getValor());
		produtoDesconto.gerarValorComDesconto();
		return produtoDesconto;
	}

}
