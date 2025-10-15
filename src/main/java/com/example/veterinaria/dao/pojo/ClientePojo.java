package com.example.veterinaria.dao.pojo;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table
@Entity(name = "Clientes")
public class ClientePojo {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Id int IdCliente;
	private @Column String Nombre;
	private @Column String Apellido;
	private @Column String Telefono;
	private @Column String Email;
	private @Column String Direccion;
	
	
	
	
	public ClientePojo( String nombre, String apellido, String telefono, String email, String direccion) {
		Nombre = nombre;
		Apellido = apellido;
		Telefono = telefono;
		Email = email;
		Direccion = direccion;
	}
	
	
	
	
	public ClientePojo(int idCliente, String nombre, String apellido, String telefono, String email, String direccion) {
		super();
		IdCliente = idCliente;
		Nombre = nombre;
		Apellido = apellido;
		Telefono = telefono;
		Email = email;
		Direccion = direccion;
	}




	public ClientePojo() {
		super();
	}




	public int getIdCliente() {
		return IdCliente;
	}
	public void setIdCliente(int idCliente) {
		IdCliente = idCliente;
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
	public String getDireccion() {
		return Direccion;
	}
	public void setDireccion(String direccion) {
		Direccion = direccion;
	}
	
}
