package com.zenika.ddd.domain.reception;

public class MarchandiseInconnue extends RuntimeException {

	public MarchandiseInconnue(Sku sku) {
		super("le " + sku.getValue() + " est inconnu");
		// TODO Auto-generated constructor stub
	}

	
	
}
