package com.gama.academy.clinica.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gama.academy.clinica.model.Tutor;
import com.gama.academy.clinica.repository.TutorRepository;

@Service
public class TutorService {

	@Autowired
	private TutorRepository tutorRepository;
	
	public Tutor save(Tutor tutor) {
		return tutorRepository.save(tutor);
	}
	
	public List<Tutor> getAll(){
		return tutorRepository.findAll();
	}
}
