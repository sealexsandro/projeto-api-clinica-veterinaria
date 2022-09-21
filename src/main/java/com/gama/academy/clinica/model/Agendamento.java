package com.gama.academy.clinica.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_agendamento")
public class Agendamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String dataAtendimento;
	private String horaAtendimento;
	private StatusAgendamento statusAgendamento;
	private Double pesoPaciente;
	
	@OneToOne(fetch = FetchType.EAGER)
	private Paciente paciente;
	
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Procedimento> procedimentos;
	
	@Transient
	private Long pacienteId;
	
	@Transient
	private List<Long> procedimentosIds;

	public Agendamento() {
		procedimentos = new ArrayList<>();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Agendamento other = (Agendamento) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

}
