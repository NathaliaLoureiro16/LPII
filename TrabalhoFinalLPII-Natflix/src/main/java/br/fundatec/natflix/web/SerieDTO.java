package br.fundatec.natflix.web;

import java.util.List;

public class SerieDTO {

	private long id;
	private String titulo;
	private long anoLancamento;
	private String descricao;
	private String atores;
	private String criacao;
	private String genero;
	private int temporada;
	private List <EpisodioDTO> episodios;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public long getAnoLancamento() {
		return anoLancamento;
	}
	public void setAnoLancamento(long anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getAtores() {
		return atores;
	}
	public void setAtores(String atores) {
		this.atores = atores;
	}
	public String getCriacao() {
		return criacao;
	}
	public void setCriacao(String criacao) {
		this.criacao = criacao;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public int getTemporada() {
		return temporada;
	}
	public void setTemporada(int temporada) {
		this.temporada = temporada;
	}
	public List<EpisodioDTO> getEpisodios() {
		return episodios;
	}
	public void setEpisodios(List<EpisodioDTO> episodios) {
		this.episodios = episodios;
	}
	
}
