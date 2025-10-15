package com.example.veterinaria.service.impl;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.veterinaria.dao.ClienteRepository;
import com.example.veterinaria.dao.MacotaRepository;
import com.example.veterinaria.dao.pojo.ClientePojo;
import com.example.veterinaria.dao.pojo.MascotaPojo;
import com.example.veterinaria.dto.Clientes;
import com.example.veterinaria.dto.Mascotas;
import com.example.veterinaria.exception.VeterinariaException;
import com.example.veterinaria.service.ClienteService;
import com.example.veterinaria.service.MascotaService;

@Service
public class MascotaServiceImpl implements MascotaService {

	
	@Autowired
	private MacotaRepository  macotaRepository;
	
	@Autowired
	private ClienteService clienteService;

	
	
	@Override
	public List<Mascotas> getMacotas() {
	
		return macotaRepository.findAll().stream().map(MascotaPojo-> new Mascotas (
				MascotaPojo.getIdMascota(),
				MascotaPojo.getNombre(),
				MascotaPojo.getEspecie(),
				MascotaPojo.getRaza(),
				MascotaPojo.getFechaNacimiento(),
				MascotaPojo.getSexo(),
				new Clientes(
						MascotaPojo.getClientePojo().getIdCliente(),
						MascotaPojo.getClientePojo().getNombre(),
						MascotaPojo.getClientePojo().getApellido(),
						MascotaPojo.getClientePojo().getTelefono(),
						MascotaPojo.getClientePojo().getEmail(),
						MascotaPojo.getClientePojo().getDireccion()
						)
				)).toList();
		
		

	}


	@Override
	public Mascotas getMascotasId(int id) {
	

		MascotaPojo MascotasPojo =macotaRepository.findById(id).orElseThrow(
				() -> new VeterinariaException("error"));
	
		return new Mascotas (
				MascotasPojo.getIdMascota(),
				MascotasPojo.getNombre(),
				MascotasPojo.getEspecie(),
				MascotasPojo.getRaza(),
				MascotasPojo.getFechaNacimiento(),
				MascotasPojo.getSexo(),
				new Clientes(
						MascotasPojo.getClientePojo().getIdCliente(),
						MascotasPojo.getClientePojo().getNombre(),
						MascotasPojo.getClientePojo().getApellido(),
						MascotasPojo.getClientePojo().getTelefono(),
						MascotasPojo.getClientePojo().getEmail(),
						MascotasPojo.getClientePojo().getDireccion()
						)
				);
	}


	@Override
	public void crearMascota(Mascotas mascotas) {
		
		ClientePojo clientePojo = clienteService.crearClienteGet(mascotas.getCliente());
	
		macotaRepository.saveAndFlush(
				new MascotaPojo(
						mascotas.getNombre(),
						mascotas.getEspecie(),
						mascotas.getRaza(),
						mascotas.getFechaNacimiento(),
						mascotas.getSexo(),
						clientePojo
						)
				);
	}
	



	@Override
	public void editarMascota(Mascotas mascotas) {
		
		var p =  macotaRepository.findById(mascotas.getIdMascota());
		
		if( p.isEmpty()) {
			throw new VeterinariaException("Macota no registrada");
		}
		
		macotaRepository.saveAndFlush(
				new MascotaPojo(
						mascotas.getIdMascota(),
						mascotas.getNombre(),
						mascotas.getEspecie(),
						mascotas.getRaza(),
						mascotas.getFechaNacimiento(),
						mascotas.getSexo(),
						new ClientePojo(
								mascotas.getCliente().getIdCliente(),
								mascotas.getCliente().getNombre(),
								mascotas.getCliente().getApellido(),
								mascotas.getCliente().getTelefono(),
								mascotas.getCliente().getEmail(),
								mascotas.getCliente().getDireccion()
						)
						)
				);
		
		
	}


	@Override
	public void eliminar(int id) {
		
		var p =  macotaRepository.findById(id);
		
		if( p.isEmpty()) {
			throw new VeterinariaException("Macota no registrada");
		}
		
		macotaRepository.deleteById(id);
		
	}

	
	
	
	
}
