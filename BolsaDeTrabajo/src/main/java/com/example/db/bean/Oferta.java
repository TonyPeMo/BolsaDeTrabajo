package com.example.db.bean;

import java.util.Calendar;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name="Oferta")
public class Oferta {
    
	
    public Oferta(String estado, String descripcion, Calendar registDate, Empresa empresa) {
		super();
		this.estado = estado;
		this.descripcion = descripcion;
//		this.registDate = registDate;
		this.empresa = empresa;
	}

	@Id
    @Column(name="ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "ESTADO", length = 20, nullable = false)
    private String estado;
    
    @Column(name = "DESCRIPCION", length = 500, nullable = false)
    private String descripcion;

//	@Temporal(TemporalType.TIMESTAMP)
//    @Column(name = "REGIST_DATE", nullable = false)
//    private Calendar registDate;
    
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
	  public String toString() {
	    return "Oferta{" + "id=" + this.id + ", nombre='" + empresa.getNombre() + '\'' + ", Estado= "+ this.estado+ ", descripcion='" + this.descripcion + '\'' + '}';
	  }
    
}