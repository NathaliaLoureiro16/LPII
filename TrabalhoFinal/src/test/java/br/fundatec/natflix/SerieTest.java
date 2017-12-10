package br.fundatec.natflix;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
public class SerieTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void crud1Serie() throws Exception {
		createSerie();
		getSerie();
		updateSerie();
		deleteSerie();
	}

	private void createSerie() throws Exception {
		String location = "/natflix/series/";

		String json = "{\"titulo\":\"tvd\"," + "\"anoLancamento\":2009," + "\"descricao\":\"serie de vampiros\","
				+ "\"atores\":\"nina,ian,paul,candice\"," + "\"criacao\":\"Kevin Williamson\","
				+ "\"genero\":\"terror e fantasia\"," + "\"temporada\": 8}";
		mockMvc.perform(post(location).header("Content-Type", "application/json")
				.header("token","eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0wNyAxNjowOTo0OS43NzIiLCJ1c3VhcmlvIjoiYWRtaW4ifQ.ACwZJYXALqcLkED7ep1hcinKx2I8BaovL1ekLzat7U0")
				.content(json)).andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.titulo").value("tvd")).andExpect(jsonPath("$.anoLancamento").value(2009))
				.andExpect(jsonPath("$.descricao").value("serie de vampiros"))
				.andExpect(jsonPath("$.atores").value("nina,ian,paul,candice"))
				.andExpect(jsonPath("$.criacao").value("Kevin Williamson"))
				.andExpect(jsonPath("$.genero").value("terror e fantasia")).andExpect(jsonPath("$.temporada").value(8));

	}

	private void getSerie() throws Exception {
		String location = "/natflix/series/";

		mockMvc.perform(get(location).header("Content-Type", "application/json").header("token","eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0wNyAxNjowOTo0OS43NzIiLCJ1c3VhcmlvIjoiYWRtaW4ifQ.ACwZJYXALqcLkED7ep1hcinKx2I8BaovL1ekLzat7U0"))
				.andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$[0]").exists())
				.andExpect(jsonPath("$[0].id").value(1)).andExpect(jsonPath("$[0].titulo").value("tvd"))
				.andExpect(jsonPath("$[0].anoLancamento").value(2009))
				.andExpect(jsonPath("$[0].descricao").value("serie de vampiros"))
				.andExpect(jsonPath("$[0].atores").value("nina,ian,paul,candice"))
				.andExpect(jsonPath("$[0].criacao").value("Kevin Williamson"))
				.andExpect(jsonPath("$[0].genero").value("terror e fantasia"))
				.andExpect(jsonPath("$[0].temporada").value(8));
	}

	private void updateSerie() throws Exception {
		String location = "/natflix/series/";

		String json = "{\"id\":1,\"titulo\":\"The Vampire Diaries\"," + "\"anoLancamento\":2009,"
				+ "\"descricao\":\"serie de vampiros\"," + "\"atores\":\"nina,ian,paul,candice\","
				+ "\"criacao\":\"Kevin Williamson\"," + "\"genero\":\"terror e fantasia\"," + "\"temporada\": 8}";

		mockMvc.perform(put(location).header("Content-Type", "application/json").content(json).header("token","eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0wNyAxNjowOTo0OS43NzIiLCJ1c3VhcmlvIjoiYWRtaW4ifQ.ACwZJYXALqcLkED7ep1hcinKx2I8BaovL1ekLzat7U0"))
				.andExpect(status().is2xxSuccessful()).andExpect(jsonPath("$.id").value(1))
				.andExpect(jsonPath("$.titulo").value("The Vampire Diaries")).andExpect(jsonPath("$.anoLancamento").value(2009))
				.andExpect(jsonPath("$.descricao").value("serie de vampiros"))
				.andExpect(jsonPath("$.atores").value("nina,ian,paul,candice"))
				.andExpect(jsonPath("$.criacao").value("Kevin Williamson"))
				.andExpect(jsonPath("$.genero").value("terror e fantasia"))
				.andExpect(jsonPath("$.temporada").value(8));

	}

	private void deleteSerie() throws Exception {
		String location = "natflix/series/{id}";

 		mockMvc.perform(delete(location,1).header("Content-Type", "application/json").header("token","eyJhbGciOiJIUzI1NiJ9.eyJjcmVhdGVkIjoiMjAxNy0xMi0wNyAxNjowOTo0OS43NzIiLCJ1c3VhcmlvIjoiYWRtaW4ifQ.ACwZJYXALqcLkED7ep1hcinKx2I8BaovL1ekLzat7U0"))
				   .andExpect(status().isNoContent());
	}
}
