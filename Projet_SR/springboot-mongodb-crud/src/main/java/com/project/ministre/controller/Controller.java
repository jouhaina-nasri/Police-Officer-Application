package com.project.ministre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.ministre.exception.ResourceNotFoundException;
import com.project.ministre.model.Citoyen;
import com.project.ministre.repository.CitoyenRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/api/v1")
public class Controller {
	@Autowired
	private CitoyenRepository CitoyenRepository;


	@GetMapping("/citoyen/{id}")
	public ResponseEntity<Citoyen> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws ResourceNotFoundException {
		Citoyen employee = CitoyenRepository.findById(employeeId)
				.orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + employeeId));
		return ResponseEntity.ok().body(employee);
	}

	@PostMapping("/citoyen")
	public Citoyen createEmployee(@RequestBody Citoyen newEmployee) {
		return CitoyenRepository.save(newEmployee);
	}
	
}
