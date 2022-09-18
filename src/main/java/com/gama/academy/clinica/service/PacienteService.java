package com.gama.academy.clinica.service;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gama.academy.clinica.dto.PacienteDto;
import com.gama.academy.clinica.model.Paciente;
import com.gama.academy.clinica.model.Tutor;
import com.gama.academy.clinica.repository.PacienteRepository;

@Service
public class PacienteService {

	@Autowired
	private PacienteRepository pacienteRepository;

	@Autowired
	private TutorService tutorService;

	public List<PacienteDto> getAll() {

		List<Paciente> pacientes = pacienteRepository.findAll();
		List<PacienteDto> pacientesDto = pacientes.stream().map(paciente -> new PacienteDto(paciente)).toList();
		return pacientesDto;
	}

	public PacienteDto findById(Long id) {
		Paciente paciente = pacienteRepository.findById(id).orElse(null);
		
		if (!Objects.isNull(paciente)) {
			return new PacienteDto(paciente);
		}
		return null;
	}

	public PacienteDto save(Paciente paciente) {

		Tutor tutor = tutorService.getById(paciente.getTutorId());
		if (!Objects.isNull(tutor)) {
			paciente.setTutor(tutor);
			Paciente pacienteSalvo = pacienteRepository.save(paciente);
			return new PacienteDto(pacienteSalvo);
		}
		return null;
	}

	public PacienteDto update(Long id, Paciente pacienteNovo) {

		Paciente pacienteAntigo = pacienteRepository.findById(id).orElse(null);
		
		if (!Objects.isNull(pacienteAntigo)) {
			
			pacienteNovo.setId(pacienteAntigo.getId());
			pacienteNovo.setTutor(pacienteAntigo.getTutor());			
			pacienteNovo = pacienteRepository.save(pacienteNovo);
			
			return new PacienteDto(pacienteNovo);
		}
		return null;
	}

	public String delete(Long id) {
		
		if (!Objects.isNull(findById(id))) {
			pacienteRepository.deleteById(id);
			return "Objeto Excluido";
		}
		return "Objeto Não Encontrado";
	}

}
