package com.gama.academy.clinica.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gama.academy.clinica.model.Paciente;
import com.gama.academy.clinica.model.Tutor;
import com.gama.academy.clinica.repository.PacienteRepository;
import com.gama.academy.clinica.repository.TutorRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;

	public List<Paciente> getAll() {
		return pacienteRepository.findAll();
	}

	public Paciente findById(Long id) {
		return pacienteRepository.findById(id).orElse(null);
	}

	public Tutor getTutor(Long tutorId) {

		Tutor tutor = pacienteRepository.getTutor(tutorId);

		return tutor;
	}

	public Paciente save(Paciente p) {
		return pacienteRepository.save(p);
	}

	public Paciente update(Long id, Paciente p) {

		Paciente paciente = findById(id);

		if (!Objects.isNull(paciente)) {
			p.setId(id);
			return pacienteRepository.save(p);
		}
		return null;
	}

	public String delete(Long id) {

		Paciente p = findById(id);

		if (p != null) {
			pacienteRepository.deleteById(id);
			return "Objeto Excluido";
		}
		return "Objeto Não Encontrado";
	}

}
