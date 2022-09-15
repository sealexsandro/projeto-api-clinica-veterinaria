package com.gama.academy.clinica.model;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_agendamento")
public class Agendamento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Instant dataAtendimento;
	private String horaAtendimento;
	private StatusAgendamento statusAgendamento;
	private Double pesoPaciente;
	
//	@OneToOne
//	private Paciente paciente;
//	
//	@OneToMany(mappedBy = "id.procedimento")
//	private List<Procedimento> procedimentos;

	public Agendamento() {
		//procedimentos = new ArrayList<>();
	}


}
