package com.gama.academy.clinica.model;

import java.time.Instant;
import java.util.List;

public class Agendamento {

	private Long id;
	private Paciente paciente;
	private Instant dataAtendimento;
	private String horaAtendimento;
	private StatusAgendamento statusAgendamento;
	private List<Procedimento> procedimentos;
	private Double pesoPaciente;

	public Agendamento() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public Instant getDataAtendimento() {
		return dataAtendimento;
	}

	public void setDataAtendimento(Instant dataAtendimento) {
		this.dataAtendimento = dataAtendimento;
	}

	public String getHoraAtendimento() {
		return horaAtendimento;
	}

	public void setHoraAtendimento(String horaAtendimento) {
		this.horaAtendimento = horaAtendimento;
	}

	public StatusAgendamento getStatusAgendamento() {
		return statusAgendamento;
	}

	public void setStatusAgendamento(StatusAgendamento statusAgendamento) {
		this.statusAgendamento = statusAgendamento;
	}

	public List<Procedimento> getProcedimentos() {
		return procedimentos;
	}

	public void setProcedimentos(List<Procedimento> procedimentos) {
		this.procedimentos = procedimentos;
	}

	public Double getPesoPaciente() {
		return pesoPaciente;
	}

	public void setPesoPaciente(Double pesoPaciente) {
		this.pesoPaciente = pesoPaciente;
	}

}
