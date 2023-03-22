package com.projetosjava.logistic.exceptionhandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.projetosjava.logistic.exception.negocio_excpt;

@ControllerAdvice
public class apiExceptionHandler extends ResponseEntityExceptionHandler {
	
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		List<problema.campo> campos = new ArrayList<>();
		
		for (ObjectError erro : ex.getBindingResult().getAllErrors()) {
			String nome = ((FieldError) erro).getField();
			String mensagem = erro.getDefaultMessage();
			campos.add(new problema.campo(nome,mensagem));
		}
		
		problema meuproblema = new problema();
		meuproblema.setStatus(status.value());
		meuproblema.setDataHora(LocalDateTime.now());
		meuproblema.setDescricao("Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente");
		meuproblema.setCampos(campos);
		
		return handleExceptionInternal(ex,meuproblema, headers, status, request);
	}
	
	@ExceptionHandler(negocio_excpt.class)
	public ResponseEntity<Object> handleNegocio(negocio_excpt ex, WebRequest request) {
		
		problema meuproblema = new problema();
		HttpStatus status = HttpStatus.BAD_REQUEST;
		
		meuproblema.setStatus(status.value());
		meuproblema.setDataHora(LocalDateTime.now());
		meuproblema.setDescricao(ex.getMessage());
		return handleExceptionInternal(ex, meuproblema, new HttpHeaders(), status, request);
	}
	

}
