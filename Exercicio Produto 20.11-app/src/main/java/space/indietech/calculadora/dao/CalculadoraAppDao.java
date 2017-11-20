package space.indietech.calculadora.dao;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class CalculadoraAppDao {
	private ObjectMapper objectMapper = new ObjectMapper();

	public double calcularbo(String expressao) {
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpPut request = new HttpPut("http://localhost:9090/calculadora");
			
			request.addHeader("content-type", "application/json");
			
			StringEntity params = new StringEntity("{ \"calculo\" : \""+ expressao+"\"}","UTF-8");
			request.setEntity(params);
			
			HttpResponse response = client.execute(request);
			
			String json = EntityUtils.toString(response.getEntity(), "UTF-8");

			CalculadoraEntity calEntity = objectMapper.readValue(json, CalculadoraEntity.class);
			return calEntity.getValor();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return -1;
	}
}
