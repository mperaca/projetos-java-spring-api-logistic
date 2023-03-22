package com.projetosjava.logistic.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.projetosjava.logistic.model.cliente_mod;
import com.projetosjava.logistic.repository.cliente_rep;
import com.projetosjava.logistic.services.cliente_srvc;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/logisticapi/clientes")
public class cliente_ctl {
	
	private cliente_rep clienteRepository;
	private cliente_srvc clienteService;

	@GetMapping
	public List<cliente_mod> listar() {
		return clienteRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<cliente_mod> retornaCliente(@PathVariable Long id) {
		Optional<cliente_mod> cliente = clienteRepository.findById(id);
		
		if (cliente.isPresent()) {
			return ResponseEntity.ok(cliente.get());					
		} else {
			return ResponseEntity.notFound().build();
		}		
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public cliente_mod incluiCliente(@Valid @RequestBody cliente_mod cliente) {
		return clienteService.salvar(cliente);
	}

	@PutMapping("/{id}")
	public ResponseEntity<cliente_mod> alteraCliente(@PathVariable Long id, @Valid @RequestBody cliente_mod cliente){

		if (clienteRepository.existsById(id)) {		
			cliente.setId(id);
			cliente_mod clientealterado = clienteService.salvar(cliente);
			return ResponseEntity.ok(clientealterado);			
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> excluiCliente(@PathVariable Long id) {
		
		if (clienteRepository.existsById(id)) {		
			clienteService.excluir(id);
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
}
 