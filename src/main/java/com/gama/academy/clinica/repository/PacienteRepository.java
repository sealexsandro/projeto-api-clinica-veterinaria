package com.gama.academy.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gama.academy.clinica.model.Paciente;


public interface PacienteRepository extends JpaRepository<Paciente, Long>{

}
