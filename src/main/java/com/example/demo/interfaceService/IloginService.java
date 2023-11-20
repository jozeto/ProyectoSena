package com.example.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.example.demo.modelo.Login;

public interface IloginService {
	public List<Login>listarr();
	public Optional<Login>listarId(int id);
	public int save(Login p);
	public void delete(int id);
}
