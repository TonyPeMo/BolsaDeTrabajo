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
    	
 
    	Empresa empresa1 = new Empresa("Empresa1", "descr 1");
        Empresa empresa2 = new Empresa("Empresa2", "descr 2");

        // Guardar las empresas primero
        empresaRepository.save(empresa1);
        empresaRepository.save(empresa2);

        Oferta oferta1 = ofertaRepository.save(new Oferta("Título de la oferta 1", "Activa", "Descripción de la oferta 1", empresa1));
        ofertaRepository.save(oferta1);
        
        return args -> {
            log.info("Preloading " + empresa1);
            log.info("Preloading " + empresa2);
            log.info("Preloading " + oferta1);

        };
    }
}
/*
        return args -> {
            // Guardar las empresas
            Empresa empresa1 = empresaRepository.save(new Empresa("deloite", "programacion info etc"));
            Empresa empresa2 = empresaRepository.save(new Empresa("mercadona", "supermercado cositas"));

            log.info("Preloading " + empresa1);
            log.info("Preloading " + empresa2);

            // Recuperar las empresas guardadas
//            Empresa empresaDeloite = empresaRepository.findByNombre("deloite");
//            Empresa empresaMercadona = empresaRepository.findByNombre("mercadona");

           if (empresaDeloite != null && empresaMercadona != null) {
              log.info("Empresa 'deloite' encontrada: " + empresaDeloite.getNombre());
              log.info("Empresa 'mercadona' encontrada: " + empresaMercadona.getNombre());
//
//                // Crear y guardar ofertas utilizando las empresas recuperadas
              //Oferta oferta1 = new Oferta("Título de la oferta 1", "Activa", "Descripción de la oferta 1", empresaDeloite);
              Oferta oferta1 = ofertaRepository.save(new Oferta("Título de la oferta 1", "Activa", "Descripción de la oferta 1", empresa1));
             // log.info("Preloading " + ofertaRepository.save(oferta1));
//
//                Oferta oferta2 = new Oferta("Título de la oferta 2", "Activa", "Descripción de la oferta 2", empresaDeloite);
//                log.info("Preloading " + ofertaRepository.save(oferta2));
           } else {
//                log.error("Empresas no encontradas.");
           }
        };
    }
}
*/