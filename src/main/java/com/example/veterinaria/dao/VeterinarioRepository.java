package com.example.veterinaria.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.veterinaria.dao.pojo.VeterinarioPojo;

public interface VeterinarioRepository extends JpaRepository<VeterinarioPojo,Integer>  {

}
