package br.com.carrefour.documents.response;

import java.io.Serializable;

public class GenericResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long idSessao;
	private String ds_status;
	private String ds_msg;
	
	
	public Long getIdSessao() {
		return idSessao;
	}
	public void setIdSessao(Long idSessao) {
		this.idSessao = idSessao;
	}
	public String getDs_status() {
		return ds_status;
	}
	public void setDs_status(String ds_status) {
		this.ds_status = ds_status;
	}
	public String getDs_msg() {
		return ds_msg;
	}
	public void setDs_msg(String ds_msg) {
		this.ds_msg = ds_msg;
	}
		
}
