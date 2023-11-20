package com.example.db.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDataBase {

    private static final Logger log = LoggerFactory.getLogger(LoadDataBase.class);

    @Bean
    CommandLineRunner initDatabase(EmpresaRepository empresaRepository, OfertaRepository ofertaRepository) {

        return args -> {
            log.info("Preloading " + empresaRepository.save(new Empresa("deloite", "programacion info etc")));
            log.info("Preloading " + empresaRepository.save(new Empresa("mercadona", "supermercado cositas")));

            Long idEmpresa = 1L; // ID de la empresa conocido

            Empresa empresa = empresaRepository.findById(idEmpresa)
                    .orElseThrow(() -> new EmpresaNotFoundException(idEmpresa));

            // Crear una oferta asociada a la empresa obtenida
            Oferta oferta = new Oferta("Título de la oferta", "Activa", "Descripción de la oferta", empresa);
            ofertaRepository.save(oferta);

        };
    }
}

