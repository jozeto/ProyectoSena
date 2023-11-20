package com.example.demo.service.impl;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.example.demo.commons.GenericServiceImpl;
import com.example.demo.dao.api.PersonaDaoAPI;
import com.example.demo.modelo.Persona;
import com.example.demo.service.api.PersonaServiceAPI;

@Service
public class PersonaServiceImpl extends GenericServiceImpl<Persona, Long> implements PersonaServiceAPI {

	@Autowired
	private PersonaDaoAPI personaDaoAPI;

	@Override
	public CrudRepository<Persona, Long> getDao() {
		return personaDaoAPI;
	}

	@Override
	public ByteArrayInputStream exportAllData() throws Exception {
		String[] columns = { "Id", "Nombre", "Apellido" };

		Workbook workbook = new HSSFWorkbook();
		ByteArrayOutputStream stream = new ByteArrayOutputStream();

		Sheet sheet = workbook.createSheet("Personas");
		Row row = sheet.createRow(0);

		for (int i = 0; i < columns.length; i++) {
			Cell cell = row.createCell(i);
			cell.setCellValue(columns[i]);
		}

		List<Persona> personas = this.getAll();
		int initRow = 1;
		for (Persona persona : personas) {
			row = sheet.createRow(initRow);
			row.createCell(0).setCellValue(persona.getId());
			row.createCell(1).setCellValue(persona.getName());
			row.createCell(2).setCellValue(persona.getApellido());
		

			initRow++;
		}

		workbook.write(stream);
		workbook.close();
		return new ByteArrayInputStream(stream.toByteArray());
	}

}
