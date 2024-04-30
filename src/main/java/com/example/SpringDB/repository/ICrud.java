package com.example.SpringDB.repository;

import java.util.List;

import com.example.SpringDB.model.Banda;

public interface ICrud{

	public List<Banda> lista();
	
	public Banda buscaPorId(int id);
		
	public Banda altera(Banda b, int id);

	public Banda insere(Banda b);
}
