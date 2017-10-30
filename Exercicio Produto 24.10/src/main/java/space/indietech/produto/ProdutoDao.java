package space.indietech.produto;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProdutoDao {

	private EntityManager em;

	@Autowired
	public ProdutoDao(EntityManager em) {
		this.em = em;
	}

	@Transactional
	public Produto setProdutoLista(Produto produto) {
	return em.merge(produto);

	}

	public List<Produto> getListaProduto(){
	List<Produto> produtos = em.createQuery("from Produto").getResultList();
	return produtos;
}

	@Transactional
	public void deletarProduto(Long codigo) {
		Produto produto = new Produto();
		produto.setCodigo(codigo);
		produto = em.find(Produto.class, codigo);
		if (produto != null) {
			em.remove(produto);
		}
	}
}
