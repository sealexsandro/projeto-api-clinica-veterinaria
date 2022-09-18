package com.gama.academy.clinica.model;

import java.time.Instant;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_paciente")
public class Paciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Nome Do Pet é obrigatório!")
	private String nome;
	
//	@NotBlank(message = "Sexo Do Pet é obrigatório!")
//	@Enumerated(EnumType.ORDINAL)
	private SexoPaciente sexo;
	
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy", timezone = "GMT-3")
	private Instant dataNascimento;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "tutor_id")
	@JsonIgnore
	//@JsonBackReference
	private Tutor tutor;
	
	@Transient
	private Long tutorId;
	
	public Paciente() {}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Paciente other = (Paciente) obj;
		return Objects.equals(id, other.id);
	}

}
