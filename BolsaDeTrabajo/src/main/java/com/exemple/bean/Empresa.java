package com.exemple.bean;

public class Empresa {
	
	private int id;
	private String nombre;
	private String info;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	
	public Empresa(String nombre, String info) {
		super();
		this.nombre = nombre;
		this.info = info;
	}
	
	public Empresa(String nombre) {
		super();
		this.nombre = nombre;
	}
}
