package com.example.veterinaria.dto;

public class Mascotas {
	
	private int idMascota;
	private String nombre;
	private String especie;
	private String raza;
	private String fechaNacimiento;
	private String sexo;
	
	private Clientes cliente;
	
	
	public Mascotas(int idMascota, String nombre, String especie, String raza, String fechaNacimiento, String sexo) {
		super();
		this.idMascota = idMascota;
		this.nombre = nombre;
		this.especie = especie;
		this.raza = raza;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
	}

	

	public Mascotas(int idMascota, String nombre, String especie, String raza, String fechaNacimiento, String sexo,
			Clientes cliente) {
		super();
		this.idMascota = idMascota;
		this.nombre = nombre;
		this.especie = especie;
		this.raza = raza;
		this.fechaNacimiento = fechaNacimiento;
		this.sexo = sexo;
		this.cliente = cliente;
	}



	public Mascotas() {
		super();
	}



	public int getIdMascota() {
		return idMascota;
	}


	public void setIdMascota(int idMascota) {
		this.idMascota = idMascota;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getEspecie() {
		return especie;
	}


	public void setEspecie(String especie) {
		this.especie = especie;
	}


	public String getRaza() {
		return raza;
	}


	public void setRaza(String raza) {
		this.raza = raza;
	}


	public String getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public String getSexo() {
		return sexo;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}



	public Clientes getCliente() {
		return cliente;
	}



	public void setCliente(Clientes cliente) {
		this.cliente = cliente;
	}
	
	
}
