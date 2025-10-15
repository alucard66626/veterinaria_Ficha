package com.example.veterinaria.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.veterinaria.dao.VeterinarioRepository;
import com.example.veterinaria.dao.pojo.VeterinarioPojo;
import com.example.veterinaria.dto.Veterinarios;
import com.example.veterinaria.exception.VeterinariaException;
import com.example.veterinaria.service.VeterinarioService;

@Service
public class VeterinarioServiceImpl implements VeterinarioService {
	
	@Autowired
	private VeterinarioRepository  veterinarioRepository ;

	@Override
	public List<Veterinarios> getVeterinarios() {

		return veterinarioRepository.findAll().stream().map(pojoVeterinario -> new Veterinarios(
				pojoVeterinario.getIdVeterinario(),
				pojoVeterinario.getNombre(),
				pojoVeterinario.getApellido(),
				pojoVeterinario.getEspecialidad(),
				pojoVeterinario.getTelefono(),
				pojoVeterinario.getEmail()
				)).toList();
		
	}

	@Override
	public Veterinarios getVeterinarioId(int id) {
		
		VeterinarioPojo veterinarioPojo =  veterinarioRepository.findById(id).orElseThrow(
				() -> new VeterinariaException("error"));
		
		
		return new Veterinarios(
				veterinarioPojo.getIdVeterinario(),
				veterinarioPojo.getNombre(),
				veterinarioPojo.getApellido(),
				veterinarioPojo.getEspecialidad(),
				veterinarioPojo.getTelefono(),
				veterinarioPojo.getEmail()
				);
	}

	@Override
	public void crearVeterinario(Veterinarios veterinarios) {
		
		veterinarioRepository.saveAndFlush(
				new VeterinarioPojo(
						veterinarios.getNombre(),
						veterinarios.getApellido(),
						veterinarios.getEspecialidad(),
						veterinarios.getTelefono(),
						veterinarios.getEmail()
						)
				);
		
	}

	@Override
	public void editarVeterinario(Veterinarios veterinarios) {
		
		var veterinarioPojo =  veterinarioRepository.findById(veterinarios.getIdVeterinario());
		
        if(veterinarioPojo.isEmpty()) {
        	throw new VeterinariaException("Cliente no encontrado");
        }
		
		veterinarioRepository.saveAndFlush(
				new VeterinarioPojo(
						veterinarios.getIdVeterinario(),
						veterinarios.getNombre(),
						veterinarios.getApellido(),
						veterinarios.getEspecialidad(),
						veterinarios.getTelefono(),
						veterinarios.getEmail()
						)
				);
	}

	@Override
	public void eliminar(int id) {
		
		
		var veterinarioPojo =  veterinarioRepository.findById(id);
		
        if(veterinarioPojo.isEmpty()) {
        	throw new VeterinariaException("Cliente no encontrado");
        }
        
        veterinarioRepository.deleteById(id);
		
	}

}
