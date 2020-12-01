package com.zenika.ddd.domain.contratauto;

public enum ClasseVehicule implements EstUnCoefficient {

    BAS(1), MOYEN(2), HAUT(3);

    private final Coefficient coefficient;

    ClasseVehicule(double valeur) {
        this.coefficient = Coefficient.of(valeur);
    }

    @Override
    public double getValeur() {
        return coefficient.getValeur();
    }
}
