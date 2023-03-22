package com.projetosjava.logistic.controller;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.projetosjava.logistic.model.entrega_mod;
import com.projetosjava.logistic.services.entrega_srvc;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
@RequestMapping("/logisticapi/entregas")
public class entrega_ctl {
	
	private entrega_srvc entregaService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public entrega_mod criaEntrega(@RequestBody entrega_mod entrega) {
		return entregaService.criaEntrega(entrega);
	}
	

}
