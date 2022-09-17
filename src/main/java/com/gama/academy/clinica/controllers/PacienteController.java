package com.gama.academy.clinica.controllers;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gama.academy.clinica.model.Paciente;
import com.gama.academy.clinica.service.PacienteService;

@RestController
@RequestMapping(value = "/pacientes")
public class PacienteController {

	@Autowired
	private PacienteService service;

	@GetMapping
	public ResponseEntity<List<Paciente>> getAll() {
		return ResponseEntity.ok(service.getAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {

		Paciente p = service.findById(id);

		if (!Objects.isNull(p)) {
			return ResponseEntity.ok(service.findById(id));
		}
		return ResponseEntity.badRequest().body("Objeto não Encontrado");
	}

	@PostMapping
	public ResponseEntity<Paciente> save(@RequestBody Paciente p) {
		return ResponseEntity.ok(service.save(p));
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Paciente paciente) {

		Paciente p = service.update(id, paciente);

		if (!Objects.isNull(p)) {
			return ResponseEntity.ok(p);
		}

		return ResponseEntity.badRequest().body("Objeto não Encontrado");
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<String> delete(Long id) {
		String msg = service.delete(id);
		return ResponseEntity.ok(msg);
	}

}
