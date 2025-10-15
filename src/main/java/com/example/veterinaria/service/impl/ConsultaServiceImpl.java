package com.example.veterinaria.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.veterinaria.dao.ConsultaRepository;
import com.example.veterinaria.dao.pojo.ClientePojo;
import com.example.veterinaria.dao.pojo.ConsultaPojo;
import com.example.veterinaria.dao.pojo.MascotaPojo;
import com.example.veterinaria.dao.pojo.VeterinarioPojo;
import com.example.veterinaria.dto.Clientes;
import com.example.veterinaria.dto.Consultas;
import com.example.veterinaria.dto.Mascotas;
import com.example.veterinaria.dto.Veterinarios;
import com.example.veterinaria.exception.VeterinariaException;
import com.example.veterinaria.service.ConsultaService;

import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Service
public class ConsultaServiceImpl implements  ConsultaService {
	
	@Autowired
	private ConsultaRepository consultaRepository;

	
	@Override
	public List<Consultas> getConsultas() {
		
		
		return consultaRepository.findAll().stream().map(ConsultaPojo-> new Consultas(
				ConsultaPojo.getIdConsulta(),
				//ConsultaPojo.getMascotaPojo(),
				new Mascotas (
						ConsultaPojo.getMascotaPojo().getIdMascota(),
						ConsultaPojo.getMascotaPojo().getNombre(),
						ConsultaPojo.getMascotaPojo().getEspecie(),
						ConsultaPojo.getMascotaPojo().getRaza(),
						ConsultaPojo.getMascotaPojo().getFechaNacimiento(),
						ConsultaPojo.getMascotaPojo().getSexo(),
						new Clientes(
								ConsultaPojo.getMascotaPojo().getClientePojo().getIdCliente(),
								ConsultaPojo.getMascotaPojo().getClientePojo().getNombre(),
								ConsultaPojo.getMascotaPojo().getClientePojo().getApellido(),
								ConsultaPojo.getMascotaPojo().getClientePojo().getTelefono(),
								ConsultaPojo.getMascotaPojo().getClientePojo().getEmail(),
								ConsultaPojo.getMascotaPojo().getClientePojo().getDireccion()
								)
						),
				//ConsultaPojo.getVeterinarioPojo(),
				new Veterinarios(
						ConsultaPojo.getVeterinarioPojo().getIdVeterinario(),
						ConsultaPojo.getVeterinarioPojo().getNombre(),
						ConsultaPojo.getVeterinarioPojo().getApellido(),
						ConsultaPojo.getVeterinarioPojo().getEspecialidad(),
						ConsultaPojo.getVeterinarioPojo().getTelefono(),
						ConsultaPojo.getVeterinarioPojo().getEmail()
						),
				ConsultaPojo.getFechaConsulta(),
				ConsultaPojo.getMotivo(),
				ConsultaPojo.getDiagnostico(),
				ConsultaPojo.getTratamiento(),
				ConsultaPojo.getProximaCita()
				)
				).toList();
		
	
	}

	@Override
	public Consultas getConsultaId(int id) {
		
		ConsultaPojo consultaPojo = consultaRepository.findById(id).orElseThrow(
				() -> new VeterinariaException("error"));
		
		
		return new Consultas(
				consultaPojo.getIdConsulta(),
				//ConsultaPojo.getMascotaPojo(),
				new Mascotas (
						consultaPojo.getMascotaPojo().getIdMascota(),
						consultaPojo.getMascotaPojo().getNombre(),
						consultaPojo.getMascotaPojo().getEspecie(),
						consultaPojo.getMascotaPojo().getRaza(),
						consultaPojo.getMascotaPojo().getFechaNacimiento(),
						consultaPojo.getMascotaPojo().getSexo(),
						new Clientes(
								consultaPojo.getMascotaPojo().getClientePojo().getIdCliente(),
								consultaPojo.getMascotaPojo().getClientePojo().getNombre(),
								consultaPojo.getMascotaPojo().getClientePojo().getApellido(),
								consultaPojo.getMascotaPojo().getClientePojo().getTelefono(),
								consultaPojo.getMascotaPojo().getClientePojo().getEmail(),
								consultaPojo.getMascotaPojo().getClientePojo().getDireccion()
								
						)
					),
				//consultaPojo.getVeterinarioPojo(),
				new Veterinarios(
						consultaPojo.getVeterinarioPojo().getIdVeterinario(),
						consultaPojo.getVeterinarioPojo().getNombre(),
						consultaPojo.getVeterinarioPojo().getApellido(),
						consultaPojo.getVeterinarioPojo().getEspecialidad(),
						consultaPojo.getVeterinarioPojo().getTelefono(),
						consultaPojo.getVeterinarioPojo().getEmail()
						),
				consultaPojo.getFechaConsulta(),
				consultaPojo.getMotivo(),
				consultaPojo.getDiagnostico(),
				consultaPojo.getTratamiento(),
				consultaPojo.getProximaCita()
				);
				
	}

