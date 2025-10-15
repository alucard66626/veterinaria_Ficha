package com.example.veterinaria.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.veterinaria.dao.ClienteRepository;
import com.example.veterinaria.dao.pojo.ClientePojo;
import com.example.veterinaria.dao.pojo.MascotaPojo;
import com.example.veterinaria.dto.Clientes;
import com.example.veterinaria.exception.VeterinariaException;
import com.example.veterinaria.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService{


	@Autowired
	private ClienteRepository clienteRepository;

  
	@Override
	public List<Clientes> getClientes() {
		
		

		return clienteRepository.findAll().stream().map(ClientePojo-> new Clientes(
				ClientePojo.getIdCliente(),
				ClientePojo.getNombre(),
				ClientePojo.getApellido(),
				ClientePojo.getTelefono(),
				ClientePojo.getEmail(),
				ClientePojo.getDireccion()
				)).toList();
	}
	
	@Override
	public Clientes getClientesId(int id) {
		
		var ClientePojo = clienteRepository.obtenerClientePorId(id)
											.orElseThrow(
													() -> new VeterinariaException("error"));
		
		return new Clientes(ClientePojo.getIdCliente(),
				ClientePojo.getNombre(),
				ClientePojo.getApellido(),
				ClientePojo.getTelefono(),
				ClientePojo.getEmail(),
				ClientePojo.getDireccion());
	}
	
	
	
	@Override
	public void crearCliente(Clientes clientes) {
		
		clienteRepository.saveAndFlush(
				new ClientePojo(
						clientes.getNombre(),
						clientes.getApellido(),
						clientes.getTelefono(),
						clientes.getEmail(),
						clientes.getDireccion()
				));
	}
	
	@Override
	public ClientePojo crearClienteGet(Clientes clientes) {
		
		
		var clientePojoFind = clienteRepository.findById(clientes.getIdCliente());
		
        if(clientePojoFind.isEmpty()) {	
        	
        	return clienteRepository.saveAndFlush(
    				new ClientePojo(
    						clientes.getNombre(),
    						clientes.getApellido(),
    						clientes.getTelefono(),
    						clientes.getEmail(),
    						clientes.getDireccion()
    				));
        }
		
		return clientePojoFind.get();
	}

	
	
	@Override
	public void editarCliente(Clientes clientes) {
		
		var p = clienteRepository.findById(clientes.getIdCliente());
		
		
        if(p.isEmpty()) {
        	throw new VeterinariaException("error");
        }
		
		clienteRepository.saveAndFlush(
				new ClientePojo(
						clientes.getIdCliente(),
						clientes.getNombre(),
						clientes.getApellido(),
						clientes.getTelefono(),
						clientes.getEmail(),
						clientes.getDireccion()
				));
        
	}
	
	public void eliminar(int id) {
		
		var p = clienteRepository.findById(id);
        if(p.isEmpty()) {
        	throw new VeterinariaException("Clinte no esta registrado");
        }
        	clienteRepository.deleteById(id);
	}


}
