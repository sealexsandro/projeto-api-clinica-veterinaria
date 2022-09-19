package com.gama.academy.clinica.dto;

import com.gama.academy.clinica.model.Procedimento;

import lombok.Data;

@Data
public class ProcedimentoDto {
	
	private Long id;
	private String descricao;
	
	public ProcedimentoDto() {}
	
	public ProcedimentoDto(Procedimento procedimento) {
		id = procedimento.getId();
		descricao = procedimento.getDescricao();
	}

}
