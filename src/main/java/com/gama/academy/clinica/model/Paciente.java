package com.gama.academy.clinica.model;

import java.time.Instant;

public class Paciente {

	private Long id;
	private String nome;
	private SexoPaciente sexo;
	private Instant dataNascimento;

	public Paciente() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public SexoPaciente getSexo() {
		return sexo;
	}

	public void setSexo(SexoPaciente sexo) {
		this.sexo = sexo;
	}

	public Instant getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Instant dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

}
