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
@Entity(name = "Consultas")
public class ConsultaPojo {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private @Id int IdConsulta;
	
	//private @Column String IdMascota;
	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "IdMascota")
	private MascotaPojo mascotaPojo;
	
	//private @Column String IdVeterinario;
	  @ManyToOne(fetch = FetchType.LAZY)
	  @JoinColumn(name = "IdVeterinario")
	  private VeterinarioPojo veterinarioPojo;
	
	
	private @Column String FechaConsulta;
	private @Column String Motivo;
	private @Column String Diagnostico;
	private @Column String Tratamiento;
	private @Column String ProximaCita;
	
	public ConsultaPojo(int idConsulta, MascotaPojo mascotaPojo, VeterinarioPojo veterinarioPojo, String fechaConsulta,
			String motivo, String diagnostico, String tratamiento, String proximaCita) {
		super();
		IdConsulta = idConsulta;
		this.mascotaPojo = mascotaPojo;
		this.veterinarioPojo = veterinarioPojo;
		FechaConsulta = fechaConsulta;
		Motivo = motivo;
		Diagnostico = diagnostico;
		Tratamiento = tratamiento;
		ProximaCita = proximaCita;
	}
	public ConsultaPojo(MascotaPojo mascotaPojo, VeterinarioPojo veterinarioPojo, String fechaConsulta, String motivo,
			String diagnostico, String tratamiento, String proximaCita) {
		super();
		this.mascotaPojo = mascotaPojo;
		this.veterinarioPojo = veterinarioPojo;
		FechaConsulta = fechaConsulta;
		Motivo = motivo;
		Diagnostico = diagnostico;
		Tratamiento = tratamiento;
		ProximaCita = proximaCita;
	}
	public ConsultaPojo() {
		super();
	}
	public int getIdConsulta() {
		return IdConsulta;
	}
	public void setIdConsulta(int idConsulta) {
		IdConsulta = idConsulta;
	}
	public MascotaPojo getMascotaPojo() {
		return mascotaPojo;
	}
	public void setMascotaPojo(MascotaPojo mascotaPojo) {
		this.mascotaPojo = mascotaPojo;
	}
	public VeterinarioPojo getVeterinarioPojo() {
		return veterinarioPojo;
	}
	public void setVeterinarioPojo(VeterinarioPojo veterinarioPojo) {
		this.veterinarioPojo = veterinarioPojo;
	}
	public String getFechaConsulta() {
		return FechaConsulta;
	}
	public void setFechaConsulta(String fechaConsulta) {
		FechaConsulta = fechaConsulta;
	}
	public String getMotivo() {
		return Motivo;
	}
	public void setMotivo(String motivo) {
		Motivo = motivo;
	}
	public String getDiagnostico() {
		return Diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		Diagnostico = diagnostico;
	}
	public String getTratamiento() {
		return Tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		Tratamiento = tratamiento;
	}
	public String getProximaCita() {
		return ProximaCita;
	}
	public void setProximaCita(String proximaCita) {
		ProximaCita = proximaCita;
	}
	
	
}
