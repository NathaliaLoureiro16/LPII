package space.indietech.produto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProdutoDao {

	private List<Produto> lista = new ArrayList<>();

	public List<Produto> getListaProdutos() {
		return lista;
	}

	public void setProdutoLista(Produto produto) {
		lista.add(produto);

	}

	public void deletarProduto(int codigo) {
		Iterator<Produto> it = lista.iterator();
		while (it.hasNext()) {
			Produto produto = it.next();
			if (produto.getCodigo() == codigo) {
				it.remove();
				break;
			}
		}
	}
}
