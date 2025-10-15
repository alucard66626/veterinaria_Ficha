package com.example.veterinaria.service;

import java.util.List;

import com.example.veterinaria.dao.pojo.ClientePojo;
import com.example.veterinaria.dto.Clientes;



public interface ClienteService {
	List<Clientes>getClientes();
	Clientes getClientesId(int id);
	void crearCliente(Clientes clientes);
	ClientePojo crearClienteGet(Clientes clientes);
	void editarCliente(Clientes clientes);
	void eliminar(int id);
}
