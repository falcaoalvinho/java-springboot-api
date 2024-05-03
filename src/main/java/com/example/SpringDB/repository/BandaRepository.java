package com.example.SpringDB.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.SpringDB.model.Banda;

@Repository
public class BandaRepository implements ICrud{
	
	public String SELECT = "SELECT id, nome, anoLancamento FROM Banda";
	
	public String SELECT_ID = "SELECT id, nome, anoLancamento FROM Banda WHERE id = ?";
	
	public String INSERT = "INSERT INTO Banda (id, nome, anoLancamento) VALUES(default, ?, ?)";
	
	public String UPDATE = "UPDATE banda SET nome = ?, anoLancamento = ? WHERE id = ?";
	
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
		Object[] params = {id};
		
		return jdbcTemplate.queryForObject(SELECT_ID, params, (rs, rowNum) -> {
			return new Banda(rs.getInt("id"),rs.getString("nome"), rs.getInt("anoLancamento"));
		});
	}

	@Override
	public int altera(Banda b, int id) {
		
		Object[] params = {b.getNome(), b.getAnoLancamento(), id};
		
		return jdbcTemplate.update(UPDATE, params);
	}

	@Override
	public int insere(Banda b) {
		Object[] params = {b.getNome(), b.getAnoLancamento()};
		
		return jdbcTemplate.update(INSERT, params);
		
	}


}
