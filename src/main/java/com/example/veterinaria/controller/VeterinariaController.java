package com.example.veterinaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.veterinaria.dto.Clientes;
import com.example.veterinaria.dto.Consultas;
import com.example.veterinaria.dto.Mascotas;
import com.example.veterinaria.dto.Veterinarios;
import com.example.veterinaria.service.ClienteService;
import com.example.veterinaria.service.ConsultaService;
import com.example.veterinaria.service.MascotaService;
import com.example.veterinaria.service.VeterinarioService;



@RestController
@RequestMapping("/veterinaria")
public class VeterinariaController {

	@Autowired
	public ClienteService clienteService;
	
	@Autowired
	public MascotaService  mascotaService;
	
	@Autowired
	public VeterinarioService veterinarioService;
	
	@Autowired
	public ConsultaService  consultaService;
	
//Cliente
	
	@GetMapping(value = "/cliente/listar")
	public ResponseEntity <List<Clientes>> getClientes() {
		 return ResponseEntity.ok(clienteService.getClientes());
	}
	
	@GetMapping(value = "/cliente/{id}")
	public Clientes getClienteId(@PathVariable int id){
		return clienteService.getClientesId(id);
	}
	
	@PostMapping(value="/cliente/crear")
	public void nuevoClinete(@RequestBody Clientes clientes) {
		clienteService.crearCliente(clientes);
	}
	
	@PutMapping(value="/cliente/editar")
	public void editarCliente(@RequestBody Clientes clientes) {
		clienteService.editarCliente(clientes);
	}
	
	@DeleteMapping (value = "/cliente/eliminar/{id}")
	public void EliminarCliente(@PathVariable int id) {
		clienteService.eliminar(id);
	}
	
	//Mascota
	@GetMapping(value = "/mascota/listar")
	public ResponseEntity <List<Mascotas>> getMascotas() {
		 return ResponseEntity.ok(mascotaService.getMacotas());
	}
	
	
	@GetMapping(value = "/mascota/{id}")
	public Mascotas getMascotaId(@PathVariable int id){
		return mascotaService.getMascotasId(id);
	}
	
	@PostMapping(value="/mascota/crear")
	public void nuevoClinete(@RequestBody Mascotas mascotas) {
		mascotaService.crearMascota(mascotas);
	}
	
	@PutMapping(value="/mascota/editar")
	public void editarCliente(@RequestBody Mascotas mascotas) {
		mascotaService.editarMascota(mascotas);
	}
	
	@DeleteMapping (value = "/mascota/eliminar/{id}")
	public void EliminarMascotas(@PathVariable int id) {
		mascotaService.eliminar(id);
	}
	
	//Veterinario
	
	@GetMapping(value = "/veterinario/listar")
	public ResponseEntity <List<Veterinarios>> getVeterinarios() {
		 return ResponseEntity.ok(veterinarioService.getVeterinarios());
	}
	
	
	@GetMapping(value = "/veterinario/{id}")
	public Veterinarios getVeterinarioId(@PathVariable int id){
		return veterinarioService.getVeterinarioId(id);
	}
	
	@PostMapping(value="/veterinario/crear")
	public void nuevoClinete(@RequestBody Veterinarios veterinarios) {
		veterinarioService.crearVeterinario(veterinarios);
	}
	
	@PutMapping(value="/veterinario/editar")
	public void editarCliente(@RequestBody Veterinarios veterinarios) {
		veterinarioService.editarVeterinario(veterinarios);
	}
	
	@DeleteMapping (value = "/veterinario/eliminar/{id}")
	public void EliminarVeterinario(@PathVariable int id) {
		veterinarioService.eliminar(id);
	}
	
	//Consulta
	
	
	
	@GetMapping(value = "/consulta/listar")
	public ResponseEntity <List<Consultas>> getConsultas() {
		 return ResponseEntity.ok(consultaService.getConsultas());
	}
	
	
	@GetMapping(value = "/consulta/{id}")
	public Consultas getConsultaId(@PathVariable int id){
		return consultaService.getConsultaId(id);
	}
	
	@PostMapping(value="/consulta/crear")
	public void nuevoClinete(@RequestBody Consultas consultas) {
		consultaService.crearConsulta(consultas);
	}
	
	@PutMapping(value="/consulta/editar")
	public void editarCliente(@RequestBody Consultas consultas) {
		consultaService.editarConsulta(consultas);
	}
	
	@DeleteMapping (value = "/consulta/eliminar/{id}")
	public void EliminarConsulta(@PathVariable int id) {
		consultaService.eliminar(id);
	}
	
}
