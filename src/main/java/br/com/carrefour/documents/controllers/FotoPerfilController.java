package br.com.carrefour.documents.controllers;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.carrefour.documents.entities.FotoPerfil;
import br.com.carrefour.documents.repository.FotoPerfilRepository;
import br.com.carrefour.documents.response.ByteFileResponse;

@RestController
@RequestMapping("/api")
public class FotoPerfilController {
	
	@Autowired
	private FotoPerfilRepository fpr;

	@RequestMapping(value = "/enviaFotoPerfil", method=RequestMethod.GET)
	public ResponseEntity<ByteFileResponse> enviarArquivos(@RequestHeader(value = "token", required = true) Long jwt)
			throws IOException {

		ByteFileResponse byteFileResponse = new ByteFileResponse();

		FotoPerfil fotoPerfil = this.fpr.findById(jwt);

		String urlFoto = fotoPerfil.getUrl();

		byte[] encoded = Files.readAllBytes(Paths.get(urlFoto));
		
		String encodedString = Base64.getEncoder().encodeToString(encoded);

		byteFileResponse.setFile(encodedString);

		return ResponseEntity.ok(byteFileResponse);

	}
}
