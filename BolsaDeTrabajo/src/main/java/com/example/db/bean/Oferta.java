package com.example.db.bean;

import jakarta.persistence.*;

import java.util.Objects;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table(name = "Oferta")
public class Oferta {

	@Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Schema(example = "4", description = "Identificador clave primaria empleado númerico")
    private long id;

    @Column(name = "TITULO", length = 500, nullable = false)
	@Schema(example = "Desarrollador/a Junior (formación Java online + empleo) - Barcelona", description = "Nombre completo de la oferta")
    private String titulo;

    @Column(name = "ESTADO", length = 20, nullable = false)
    @Schema(example = "En proceso", description = "Estado actual de la oferta")
    private String estado;

    @Column(name = "DESCRIPCION", length = 500, nullable = false)
    @Schema(name = "¿Buscas tu primera experiencia en el sector IT? ¿Cuentas con experiencia/conocimientos en backend? Si respondiste si, ¡Sigue leyendo!\r\n"
    		+ "\r\n"
    		+ "Desde Luca TIC vamos a lanzar a partir de febrero un proyecto de inclusión para uno de nuestros principales clientes, líder del sector Tecnológico.\r\n"
    		+ "\r\n"
    		+ "Buscamos personas con gran interés en poder iniciar su carrera profesional en el mundo de la programación."
    		, description = "Descripcion de la oferta")
    private String descripcion;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Empresa", nullable = false)
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

}
