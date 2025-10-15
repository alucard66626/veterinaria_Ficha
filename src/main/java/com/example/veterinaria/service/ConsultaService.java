package com.example.veterinaria.service;

import java.util.List;

import com.example.veterinaria.dto.Clientes;
import com.example.veterinaria.dto.Consultas;


public interface ConsultaService {
	List<Consultas>getConsultas();
	Consultas getConsultaId(int id);
	void crearConsulta(Consultas consultas);
	void editarConsulta(Consultas consultas);
	void eliminar(int id);
}
