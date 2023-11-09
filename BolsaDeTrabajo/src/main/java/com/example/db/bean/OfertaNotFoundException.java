package com.example.db.bean;

public class OfertaNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

	public OfertaNotFoundException(long id) {
		super("Could not find Oferta " + id);
	}
}
