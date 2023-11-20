package com.example.demo.dao.api;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.modelo.Persona;

public interface PersonaDaoAPI extends CrudRepository<Persona, Long> {

	
}
