package com.example.db.bean;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name="Empresa")
public class Empresa {

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(example = "4", description = "Identificador clave primaria empleado númerico")
    private long id;

    @Column(name = "NOMBRE", nullable = false, length = 100)
	@Schema(example = "Grifols", description = "Nombre completo de la empresa")
    private String nombre;

    @Column(name = "DESCRIPCION", nullable = false, length = 500)
	@Schema(example = "Grifols es una compañía global líder en el sector de la salud que desarrolla medicamentos derivados del plasma y otras soluciones biotecnológicas innovadoras que mejoran la salud y la vida de millones de pacientes en todo el mundo. ", description = "Descripcion de la empresa")
    private String descripcion;

    @OneToMany(mappedBy = "empresa", cascade = CascadeType.ALL)
    private List<Oferta> ofertas = new ArrayList<>();
    

    public void añadirOferta(Oferta oferta) {
        ofertas.add(oferta);
        oferta.setEmpresa(this);
    }

    public void removeOferta(Oferta oferta) {
        ofertas.remove(oferta);
        oferta.setEmpresa(null);
    }
    
    public Empresa(String nombre, String descripcion) {
    	super();
    	this.nombre = nombre;
        this.descripcion = descripcion;
       // this.ofertas = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Oferta> getOfertas() {
        return ofertas;
    }

    public void setOfertas(List<Oferta> ofertas) {
        this.ofertas = ofertas;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o)
//            return true;
//        if (!(o instanceof Empresa))
//            return false;
//        Empresa empresa = (Empresa) o;
//        return Objects.equals(this.id, empresa.id) && Objects.equals(this.nombre, empresa.nombre)
//                && Objects.equals(this.descripcion, empresa.descripcion);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(this.id, this.nombre, this.descripcion);
//    }

    @Override
    public String toString() {
        return "Empresa{" + "id=" + this.id + ", nombre='" + this.nombre + '\'' + ", descripcion='" + this.descripcion + '\'' + '}';
    }
}
