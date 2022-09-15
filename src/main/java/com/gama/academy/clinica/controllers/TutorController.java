package com.gama.academy.clinica.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.gama.academy.clinica.model.Tutor;
import com.gama.academy.clinica.service.TutorService;

@RestController()
@RequestMapping(value = "clinica/tutores")
public class TutorController {

	@Autowired
	private TutorService tutorService;

	@PostMapping
	public ResponseEntity<?> save(@RequestBody Tutor tutor) {

		Tutor t = tutorService.save(tutor);

		if (tutor != null) {
			return ResponseEntity.ok(t);
		}
		// Não é esta a resposta
		return ResponseEntity.noContent().build();

	}

	@GetMapping
	public ResponseEntity<List<Tutor>> getAll() {

		List<Tutor> tutores = tutorService.getAll();

		return ResponseEntity.ok(tutores);

	}

}
