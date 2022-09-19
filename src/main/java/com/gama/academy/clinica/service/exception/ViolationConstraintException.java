package com.gama.academy.clinica.service.exception;

public class ViolationConstraintException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ViolationConstraintException(String mensagem) {
		super(mensagem);
	}
}
