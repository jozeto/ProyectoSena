package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceService.IinventarioService;
import com.example.demo.interfaces.Iinventario;
import com.example.demo.modelo.Inventario;
import com.example.demo.modelo.Login;

@Service
public class InventarioService implements IinventarioService{
	
	@Autowired
	private Iinventario data;

	@Override
	public List<Inventario> listarr() {		
		return (List<Inventario>)data.findAll();
	}

	@Override
	public Optional<Inventario> listarId(int id) {
		// TODO Auto-generated method stub
		return data.findById(id);
	}

	@Override
	public int save(Inventario p) {
		int res=0;
		Inventario empleado=data.save(p);
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
	public int save1(Inventario p) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int save(Login p) {
		// TODO Auto-generated method stub
		return 0;
	}

}