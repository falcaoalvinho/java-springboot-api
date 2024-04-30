package com.example.SpringDB;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringDbApplication implements CommandLineRunner{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDbApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		String sql = "INSERT INTO Banda(nome, anoLancamento) VALUES(?, ?)";
		
		int result = jdbcTemplate.update(sql, "Djavú", 2000);
		
		if (result > 0) {
			System.out.println("Um novo registro foi gerado no banco");
		}
	}

}
