package com.example.db.bean;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    List<Empresa> findAll();
    List<Empresa> findEmpresaById(long id);	
 
}