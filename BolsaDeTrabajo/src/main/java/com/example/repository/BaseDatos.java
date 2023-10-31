package com.example.repository;

import java.util.ArrayList;

import java.util.Iterator;
import com.exemple.bean.Empresa;


public class BaseDatos {
	
	ArrayList<Empresa> empresas = new ArrayList<Empresa>();
	public BaseDatos() {
		empresas.add(new Empresa(1, "Empresa 1", "Primera empresa"));
		empresas.add(new Empresa(2, "Empresa 2", "Segunda empresa"));
		empresas.add(new Empresa(3, "Empresa 3", "Tercera empresa"));
	}
	
	public void inserta(Empresa empresa) {
		empresas.add(empresa);
	}
	
	public void borrar(int id) {
		Iterator<Empresa> it = empresas.iterator();
		while(it.hasNext()) {
			Empresa li = it.next();
			if (li.getId()==id) {
				it.remove();
				break;
			}
		}
	}
	
	public void modifica(Empresa empresa) {
		Iterator<Empresa> it = empresas.iterator();
		while(it.hasNext()) {
			Empresa li = it.next();
			if (li.getId()==empresa.getId()) {
				li.setNombre(empresa.getNombre());
				li.setInfo(empresa.getInfo());
				break;
			}
		}
	}
		
	public ArrayList<Empresa> getEmpresas() {
		return empresas;
	}
	
	public Empresa getEmpresa(int id) {
        Iterator<Empresa> it = empresas.iterator();
        while(it.hasNext()) {
            Empresa li = it.next();
            if (li.getId() == id) {
                return li;
            }
        }
        return null;
    }
	
	public void setEmpresas(ArrayList<Empresa> empresas) {
		this.empresas = empresas;
	}
}
