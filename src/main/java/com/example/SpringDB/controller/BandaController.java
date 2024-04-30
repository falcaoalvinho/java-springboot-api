package com.example.SpringDB.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringDB.model.Banda;
import com.example.SpringDB.repository.BandaRepository;

@RestController
@RequestMapping("/banda")
public class BandaController {
	
	@Autowired
	BandaRepository repository;
	
	@GetMapping("/lista")
	public String ListaBandas() {
		return repository.lista().get(0).getNome();
	}
}
