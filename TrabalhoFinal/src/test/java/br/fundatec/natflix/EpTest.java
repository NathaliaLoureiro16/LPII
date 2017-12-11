package br.fundatec.natflix;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
public class EpTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void crudEpisodio() throws Exception {
		createEpisodio();
	}

	private void createEpisodio() throws Exception {
		String location = "/natflix/series/1/episodio";

		String json = "{ \"titulo\": \"o inicio\", \"descricao\": \"quando tudo começou\", \"duracao\":\"1h\" }";
		mockMvc.perform(post(location).header("Content-Type", "application/json")
				.header("token","eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0wNyAxNjowOTo0OS43NzIiLCJ1c3VhcmlvIjoiYWRtaW4ifQ.ACwZJYXALqcLkED7ep1hcinKx2I8BaovL1ekLzat7U0")
				.content(json)).andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.titulo").value("o inicio"))
				.andExpect(jsonPath("$.descricao").value("quando tudo começou"))
				.andExpect(jsonPath("$.duracao").value("1h"));

	}
}
