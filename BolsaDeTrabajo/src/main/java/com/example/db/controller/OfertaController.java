package com.example.db.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.db.bean.Empresa;
import com.example.db.bean.EmpresaNotFoundException;
import com.example.db.bean.EmpresaRepository;
import com.example.db.bean.Oferta;
import com.example.db.bean.OfertaRepository;

@RestController
class OfertaController {

  private final OfertaRepository repository;

  OfertaController(OfertaRepository repository) {
    this.repository = repository;
  }


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/ofertas")
  List<Oferta> all() {
    return repository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/ofertas")
  Oferta newOferta(@RequestBody Oferta newOferta) {
    return repository.save(newOferta);
  }

  // Single item
  
  @GetMapping("/ofertas/{id}")
  Oferta one(@PathVariable Long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new OfertaNotFoundException(id));
  }

  @PutMapping("/ofertas/{id}")
  Oferta replaceOferta(@RequestBody Oferta newOferta, @PathVariable Long id) {
    
    return repository.findById(id)
      .map(oferta -> {
    	oferta.setEstado(newOferta.getDescripcion());
        oferta.setEstado(newOferta.getEstado());
        //oferta.setCalendar(newOferta.getCalendar());
        return repository.save(oferta);
      })
      .orElseGet(() -> {
        newOferta.setId(id);
        return repository.save(newOferta);
      });
  }

  @DeleteMapping("/ofertas/{id}")
  void deleteOferta(@PathVariable Long id) {
    repository.deleteById(id);
  }
}