package com.gama.academy.clinica.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gama.academy.clinica.model.Procedimento;

@Repository
public interface ProcedimentoRepository extends JpaRepository<Procedimento, Long> {

}
