package com.gama.academy.clinica.model;

public enum SexoPaciente {

	MACHO(0), FEMEA(1);

	private Integer sexo;

	private SexoPaciente(Integer sexo) {
		this.sexo = sexo;
	}

	public Integer getSexo() {
		return sexo;
	}

}
