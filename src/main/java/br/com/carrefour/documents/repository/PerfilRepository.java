package br.com.carrefour.documents.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.carrefour.documents.entities.Perfil;

public interface PerfilRepository extends JpaRepository<Perfil, Long>{

	Perfil findById(Long id);
}
