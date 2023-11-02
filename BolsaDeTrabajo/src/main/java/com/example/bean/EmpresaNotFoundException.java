package com.example.bean;

public class EmpresaNotFoundException extends RuntimeException {

	public EmpresaNotFoundException(Long id) {
		super("Could not find employee " + id);
	}
}