package com.example.db.bean;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
	Empresa findByNombre(String nombre);
	
}