package br.com.carrefour.documents.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carrefour.documents.entities.FotoPerfil;

public interface FotoPerfilRepository extends JpaRepository<FotoPerfil, Long>{

	FotoPerfil findById(Long jwt);
}
