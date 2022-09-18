package com.gama.academy.clinica.exception;

public class ViolacaoDeConstraintException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ViolacaoDeConstraintException(String mensagem) {
		super(mensagem);
	}
}
