package com.example.db.bean;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
//@Table(name = "Oferta")
public class Oferta {




	@Id
    //@Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    //@Column(name = "TITULO", length = 500, nullable = false)
    private String titulo;

    //@Column(name = "ESTADO", length = 20, nullable = false)
    private String estado;

    //@Column(name = "DESCRIPCION", length = 500, nullable = false)
    private String descripcion;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "empresa", nullable = false)
    private Empresa empresa;
    
    
    public Oferta(long id, String titulo, String estado, String descripcion, Empresa empresa) {
		super();
		this.id = id;
		this.titulo = titulo;
		this.estado = estado;
		this.descripcion = descripcion;
		this.empresa = empresa;
	}
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    @Override
    public String toString() {
        return "Oferta{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
    
    Oferta() {
    }

    Oferta(String titulo, String estado, String descripcion, Empresa empresa) {
        this.titulo = titulo;
        this.estado = estado;
        this.descripcion = descripcion;
        this.empresa = empresa;
    }

}
