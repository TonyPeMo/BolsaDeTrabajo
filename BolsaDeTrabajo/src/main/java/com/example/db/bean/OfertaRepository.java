package com.example.db.bean;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OfertaRepository extends JpaRepository<Oferta, Long> {
    // Método para buscar una empresa por su ID
    List<Oferta> findAllByIdEmpresa(long ID_EMPRESA);
}
