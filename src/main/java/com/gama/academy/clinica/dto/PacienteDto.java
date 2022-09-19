package com.gama.academy.clinica.dto;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gama.academy.clinica.model.Paciente;
import com.gama.academy.clinica.model.SexoPaciente;

import lombok.Data;

@Data
public class PacienteDto {

	private Long id;
	private String nome;
	private SexoPaciente sexo;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT-3")
	private LocalDate dataNascimento;

	private TutorDto tutor;

	public PacienteDto() {
	}

	public PacienteDto(Paciente paciente) {
		this.id = paciente.getId();
		this.nome = paciente.getNome();
		this.sexo = paciente.getSexo();
		this.dataNascimento = paciente.getDataNascimento();
		this.tutor = new TutorDto(paciente.getTutor());
	}

}
