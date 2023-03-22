package com.projetosjava.logistic.exception;

public class negocio_excpt extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public negocio_excpt(String message) {
		super(message);
	}

}
