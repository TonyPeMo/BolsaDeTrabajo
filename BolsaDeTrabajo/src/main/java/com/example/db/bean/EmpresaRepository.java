package com.example.db.bean;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	Empresa findByNombre(String nombre);
    List<Empresa> findAll();

    // Método para buscar una empresa por su ID
    Empresa findEmpresaById(long id);
	
}