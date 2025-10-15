package com.example.veterinaria.service;

import java.util.List;

import com.example.veterinaria.dto.Clientes;
import com.example.veterinaria.dto.Veterinarios;

public interface VeterinarioService {
	List<Veterinarios>getVeterinarios();
	Veterinarios getVeterinarioId(int id);
	void crearVeterinario(Veterinarios veterinarios);
	void editarVeterinario(Veterinarios veterinarios);
	void eliminar(int id);
}
