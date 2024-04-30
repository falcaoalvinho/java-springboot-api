package com.example.SpringDB.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.SpringDB.model.Banda;

@Repository
public class BandaRepository implements ICrud{
	
	public String SELECT = "SELECT * FROM Banda";
	
	public String SELECT_ID = "SELECT * FROM Banda WHERE id = ?";
	
	public String INSERT = "INSERT INTO Banda (nome, anoLancamento) VALUES(?, ?)";
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public List<Banda> lista() {
		return jdbcTemplate.query(SELECT, (rs, rowNum) -> {
			return new Banda(rs.getInt("id"),rs.getString("nome"),rs.getInt("anoLancamento"));
			});
		}

	@Override
	public Banda buscaPorId(int id) {
		// TODO Auto-generated method 
		return null;
	}

	@Override
	public Banda altera(Banda b, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Banda insere(Banda b) {

		return null;
	}


}
