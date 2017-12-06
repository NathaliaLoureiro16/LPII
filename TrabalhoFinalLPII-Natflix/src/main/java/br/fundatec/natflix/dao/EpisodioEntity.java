package br.fundatec.natflix.dao;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "episodio")
public class EpisodioEntity {

		@Id
		@Column(name="id")
		@GeneratedValue
		private long id;
		
		@Column(name="titulo")
		private String titulo;
		
		@Column(name="descricao")
		private String descricao;
		
		@Column(name="duracao")
		private String duracao;

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

		public String getDescricao() {
			return descricao;
		}

		public void setDescricao(String descricao) {
			this.descricao = descricao;
		}

		public String getDuracao() {
			return duracao;
		}

		public void setDuracao(String duracao) {
			this.duracao = duracao;
		}

}
