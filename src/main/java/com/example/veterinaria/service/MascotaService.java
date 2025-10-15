package com.example.veterinaria.service;

import java.util.List;

import com.example.veterinaria.dto.Mascotas;

public interface MascotaService {
	List<Mascotas> getMacotas();
	Mascotas getMascotasId(int id);
	void crearMascota(Mascotas mascotas);
	void editarMascota(Mascotas mascotas);
	void eliminar(int id);
}
