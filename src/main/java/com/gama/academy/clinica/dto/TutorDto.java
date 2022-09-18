package com.gama.academy.clinica.dto;

import com.gama.academy.clinica.model.Tutor;

import lombok.Data;

@Data
public class TutorDto {

	private Long id;
	private String nome;
	private String email;
	private String telefone;

	public TutorDto() {
	}

	public TutorDto(Tutor tutor) {
		this.id = tutor.getId();
		this.nome = tutor.getNome();
		this.email = tutor.getEmail();
		this.telefone = tutor.getTelefone();
	}

}
