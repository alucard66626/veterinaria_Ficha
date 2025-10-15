package com.example.veterinaria.dao.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity(name = "Veterinarios")
public class VeterinarioPojo {

	
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Id  int IdVeterinario;
	private @Column  String Nombre;
	private @Column  String Apellido;
	private @Column String Especialidad;
	private @Column String Telefono;
	private @Column String Email;
	
	public VeterinarioPojo(int idVeterinario, String nombre, String apellido, String especialidad, String telefono,
			String email) {
		super();
		IdVeterinario = idVeterinario;
		Nombre = nombre;
		Apellido = apellido;
		Especialidad = especialidad;
		Telefono = telefono;
		Email = email;
	}
	public VeterinarioPojo(String nombre, String apellido, String especialidad, String telefono, String email) {
		super();
		Nombre = nombre;
		Apellido = apellido;
		Especialidad = especialidad;
		Telefono = telefono;
		Email = email;
	}

	
	public VeterinarioPojo() {
		super();
	}
	public int getIdVeterinario() {
		return IdVeterinario;
	}
	public void setIdVeterinario(int idVeterinario) {
		IdVeterinario = idVeterinario;
	}
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	public String getApellido() {
		return Apellido;
	}
	public void setApellido(String apellido) {
		Apellido = apellido;
	}
	public String getEspecialidad() {
		return Especialidad;
	}
	public void setEspecialidad(String especialidad) {
		Especialidad = especialidad;
	}
	public String getTelefono() {
		return Telefono;
	}
	public void setTelefono(String telefono) {
		Telefono = telefono;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}

}