	@Override
	public void crearConsulta(Consultas consultas) {
	
		consultaRepository.saveAndFlush(
				new ConsultaPojo(
						///consultas.getMascota(),
						new MascotaPojo (
								consultas.getMascota().getIdMascota(),
								consultas.getMascota().getNombre(),
								consultas.getMascota().getEspecie(),
								consultas.getMascota().getRaza(),
								consultas.getMascota().getFechaNacimiento(),
								consultas.getMascota().getSexo(),
								new ClientePojo(
										consultas.getMascota().getCliente().getIdCliente(),
										consultas.getMascota().getCliente().getNombre(),
										consultas.getMascota().getCliente().getApellido(),
										consultas.getMascota().getCliente().getTelefono(),
										consultas.getMascota().getCliente().getEmail(),
										consultas.getMascota().getCliente().getDireccion()
										
								)
							),
						//consultas.getVeterinario(),
						new VeterinarioPojo(
								consultas.getVeterinario().getIdVeterinario(),
								consultas.getVeterinario().getNombre(),
								consultas.getVeterinario().getApellido(),
								consultas.getVeterinario().getEspecialidad(),
								consultas.getVeterinario().getTelefono(),
								consultas.getVeterinario().getEmail()
								),
						consultas.getFechaConsulta(),
						consultas.getMotivo(),
						consultas.getDiagnostico(),
						consultas.getTratamiento(),
						consultas.getProximaCita()
				)
			);
		
		
	}

	@Override
	public void editarConsulta(Consultas consultas) {
		
		var p =  consultaRepository.findById(consultas.getIdConsulta());
		
		if( p.isEmpty()) {
			throw new VeterinariaException("Consulta no registrada");
		}
		
		consultaRepository.saveAndFlush(
				new ConsultaPojo(
						consultas.getIdConsulta(),
						///consultas.getMascota(),
						new MascotaPojo (
								consultas.getMascota().getIdMascota(),
								consultas.getMascota().getNombre(),
								consultas.getMascota().getEspecie(),
								consultas.getMascota().getRaza(),
								consultas.getMascota().getFechaNacimiento(),
								consultas.getMascota().getSexo(),
								new ClientePojo(
										consultas.getMascota().getCliente().getIdCliente(),
										consultas.getMascota().getCliente().getNombre(),
										consultas.getMascota().getCliente().getApellido(),
										consultas.getMascota().getCliente().getTelefono(),
										consultas.getMascota().getCliente().getEmail(),
										consultas.getMascota().getCliente().getDireccion()
										
								)
							),
						//consultas.getVeterinario(),
						new VeterinarioPojo(
								consultas.getVeterinario().getIdVeterinario(),
								consultas.getVeterinario().getNombre(),
								consultas.getVeterinario().getApellido(),
								consultas.getVeterinario().getEspecialidad(),
								consultas.getVeterinario().getTelefono(),
								consultas.getVeterinario().getEmail()
								),
						consultas.getFechaConsulta(),
						consultas.getMotivo(),
						consultas.getDiagnostico(),
						consultas.getTratamiento(),
						consultas.getProximaCita()
				)
			);
		
	}

	@Override
	public void eliminar(int id) {
		
		var p =  consultaRepository.findById(id);
		
		if( p.isEmpty()) {
			throw new VeterinariaException("Macota no registrada");
		}
		
		consultaRepository.deleteById(id);
		
	}

}
