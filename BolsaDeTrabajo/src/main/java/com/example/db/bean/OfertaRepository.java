package com.example.db.bean;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OfertaRepository extends JpaRepository<Oferta, Long> {
    List<Oferta> findByEmpresa(Empresa empresa);
}
