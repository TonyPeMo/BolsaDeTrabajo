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
  CommandLineRunner initDatabase(EmpresaRepository eRepository, OfertaRepository oRepository) {

    return args -> {
    	log.info("Preloading " + eRepository.save(new Empresa("deloite", "programacion info etc")));
        log.info("Preloading " + eRepository.save(new Empresa("mercadona", "supermercado cositas")));

//        log.info("Preloading " + oRepository.save(new Oferta("Activa","Desarrollador de Mamografias", new Empresa("mercadona", "supermercado cositas"))));
//        log.info("Preloading " + oRepository.save(new Oferta("Activa","Desarrollador de Mamografias", new Empresa("mercadona", "supermercado cositas"))));
    };
  }
}