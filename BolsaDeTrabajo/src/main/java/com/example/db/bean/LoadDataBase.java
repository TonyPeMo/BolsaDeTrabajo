package com.example.db.bean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
class LoadDatabase {

  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

  @Bean
  CommandLineRunner initDatabase(EmpresaRepository empresaRepository, OfertaRepository ofertaRepository) {

    return args -> {
        log.info("Preloading " + empresaRepository.save(new Empresa("deloite", "programacion info etc")));
        log.info("Preloading " + empresaRepository.save(new Empresa("mercadona", "supermercado cositas")));

        Empresa mercadona = empresaRepository.findByNombre("mercadona");
        if (mercadona != null) {
            log.info("Empresa 'mercadona' encontrada: " + mercadona.getNombre());
            log.info("Preloading " + ofertaRepository.save(new Oferta("Título de la oferta", "Activa", "Descripción de la oferta", new Empresa("Puterio", "supermercado cositas"))));
            //log.info("Preloading " + ofertaRepository.save(new Oferta("Título de la oferta", "Activa", "Descripción de la oferta",mercadona)));

        } else {
            log.error("Empresa 'mercadona' no encontrada.");
        }
    };
  }
}
