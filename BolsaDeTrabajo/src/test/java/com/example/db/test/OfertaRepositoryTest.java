package com.example.db.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.db.bean.Empresa;
import com.example.db.bean.EmpresaRepository;
import com.example.db.bean.Oferta;
import com.example.db.bean.OfertaRepository;



@DataJpaTest
public class OfertaRepositoryTest {

    @Autowired
    private OfertaRepository ofertaRepository;

    @Autowired
    private EmpresaRepository empresaRepository;

    @Test
    @DirtiesContext
    public void testFindByEmpresaId() {
        // Crear una empresa 
        Empresa empresa = new Empresa("NombreEmpresa", "DescripciónEmpresa");
        empresa = empresaRepository.save(empresa);

        // Crear ofertas
        Oferta oferta1 = new Oferta((Long)null, "Oferta1", "Activa", "Descripción1", empresa);
        Oferta oferta2 = new Oferta((Long) null, "Oferta2", "Inactiva", "Descripción2", empresa);
        ofertaRepository.save(oferta1);
        ofertaRepository.save(oferta2);

        // Obtener ofertas por ID de empresa
        Long empresaId = empresa.getId();
        List<Oferta> ofertasPorEmpresaId = ofertaRepository.findAllByEmpresaId(empresaId);

        assertNotNull(ofertasPorEmpresaId);
        assertEquals(2, ofertasPorEmpresaId.size());
    }
}