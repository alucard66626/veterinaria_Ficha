package com.example.veterinaria.dao;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.veterinaria.dao.pojo.ConsultaPojo;

public interface ConsultaRepository extends JpaRepository<ConsultaPojo,Integer> {

}
