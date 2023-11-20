package com.example.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Inventario;
import com.example.demo.modelo.Login;


	public interface IinventarioService {
		public List<Inventario>listarr();
		public Optional<Inventario>listarId(int id);
		public int save(Login p);
		public void delete(int id);
		int save(Inventario p);
		int save1(Inventario p);
	}

