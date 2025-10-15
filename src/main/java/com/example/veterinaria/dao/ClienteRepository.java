package com.example.veterinaria.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.veterinaria.dao.pojo.ClientePojo;


@Repository
public interface ClienteRepository extends JpaRepository<ClientePojo,Integer>{
	
	@Query(nativeQuery= true , value="select * from Clientes where IdCliente = :idCliente")
	Optional<ClientePojo>obtenerClientePorId(int idCliente);

}
