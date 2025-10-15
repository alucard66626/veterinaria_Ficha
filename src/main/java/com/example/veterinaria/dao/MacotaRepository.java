package com.example.veterinaria.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.veterinaria.dao.pojo.MascotaPojo;

public interface MacotaRepository extends JpaRepository<MascotaPojo,Integer> {

}
