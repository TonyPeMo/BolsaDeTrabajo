package com.example.db.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;

import com.example.db.bean.Empresa;
import com.example.db.bean.EmpresaRepository;



@DataJpaTest
public class EmpresaRepositoryTest {

    @Autowired
    private EmpresaRepository empresaRepository;

    @Test
    @DirtiesContext
    public void testGuardarYRecuperarEmpresa() {
        Empresa empresa = new Empresa("Empresa1", "DescripciónEmpresa1");

        // Guardar la empresa en BBDD
        empresa = empresaRepository.save(empresa);

        // Recuperar la empresa por ID
        Long empresaId = empresa.getId();
        Empresa empresaRecuperada = empresaRepository.findById(empresaId).orElse(null);
        assertNotNull(empresaRecuperada);
        assertEquals("NombreEmpresa", empresaRecuperada.getNombre());
        assertEquals("DescripciónEmpresa", empresaRecuperada.getDescripcion());
    }

    @Test
    @DirtiesContext
    public void testObtenerTodasLasEmpresas() {
        // Crear empresas de prueba
        Empresa empresa1 = new Empresa("Empresa1", "Descripción1");
        Empresa empresa2 = new Empresa("Empresa2", "Descripción2");

        // Guardar las empresas en BBDD
        empresaRepository.save(empresa1);
        empresaRepository.save(empresa2);
        List<Empresa> empresas = empresaRepository.findAll();
        assertEquals(2, empresas.size());
    }
}