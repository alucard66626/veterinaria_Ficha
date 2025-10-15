package com.example.veterinaria.dao.pojo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table
@Entity(name = "Mascotas")
public class MascotaPojo {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Id int IdMascota;
	private @Column String Nombre;
	private @Column String Especie;
	private @Column String Raza;
	private @Column String FechaNacimiento;
	private @Column String Sexo;
	
	// private @Column int IdCliente;
	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "IdCliente")
	  private ClientePojo ClientePojo; 
	
	
	public MascotaPojo(int idMascota, String nombre, String especie, String raza, String fechaNacimiento,
			String sexo) {
		super();
		IdMascota = idMascota;
		Nombre = nombre;
		Especie = especie;
		Raza = raza;
		FechaNacimiento = fechaNacimiento;
		Sexo = sexo;
	}

	
	
	
	public MascotaPojo(String nombre, String especie, String raza, String fechaNacimiento, String sexo,
			com.example.veterinaria.dao.pojo.ClientePojo clientePojo) {
		super();
		Nombre = nombre;
		Especie = especie;
		Raza = raza;
		FechaNacimiento = fechaNacimiento;
		Sexo = sexo;
		ClientePojo = clientePojo;
	}




	public MascotaPojo(int idMascota, String nombre, String especie, String raza, String fechaNacimiento, String sexo,
			com.example.veterinaria.dao.pojo.ClientePojo clientePojo) {
		super();
		IdMascota = idMascota;
		Nombre = nombre;
		Especie = especie;
		Raza = raza;
		FechaNacimiento = fechaNacimiento;
		Sexo = sexo;
		ClientePojo = clientePojo;
	}




	public MascotaPojo() {
		super();
	}

	public int getIdMascota() {
		return IdMascota;
	}

	public void setIdMascota(int idMascota) {
		IdMascota = idMascota;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getEspecie() {
		return Especie;
	}

	public void setEspecie(String especie) {
		Especie = especie;
	}

	public String getRaza() {
		return Raza;
	}

	public void setRaza(String raza) {
		Raza = raza;
	}

	public String getFechaNacimiento() {
		return FechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		FechaNacimiento = fechaNacimiento;
	}

	public String getSexo() {
		return Sexo;
	}

	public void setSexo(String sexo) {
		Sexo = sexo;
	}

	public ClientePojo getClientePojo() {
		return ClientePojo;
	}

	public void setClientePojo(ClientePojo clientePojo) {
		ClientePojo = clientePojo;
	}
	
	
}
