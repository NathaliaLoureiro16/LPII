package space.indietech;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.EmbeddedDatabaseConnection;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureTestDatabase(connection = EmbeddedDatabaseConnection.H2)

public class ProdutoTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void crud1Produto() throws Exception {
		createProduto();
		getProduto();
		updateProduto();
	}

	private void createProduto() throws Exception {
		String location = "/produtos/";

		String json = "{\"nome\": \"melancia\", \"valor\" : 8.99}";
		mockMvc.perform(put(location).header("Content-Type", "application/json").content(json))
				.andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$.codigo").value(1))
				.andExpect(jsonPath("$.nome").value("melancia")).andExpect(jsonPath("$.valor").value(8.99));
	}

	private void getProduto() throws Exception {
		String location = "/produtos/";

		mockMvc.perform(get(location).header("Content-Type", "application/json")).andExpect(status().is2xxSuccessful())
				.andExpect(jsonPath("$[0].codigo").value(1)).andExpect(jsonPath("$[0].nome").value("melancia"))
				.andExpect(jsonPath("$[0].valor").value(8.99));

	}

	private void updateProduto() throws Exception {
		String location = "/produtos";

		String json = "{\"nome\": \"melancia\", \"valor\" : 8.99}";

		mockMvc.perform(put(location).header("Content-Type", "application/json").content(json))
				.andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$.nome").value("melancia"));

	}

}
