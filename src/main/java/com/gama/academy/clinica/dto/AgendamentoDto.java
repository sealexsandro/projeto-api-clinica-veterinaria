package com.gama.academy.clinica.dto;

import com.gama.academy.clinica.model.Agendamento;
import com.gama.academy.clinica.model.StatusAgendamento;

import lombok.Data;

@Data
public class AgendamentoDto {
	
	private Long id;
	private String dataAtendimento;
	private String horaAtendimento;
	private StatusAgendamento statusAgendamento;
	private Double pesoPaciente;
	
	public AgendamentoDto() {}
	
	public AgendamentoDto(Agendamento agendamento) {
		id = agendamento.getId();
		dataAtendimento = agendamento.getDataAtendimento();
		horaAtendimento = agendamento.getHoraAtendimento();
		statusAgendamento = agendamento.getStatusAgendamento();
		pesoPaciente = agendamento.getPesoPaciente();
	}
	
	

}
