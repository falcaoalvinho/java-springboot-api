package com.example.SpringDB.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SpringDB.model.Banda;
import com.example.SpringDB.repository.BandaRepository;

@RestController
@RequestMapping("/banda")
public class BandaController {
	
	@Autowired
	BandaRepository repository;
	
	@GetMapping()
	public String ListaBandas() {
		String tmp = "";
		for (Banda banda : repository.lista()) {
			tmp += banda.getNome();
			tmp += "\n";
		}
		return tmp;	
	}
	
	@GetMapping("/{id}")
	public String ListaPorId(@PathVariable int id) {
		return repository.buscaPorId(id).getNome();
	}
	
	@PutMapping("/{id}")
	public String AlteraPorId(@RequestBody Banda banda, @PathVariable int id ) {
		return String.valueOf(repository.altera(banda, id));
	}
}
