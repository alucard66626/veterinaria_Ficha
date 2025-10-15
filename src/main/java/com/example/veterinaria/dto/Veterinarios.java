package com.example.veterinaria.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Id;

public class Veterinarios {

	
	private  int idVeterinario;
	private  String nombre;
	private  String apellido;
	private  String especialidad;
	private  String telefono;
	private  String email;
	public Veterinarios(int idVeterinario, String nombre, String apellido, String especialidad, String telefono,
			String email) {
		super();
		this.idVeterinario = idVeterinario;
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidad = especialidad;
		this.telefono = telefono;
		this.email = email;
	}
	public Veterinarios(String nombre, String apellido, String especialidad, String telefono, String email) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.especialidad = especialidad;
		this.telefono = telefono;
		this.email = email;
	}
	
	
	
	public Veterinarios() {
		super();
	}
	public int getIdVeterinario() {
		return idVeterinario;
	}
	public void setIdVeterinario(int idVeterinario) {
		this.idVeterinario = idVeterinario;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
