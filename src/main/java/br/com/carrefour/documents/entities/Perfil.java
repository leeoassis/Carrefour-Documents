package br.com.carrefour.documents.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "perfil")
public class Perfil implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "id_setor")
	private Long idSetor;
	
	@Column(name = "descricao")
	private String descricao;
	
	@Column(name = "url_dir_perfil")
	private String urlDir;
	
	
	public Perfil(){
		
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdsetor() {
		return idSetor;
	}

	public void setIdSetor(Long id_setor) {
		this.idSetor = id_setor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getUrlDir() {
		return urlDir;
	}

	public void setUrlDir(String urlDir) {
		this.urlDir = urlDir;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
	
	

}
