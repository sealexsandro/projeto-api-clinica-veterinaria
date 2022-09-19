package com.gama.academy.clinica.service;

import java.util.List;
import java.util.Objects;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gama.academy.clinica.dto.PacienteDto;
import com.gama.academy.clinica.model.Paciente;
import com.gama.academy.clinica.model.Tutor;
import com.gama.academy.clinica.repository.PacienteRepository;
import com.gama.academy.clinica.service.exception.ResourceNotFoundException;
import com.gama.academy.clinica.service.exception.ViolationConstraintException;

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

			try {
				paciente.setTutor(tutor);
				Paciente pacienteSalvo = pacienteRepository.save(paciente);
				return new PacienteDto(pacienteSalvo);
			} catch (ConstraintViolationException e) {
				throw new ViolationConstraintException(e.getMessage());
			}
		} else {
			throw new ResourceNotFoundException(Tutor.class.getSimpleName());
		}
	}

	public PacienteDto update(Long id, Paciente newPatient) {

		Paciente oldPatient = pacienteRepository.findById(id).orElse(null);

		if (!Objects.isNull(oldPatient)) {

			try {
				newPatient.setId(oldPatient.getId());
				newPatient.setTutor(oldPatient.getTutor());
				newPatient = pacienteRepository.save(newPatient);
				return new PacienteDto(newPatient);
			} catch (ConstraintViolationException e) {
				throw new ViolationConstraintException(e.getMessage());
			}
		} else {
			throw new ResourceNotFoundException(Paciente.class.getSimpleName());
		}
	}

	public String delete(Long id) {

		if (!Objects.isNull(findById(id))) {
			pacienteRepository.deleteById(id);
			return "Objeto Excluido";
		}else {
			throw new ResourceNotFoundException(Paciente.class.getSimpleName());
		}
	}

}
