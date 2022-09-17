package com.gama.academy.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.gama.academy.clinica.model.Paciente;
import com.gama.academy.clinica.model.Tutor;


public interface PacienteRepository extends JpaRepository<Paciente, Long>{
	
	@Query(value = "select * from tb_tutor where id = :tutorId", nativeQuery = true)
	public Tutor getTutor(Long tutorId);
	
}
