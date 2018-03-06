package br.com.carrefour.documents.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "operador")
public class Operador implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nome")
	private String nome;

	@Column(name = "senha")
	private String senha;
	
	@Column(name = "id_setor")
	private Long idSetor;
	
	@Column(name = "id_perfil")
	private Long idPerfil;
	
	@Column(name = "situacao")
	private String situacao;
		
	public Operador(){
		
	}
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getIdSetor() {
		return idSetor;
	}

	public void setIdSetor(Long id_setor) {
		this.idSetor = id_setor;
	}

	public Long getIdPerfil() {
		return idPerfil;
	}

	public void setIdPerfil(Long id_perfil) {
		this.idPerfil = id_perfil;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}


	@Override
	public String toString() {
		return super.toString();
	}
}

