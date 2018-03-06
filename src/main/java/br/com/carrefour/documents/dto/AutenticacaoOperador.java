package br.com.carrefour.documents.dto;

import java.io.Serializable;

public class AutenticacaoOperador implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long jwt;

	public Long getJwt() {
		return jwt;
	}

	public void setJwt(Long jwt) {
		this.jwt = jwt;
	}
	
	
	
}
