package com.gama.academy.clinica.model;

public enum StatusAgendamento {

	ATENDIDO(0),
	NAO_COMPARECEU(1),
	CANCELADO(2),
	ADIADO(3);
	
	private Integer status;
	
	private StatusAgendamento(Integer status) {
		this.status = status;
	}

	public Integer getStatus() {
		return status;
	}

}
