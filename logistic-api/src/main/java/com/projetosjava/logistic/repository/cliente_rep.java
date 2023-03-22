package com.projetosjava.logistic.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetosjava.logistic.model.cliente_mod;

@Repository
public interface cliente_rep extends JpaRepository<cliente_mod, Long> {
	
	List<cliente_mod> findByNome(String nome);
	List<cliente_mod> findByNomeContaining(String nome);
	Optional<cliente_mod> findByEmail(String email);
	
}
