package com.example.db.bean;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface OfertaRepository extends JpaRepository<Oferta, Long> {
    List<Oferta> findAllByEmpresaId(long empresaId);
}