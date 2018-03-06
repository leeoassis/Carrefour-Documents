package br.com.carrefour.documents.controllers;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.carrefour.documents.dto.EnvioArquivo;
import br.com.carrefour.documents.entities.Operador;
import br.com.carrefour.documents.entities.Perfil;
import br.com.carrefour.documents.repository.OperadorRepository;
import br.com.carrefour.documents.repository.PerfilRepository;
import br.com.carrefour.documents.response.ArquivoNome;
import br.com.carrefour.documents.response.ByteFileResponse;
import br.com.carrefour.documents.response.ListArquivoResponse;

@RestController
@RequestMapping("/api")
public class ArquivosController {

	@Autowired
	private PerfilRepository pr;

	@Autowired
	private OperadorRepository or;	
	
	@RequestMapping(value = "/listaArquivosObject", method=RequestMethod.GET)
	public ResponseEntity<ListArquivoResponse> listaArquivosObject(@RequestHeader(value = "token", required = true) Long id) {

		ListArquivoResponse arquivosResponse = new ListArquivoResponse();
		
		Operador operador = this.or.findById(id);

		Long idPerfil = operador.getIdPerfil();

		Perfil perfil = this.pr.findById(idPerfil);

		String urlDir = perfil.getUrlDir();

		File file = new File(urlDir);
		File[] arquivos = file.listFiles();
		ArrayList<ArquivoNome> nomeArquivos = new ArrayList<ArquivoNome>();
		
		try {
			for (File arquivo : arquivos) {				
				nomeArquivos.add(new ArquivoNome(arquivo.getName()));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		arquivosResponse.setArquivos(nomeArquivos);
		
		return ResponseEntity.ok(arquivosResponse);

	}


	@RequestMapping(value = "/enviaArquivos", method=RequestMethod.POST)
	public ResponseEntity<ByteFileResponse> enviarArquivos(@RequestHeader(value = "token", required = true) Long jwt, @RequestBody EnvioArquivo arquivo, BindingResult result)
			throws IOException {

		ByteFileResponse byteFileResponse = new ByteFileResponse();

		Operador operador = this.or.findById(jwt);

		Long idPerfil = operador.getIdPerfil();

		Perfil perfil = this.pr.findById(idPerfil);

		String urlDir = perfil.getUrlDir();

		StringBuilder diretoriofinal = new StringBuilder();
		diretoriofinal.append(urlDir);
		diretoriofinal.append("/");
		diretoriofinal.append(arquivo.getFile());

		byte[] encoded = Files.readAllBytes(Paths.get(diretoriofinal.toString()));
		
		String encodedString = Base64.getEncoder().encodeToString(encoded);
		
		byteFileResponse.setFile(encodedString);

		return ResponseEntity.ok(byteFileResponse);

	}
}
