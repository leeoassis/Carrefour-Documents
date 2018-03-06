package br.com.carrefour.documents.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "foto_perfil")
public class FotoPerfil {
	
	@Id
	@Column(name = "id")
	private Long id;
	
	@Column(name = "url_foto")
	private String url;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
	
	

}
