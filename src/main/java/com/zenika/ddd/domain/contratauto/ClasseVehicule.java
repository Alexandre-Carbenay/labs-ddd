package com.zenika.ddd.domain.contratauto;

public enum ClasseVehicule {

    BAS(1), MOYEN(2), HAUT(3);

    private final double coefficient;

    ClasseVehicule(double coefficient) {
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }
}
