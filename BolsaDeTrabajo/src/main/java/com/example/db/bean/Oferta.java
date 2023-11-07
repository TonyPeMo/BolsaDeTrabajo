package com.example.db.bean;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.util.Objects;


@Entity
@Table(name="Oferta")
public class Oferta {
    
	Oferta() {
    }
    Oferta(String titulo, String estado, String descripcion, Empresa empresa) {
    	this.titulo = titulo;
		this.estado = estado;
		this.descripcion = descripcion;
//		this.registDate = registDate;
		this.empresa = empresa;
	}

	@Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
	@Column(name = "TITULO", length = 500, nullable = false)
	private String titulo;
	
    @Column(name = "ESTADO", length = 20, nullable = false)
    private String estado;
    
    @Column(name = "DESCRIPCION", length = 500, nullable = false)
    private String descripcion;
    

//	@Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "REGIST_DATE", nullable = false)
//    private Calendar registDate;
    
    public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Empresa empresa;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


//	public Calendar getRegistDate() {
//		return registDate;
//	}
//
//	public void setRegistDate(Calendar registDate) {
//		this.registDate = registDate;
//	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
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
	
	@Override
	  public int hashCode() {
	    return Objects.hash(this.id, this.empresa.getNombre(), this.descripcion);
	  }
	@Override
    public String toString() {
        return "Oferta{" +
                "id=" + id +
                ", estado='" + estado + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", empresa=" + empresa.getNombre() +
                '}';
    }
	//
    
}