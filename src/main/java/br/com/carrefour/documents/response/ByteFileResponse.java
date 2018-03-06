package br.com.carrefour.documents.response;

import java.io.Serializable;

public class ByteFileResponse implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String file;

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}
	
	

}
