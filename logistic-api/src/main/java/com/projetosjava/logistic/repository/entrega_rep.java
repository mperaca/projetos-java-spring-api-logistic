package com.projetosjava.logistic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetosjava.logistic.model.entrega_mod;

@Repository
public interface entrega_rep extends JpaRepository<entrega_mod, Long> {

}
