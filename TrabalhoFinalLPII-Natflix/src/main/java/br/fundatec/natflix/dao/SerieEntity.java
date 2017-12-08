package br.fundatec.natflix.dao;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.fundatec.natflix.service.EpisodioBo;


@Entity
@Table(name = "serie")
public class SerieEntity {
	
	@Id
	@Column(name="id")
	@GeneratedValue
	private long id;
	
	@Column(name="titulo")
	private String titulo;
	
	@Column(name="anoLancamento")
	private long anoLancamento;
	
	@Column(name="descricao")
	private String descricao;
	
	@Column(name="atores")
	private String atores;
	
	@Column(name="criacao")
	private String criacao;
	
	@Column(name="genero")
	private String genero;
	
	@Column(name="temporada")
	private int temporada;
	
	@OneToMany
	private List <EpisodioEntity> episodios;
	
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
	public List<EpisodioEntity> getEpisodios() {
		return episodios;
	}
	public void setEpisodios(List<EpisodioEntity> episodios) {
		this.episodios = episodios;
	
	}
	
	
}
