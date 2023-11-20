package com.example.demo.service.api;

import java.io.ByteArrayInputStream;

import com.example.demo.commons.GenericServiceAPI;
import com.example.demo.modelo.Persona;

public interface PersonaServiceAPI extends GenericServiceAPI<Persona, Long>  {
	
	
	ByteArrayInputStream exportAllData() throws Exception;
	
}
