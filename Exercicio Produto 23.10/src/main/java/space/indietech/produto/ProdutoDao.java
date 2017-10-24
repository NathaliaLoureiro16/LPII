package space.indietech.produto;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.session.SessionProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.RowMapperResultSetExtractor;
import org.springframework.jdbc.support.SQLExceptionSubclassTranslator;
import org.springframework.stereotype.Component;

@Component
public class ProdutoDao {

	private JdbcTemplate jdbc;

	@Autowired
	public ProdutoDao(JdbcTemplate jdbc) {
		this.jdbc = jdbc;
	}

	public void setProdutoLista(Produto produto) {
		jdbc.update("INSERT INTO PRODUTO(NOME,VALOR) VALUES(?,?)", produto.getNome(), produto.valor);

	}

	public List<Produto> getListaProduto(){
	List<Produto> produtos = jdbc.query("SELECT * FROM PRODUTO", new RowMapper<Produto>(){
		@Override
		public Produto mapRow(ResultSet rs, int rowNum) throws SQLException{
			Produto produto = new Produto();
			produto.setCodigo(rs.getInt("codigo"));
			produto.setNome(rs.getString("nome"));
			produto.setValor(rs.getDouble("valor"));
			
			return produto;
		}
	});
	return produtos;
}

	public void deletarProduto(int codigo) {
		jdbc.update("DELETE FROM PRODUTO WHERE CODIGO = ?", codigo);
	}
}
