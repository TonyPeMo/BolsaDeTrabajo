package com.example.db.controller;

import java.util.List;
import java.util.Optional;
import java.util.Optional.*;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.db.bean.Empresa;
import com.example.db.bean.EmpresaRepository;
import com.example.db.bean.Oferta;
import com.example.db.bean.OfertaRepository;
import com.example.db.exceptions.EmpresaNotFoundException;
import com.example.db.exceptions.OfertaNotFoundException;

@RestController
class OfertaController {

  private final OfertaRepository ofertaRepository;
  private final EmpresaRepository empresaRepository;

  OfertaController(OfertaRepository ofertaRepository, EmpresaRepository empresaRepository) {
    this.ofertaRepository = ofertaRepository;
	this.empresaRepository = empresaRepository;
  }

  @GetMapping("/ofertas")
  List<Oferta> all() {
    return ofertaRepository.findAll();
  }
  
  
  @GetMapping("/empresa/{id}/ofertas")
  List<Oferta> findOfertasByEmpresaId(@PathVariable long id) {
      return ofertaRepository.findAllByEmpresaId(id);
  }

  @PostMapping("/ofertas")
  Oferta newOferta(@RequestBody Oferta newOferta) {
    return ofertaRepository.save(newOferta);
  }

  
  @GetMapping("/ofertas/{id}")
  Oferta one(@PathVariable long id) {
    return ofertaRepository.findById(id)
      .orElseThrow(() -> new OfertaNotFoundException(id));
  }

  @PutMapping("/ofertas/{id}")
  Oferta replaceOferta(@RequestBody Oferta newOferta, @PathVariable long id) {
      
      return ofertaRepository.findById(id)
        .map(oferta -> {
          oferta.setDescripcion(newOferta.getDescripcion());
          oferta.setEstado(newOferta.getEstado());
          return ofertaRepository.save(oferta);
        })
        .orElseGet(() -> {
          newOferta.setId(id);
          return ofertaRepository.save(newOferta);
        });
  }


  @DeleteMapping("/ofertas/{id}")
  void deleteOferta(@PathVariable long id) {
	  ofertaRepository.deleteById(id);
  }
  
}