package com.example.demo.interfaceService;

import java.util.List;
import java.util.Optional;
import com.example.demo.modelo.Login;
import com.example.demo.modelo.compras;
import com.registro.usuarios.controlador.dto.UsuarioRegistroDTO;
import com.registro.usuarios.modelo.Usuario;


	public interface IcomprasService {
		public List<compras>listarr();
		public Optional<compras>listarId(int id);
		public int save(Usuario p);
		public void delete(int id);
		int save(Login p);
		public void search(int id);
		int save(compras p);
	}

