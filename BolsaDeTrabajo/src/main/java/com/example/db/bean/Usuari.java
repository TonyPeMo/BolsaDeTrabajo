package com.example.db.bean;


import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

@Entity
class Usuari {
	@Schema(example = "4", description = "Identificador clave primaria empleado númerico")
	private @Id @GeneratedValue Long id;
	
	@Schema(example = "Tony Pereira", description = "Nombre completo usuario")
	private String nom;
	
	
	  Usuari() {}
	
	  Usuari(String nom) {
	
	    this.nom = nom;
	  }
	
	  public Long getId() {
	    return this.id;
	  }
	
	  public String getnom() {
	    return this.nom;
	  }
	  
	
	  public void setId(Long id) {
	    this.id = id;
	  }
	
	  public void setnom(String nom) {
	    this.nom = nom;
	  }
	
	  @Override
	  public boolean equals(Object o) {
	
	    if (this == o)
	      return true;
	    if (!(o instanceof Usuari))
	      return false;
	    Usuari usuari = (Usuari) o;
	    return Objects.equals(this.id, usuari.id) && Objects.equals(this.nom, usuari.nom);
	  }
	
	  @Override
	  public int hashCode() {
	    return Objects.hash(this.id, this.nom);
	  }
	
	  @Override
	  public String toString() {
	    return "Usuari{" + "id=" + this.id + ", nom='" + this.nom + '}';
	  }
}