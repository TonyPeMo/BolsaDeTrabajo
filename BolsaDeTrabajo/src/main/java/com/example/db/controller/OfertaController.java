package com.example.db.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.db.bean.Empresa;
import com.example.db.bean.EmpresaNotFoundException;
import com.example.db.bean.OfertaNotFoundException;
import com.example.db.bean.EmpresaRepository;
import com.example.db.bean.Oferta;
import com.example.db.bean.OfertaRepository;

@RestController
class OfertaController {

  private final OfertaRepository ofertaRepository;
  private final EmpresaRepository empresaRepository;


  OfertaController(OfertaRepository ofertaRepository, EmpresaRepository empresaRepository) {
    this.ofertaRepository = ofertaRepository;
    this.empresaRepository = empresaRepository;
  }
  


  // Aggregate root
  // tag::get-aggregate-root[]
  @GetMapping("/ofertas")
  List<Oferta> all() {
    return ofertaRepository.findAll();
  }
  // end::get-aggregate-root[]

  @PostMapping("/ofertas")
  Oferta newOferta(@RequestBody Oferta newOferta) {
    return ofertaRepository.save(newOferta);
  }

  // Single item
  
  @GetMapping("/ofertas/{id}")
  Oferta one(@PathVariable Long id) {
    
    return ofertaRepository.findById(id)
      .orElseThrow(() -> new OfertaNotFoundException(id));
  }

  @PutMapping("/ofertas/{id}")
  Oferta replaceOferta(@RequestBody Oferta newOferta, @PathVariable Long id) {
    
    return ofertaRepository.findById(id)
      .map(oferta -> {
    	oferta.setEstado(newOferta.getDescripcion());
        oferta.setEstado(newOferta.getEstado());
        //oferta.setCalendar(newOferta.getCalendar());
        return ofertaRepository.save(oferta);
      })
      .orElseGet(() -> {
        newOferta.setId(id);
        return ofertaRepository.save(newOferta);
      });
  }
  
  @GetMapping("/ofertas/empresas/{id}")
  List<Oferta> getOfertasByEmpresaId(@PathVariable Long id) {
      Optional<Empresa> empresa = empresaRepository.findById(id);
      if (!empresa.isPresent()) {
          throw new EmpresaNotFoundException(id);
      }
      return ofertaRepository.findByEmpresa(empresa.get());
  }


 
  
  @DeleteMapping("/ofertas/{id}")
  void deleteOferta(@PathVariable Long id) {
	  ofertaRepository.deleteById(id);
  } 
  
}