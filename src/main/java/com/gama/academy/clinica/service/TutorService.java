package com.gama.academy.clinica.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gama.academy.clinica.model.Tutor;
import com.gama.academy.clinica.repository.TutorRepository;

@Service
public class TutorService {

	@Autowired
	private TutorRepository tutorRepository;
	

	public ArrayList<Tutor> getAll(){
		return (ArrayList<Tutor>) tutorRepository.findAll();
	}
	
	public Tutor getById(Long id){
		return tutorRepository.findById(id).orElse(null);
	}
	
	public Tutor save(Tutor tutor) {
		return tutorRepository.save(tutor);
	}
	
	public Tutor update(Long id, Tutor tutor) {
		Tutor tutorAtualizar = getById(id);
		
		if(tutorAtualizar != null) {
//			tutor.setId(id);
			return save(tutor);
		}
		return null;
	}
	
	
	public String delete(Long id) {
		
		Tutor tutor = getById(id);
		
		if(tutor != null) {
			tutorRepository.deleteById(id);	
			return "Objeto Excluido";
		}
		return "Objeto Não Encontrado";
		
	}
	
	
	
	
	
}
