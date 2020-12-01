package com.zenika.ddd.domain.contratauto;

public class Coefficient implements EstUnCoefficient{
    private final double valeur;

    public double getValeur() {
        return valeur;
    }

    private Coefficient(double valeur) {
        this.valeur = valeur;
    }

    public static Coefficient of(double valeur) {
        return new Coefficient(valeur);
    }
}
