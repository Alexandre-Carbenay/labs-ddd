package com.zenika.ddd.domain.contratauto;

public class ConducteurPrincipal implements EstUnCoefficient {

    private Coefficient coefficient;

    public ConducteurPrincipal(Coefficient coefficient) {
        this.coefficient = coefficient;
    }

    @Override
    public double getValeur() {
        return coefficient.getValeur();
    }
}
