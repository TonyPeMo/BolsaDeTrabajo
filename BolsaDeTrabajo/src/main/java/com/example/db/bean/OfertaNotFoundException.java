package com.example.db.bean;

public class OfertaNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public OfertaNotFoundException(Long id) {
		super("Could not find Oferta " + id);
	}
}
