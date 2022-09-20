package com.gama.academy.clinica.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.gama.academy.clinica.controller.exception.DatabaseException;
import com.gama.academy.clinica.dto.AgendamentoDto;
import com.gama.academy.clinica.model.Agendamento;
import com.gama.academy.clinica.repository.AgendamentoRepository;
import com.gama.academy.clinica.service.exception.ControllerNotFoundException;

@Service
public class AgendamentoService {

	@Autowired
	private AgendamentoRepository agendamentoRepository;
	
	@Transactional(readOnly = true)
	public List<AgendamentoDto> findAll(){
		List<Agendamento> lista = agendamentoRepository.findAll();
		return lista.stream()
				.map(x -> new AgendamentoDto(x))
				.collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public AgendamentoDto findById(Long id) {
		Optional<Agendamento> objeto = agendamentoRepository.findById(id);
		Agendamento entidade = objeto.orElseThrow(
				(() -> new ControllerNotFoundException("id")));
		return new AgendamentoDto(entidade);
	}

	@Transactional(readOnly = true)
	public AgendamentoDto insert(AgendamentoDto agendamentoDto) {
		
		Agendamento entidade = new Agendamento();
		entidade.setDataAtendimento(agendamentoDto.getDataAtendimento());
		entidade.setHoraAtendimento(agendamentoDto.getHoraAtendimento());
		entidade.setStatusAgendamento(agendamentoDto.getStatusAgendamento());
		entidade.setPesoPaciente(agendamentoDto.getPesoPaciente());
		entidade = agendamentoRepository.save(entidade);
		return new AgendamentoDto(entidade);
	}

	@Transactional
	public AgendamentoDto update(Long id, AgendamentoDto agendamentoDto) {
		try {
			Agendamento entidade = agendamentoRepository.getReferenceById(id);
			entidade.setDataAtendimento(agendamentoDto.getDataAtendimento());
			entidade.setHoraAtendimento(agendamentoDto.getHoraAtendimento());
			entidade.setStatusAgendamento(agendamentoDto.getStatusAgendamento());
			entidade.setPesoPaciente(agendamentoDto.getPesoPaciente());
			return new AgendamentoDto(entidade);
		} catch (EntityNotFoundException e) {
			throw new ControllerNotFoundException("Id não encontrado");
		}
		
	}

	public void delete(Long id) {
		
		try {
			agendamentoRepository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {
			throw new ControllerNotFoundException("Id não encontrado");
		}
		catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Violação de integridade");
		}
		
	}
	
}
