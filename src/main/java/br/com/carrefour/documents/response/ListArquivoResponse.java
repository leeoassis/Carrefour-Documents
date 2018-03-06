package br.com.carrefour.documents.response;

import java.util.List;

public class ListArquivoResponse {
	
	private List<ArquivoNome> arquivos;
	
	public ListArquivoResponse() {
		
	}

	public ListArquivoResponse(List<ArquivoNome> arquivos) {
		this.arquivos = arquivos;
	}

	public List<ArquivoNome> getArquivos() {
		return arquivos;
	}

	public void setArquivos(List<ArquivoNome> arquivos) {
		this.arquivos = arquivos;
	}
	
	
}
