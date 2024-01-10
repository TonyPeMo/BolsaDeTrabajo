package com.example.db.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;

import com.example.db.bean.Empresa;
import com.example.db.bean.EmpresaRepository;
import com.example.db.exceptions.EmpresaNotFoundException;


@RestController
@RequestMapping("/api")
@Tag(name = "Empresa", description = "Empresa API REST with CRUD operations")
class EmpresaController {

  private final EmpresaRepository repository;

  EmpresaController(EmpresaRepository repository) {
    this.repository = repository;
  }

  @ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "Retrieved empresa", content = {
	            @Content(mediaType = "application/json",
	                    array = @ArraySchema(schema = @Schema(implementation = Empresa.class)))})
  })
  @Operation(summary = "findAll Empresas", description = "It retrieves all empresas from database without pagination")
  @GetMapping("/empresas")
  List<Empresa> all() {
    return repository.findAll();
  }
  
  @PostMapping("/empresas")
  Empresa newEmpresa(@RequestBody Empresa newEmpresa) {
    return repository.save(newEmpresa);
  }

  @GetMapping("/empresas/{id}")
  Empresa one(@PathVariable long id) {
    
    return repository.findById(id)
      .orElseThrow(() -> new EmpresaNotFoundException(id));
  }

  @PutMapping("/empresas/{id}")
  Empresa replaceEmpresa(@RequestBody Empresa newEmpresa, @PathVariable long id) {
    
    return repository.findById(id)
      .map(empresa -> {
        empresa.setNombre(newEmpresa.getNombre());
        empresa.setDescripcion(newEmpresa.getDescripcion());
        return repository.save(empresa);
      })
      .orElseGet(() -> {
        newEmpresa.setId(id);
        return repository.save(newEmpresa);
      });
  }

  @DeleteMapping("/empresas/{id}")
  void deleteEmpresa(@PathVariable long id) {
    repository.deleteById(id);
  }
}