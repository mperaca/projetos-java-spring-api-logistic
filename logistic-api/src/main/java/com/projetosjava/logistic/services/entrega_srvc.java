package com.projetosjava.logistic.services;

import java.time.LocalDateTime;

import javax.naming.spi.DirStateFactory.Result;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.projetosjava.logistic.model.entrega_mod;
import com.projetosjava.logistic.model.statusEntrega;
import com.projetosjava.logistic.repository.entrega_rep;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class entrega_srvc {

	private entrega_rep entregaRepository;
	
	@Transactional
	public entrega_mod criaEntrega(entrega_mod entrega) {
       
	   entrega.setStatus(statusEntrega.PENDENTE);
	   entrega.setDataPedido(LocalDateTime.now());
	   return entregaRepository.save(entrega);
				
	}
	
	
}
