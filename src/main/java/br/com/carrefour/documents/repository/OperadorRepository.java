package br.com.carrefour.documents.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.carrefour.documents.entities.Operador;

@Repository
public interface OperadorRepository extends JpaRepository<Operador, Long>{
	
	Operador findByNome(String nome);

	Operador findById(Long jwt);
}
