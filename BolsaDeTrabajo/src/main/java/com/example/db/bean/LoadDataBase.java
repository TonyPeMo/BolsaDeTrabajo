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

            Empresa mercadona = empresaRepository.findByNombre("mercadona");
            if (mercadona != null) {
                log.info("Empresa 'mercadona' encontrada: " + mercadona.getNombre());
                
//                 Usa la instancia de Empresa obtenida de empresaRepository para crear la oferta
                log.info("Preloading " + ofertaRepository.save(new Oferta("Título de la oferta", "Activa", "Descripción de la oferta", mercadona.getId())));
                log.info("Preloading " + ofertaRepository.save(new Oferta("Título de la oferta", "Activa", "Descripción de la oferta", (long) 1)));
            } else {
                log.error("Empresa 'mercadona' no encontrada.");
            }
        };
    }
}

