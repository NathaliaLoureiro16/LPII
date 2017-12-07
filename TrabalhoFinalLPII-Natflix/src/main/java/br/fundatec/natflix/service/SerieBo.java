package br.fundatec.natflix.service;

import java.util.Date;

public class SerieBo {

	private long id;
	private String titulo;
	private Date anoLancamento;
	private String descricao;
	private String atores;
	private String criacao;
	private String genero;
	private int temporada;
	//private List <EpisodioEntity> episodios;
	
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
	public Date getAnoLancamento() {
		return anoLancamento;
	}
	public void setAnoLancamento(Date anoLancamento) {
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
	/*public List<EpisodioEntity> getEpisodios() {
		return episodios;
	}
	public void setEpisodios(List<EpisodioEntity> episodios) {
		this.episodios = episodios;
	}
	*/
}
