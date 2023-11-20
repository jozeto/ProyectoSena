package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.interfaceService.IloginService;
import com.example.demo.interfaces.Ilogin;
import com.example.demo.modelo.Login;

@Service
public class LoginService implements IloginService{
	
	@Autowired
	private Ilogin data;

	@Override
	public List<Login> listarr() {		
		return (List<Login>)data.findAll();
	}

	@Override
	public Optional<Login> listarId(int id) {
		// TODO Auto-generated method stub
		return data.findById(id);
	}

	@Override
	public int save(Login p) {
		int res=0;
		Login empleado=data.save(p);
		if(!empleado.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

}


