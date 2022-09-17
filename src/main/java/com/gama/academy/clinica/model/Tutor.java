package com.gama.academy.clinica.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_tutor")
public class Tutor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String email;
	private String telefone;

	@OneToMany(mappedBy = "tutor", targetEntity = Paciente.class, cascade = CascadeType.ALL)
	private List<Paciente> pacientes = new ArrayList<>();
	
//	@OneToMany(cascade = CascadeType.ALL)
//	private List<Paciente> pacientes = new ArrayList<>();

	public Tutor() {
	}
	
	public void addPaciente(Paciente paciente) {
		this.pacientes.add(paciente);
	}

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
		Tutor other = (Tutor) obj;
		return Objects.equals(id, other.id);
	}


}
