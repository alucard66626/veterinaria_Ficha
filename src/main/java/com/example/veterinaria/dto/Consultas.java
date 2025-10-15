package com.example.veterinaria.dto;

public class Consultas {

	private int idConsulta;
	//private String idMascota;
	private Mascotas mascota;
	//private String idVeterinario;
	private Veterinarios veterinario;
	private String fechaConsulta;
	private String motivo;
	private String diagnostico;
	private String tratamiento;
	private String proximaCita;
	public Consultas(int idConsulta, Mascotas mascota, Veterinarios veterinario, String fechaConsulta,
			String motivo, String diagnostico, String tratamiento, String proximaCita) {
		super();
		this.idConsulta = idConsulta;
		this.mascota = mascota;
		this.veterinario = veterinario;
		this.fechaConsulta = fechaConsulta;
		this.motivo = motivo;
		this.diagnostico = diagnostico;
		this.tratamiento = tratamiento;
		this.proximaCita = proximaCita;
	}
	public Consultas(Mascotas mascota, Veterinarios veterinario, String fechaConsulta, String motivo,
			String diagnostico, String tratamiento, String proximaCita) {
		super();
		this.mascota = mascota;
		this.veterinario = veterinario;
		this.fechaConsulta = fechaConsulta;
		this.motivo = motivo;
		this.diagnostico = diagnostico;
		this.tratamiento = tratamiento;
		this.proximaCita = proximaCita;
	}
	public Consultas() {
		super();
	}
	public int getIdConsulta() {
		return idConsulta;
	}
	public void setIdConsulta(int idConsulta) {
		this.idConsulta = idConsulta;
	}
	public Mascotas getMascota() {
		return mascota;
	}
	public void setMascota(Mascotas mascota) {
		this.mascota = mascota;
	}
	public Veterinarios getVeterinario() {
		return veterinario;
	}
	public void setVeterinario(Veterinarios veterinario) {
		this.veterinario = veterinario;
	}
	public String getFechaConsulta() {
		return fechaConsulta;
	}
	public void setFechaConsulta(String fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	public String getProximaCita() {
		return proximaCita;
	}
	public void setProximaCita(String proximaCita) {
		this.proximaCita = proximaCita;
	}
	
	
	
	
	
}
