package com.example.db.bean;

public class EmpresaNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EmpresaNotFoundException(long id) {
		super("Could not find Empresa " + id);
	}
}