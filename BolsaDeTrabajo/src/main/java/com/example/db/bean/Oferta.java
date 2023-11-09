package com.example.db.bean;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;

@Entity
@Table(name = "Oferta")
public class Oferta {



	Oferta() {
    }

    Oferta(String titulo, String estado, String descripcion, Long idEmpresa) {
		this.titulo = titulo;
        this.estado = estado;
        this.descripcion = descripcion;
        this.idEmpresa = idEmpresa;
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "TITULO", length = 500, nullable = false)
    private String titulo;

    @Column(name = "ESTADO", length = 20, nullable = false)
    private String estado;

    @Column(name = "DESCRIPCION", length = 500, nullable = false)
    private String descripcion;

//    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @Column(name = "ID_EMPRESA")
    private Long idEmpresa;
    

    public Long getId() {
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



	public Long getIdEmpresa() {
		return idEmpresa;
	}

	public void setIdEmpresa(long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	@Override
    public String toString() {
        return "Oferta{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
