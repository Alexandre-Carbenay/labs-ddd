package com.zenika.ddd.domain.reception;

public class Marchandise {
    private final Sku sku;
    private final int quantite;

    public Marchandise(Sku sku, int quantite) {
        this.sku = sku;
        this.quantite = quantite;
    }
    
    public Sku getSKU() {
    	
    	return this.sku;
    	
    }

	public boolean avecMemeSku(Sku sku2) {
		// TODO Auto-generated method stub
		return sku.equals(sku2);
	}
    
}
