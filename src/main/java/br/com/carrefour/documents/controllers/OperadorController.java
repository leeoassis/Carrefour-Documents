package br.com.carrefour.documents.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.carrefour.documents.dto.EnvioOperadorLogin;
import br.com.carrefour.documents.entities.Operador;
import br.com.carrefour.documents.repository.OperadorRepository;
import br.com.carrefour.documents.response.GenericResponse;

@RestController
@RequestMapping("/api")
public class OperadorController {

	@Autowired
	private OperadorRepository or;
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ResponseEntity<GenericResponse> logar(@RequestBody EnvioOperadorLogin envioOperadorLogin, BindingResult result){
					
		GenericResponse genericResponse = new GenericResponse();
		
		Operador operador = this.or.findByNome(envioOperadorLogin.getNome());
		
		if(operador != null){
			
			if(operador.getSenha().toLowerCase().equals(envioOperadorLogin.getSenha())){
				
				genericResponse.setDs_status("S");
				genericResponse.setDs_msg("Seja Bem-Vindo, " + operador.getNome());
				genericResponse.setIdSessao(operador.getId());
				
				return ResponseEntity.ok(genericResponse);
				
			}
		}
		
		genericResponse.setDs_status("N");
		genericResponse.setDs_msg("Usuário não existe ou senha incorreta");
		
		return ResponseEntity.badRequest().body(genericResponse);
	}
	
}

