package com.example.SpringDB.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "/bandas")
public class Banda {

	public Banda(Integer id, String nome, int anoLancamento) {
		super();
		this.id = id;
		this.nome = nome;
		this.anoLancamento = anoLancamento;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private int anoLancamento;
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getAnoLancamento() {
		return anoLancamento;
	}
	
	public void setAnoLancamento(int anoLancamento) {
		this.anoLancamento = anoLancamento;
	}
}
