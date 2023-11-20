package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceService.IcomprasService;
import com.example.demo.interfaces.Icompras;
import com.example.demo.modelo.compras;
import com.registro.usuarios.modelo.Usuario;
import com.example.demo.modelo.Login;

@Service
public class ComprasService implements IcomprasService{
	
	@Autowired
	private Icompras data;

	@Override
	public List<compras> listarr() {		
		return (List<compras>)data.findAll();
	}

	@Override
	public Optional<compras> listarId(int id) {
		// TODO Auto-generated method stub
		return data.findById(id);
	}

	@Override
	public int save(compras p) {
		int res=0;
		compras empleado=data.save(p);
		if(!empleado.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public int save(Login p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void search(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int save(Usuario p) {
		// TODO Auto-generated method stub
		return 0;
	}

}