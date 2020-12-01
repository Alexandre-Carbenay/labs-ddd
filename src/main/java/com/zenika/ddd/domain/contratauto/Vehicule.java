package com.zenika.ddd.domain.contratauto;

public class Vehicule {

    private final ClasseVehicule classe;

    public Vehicule(ClasseVehicule classeVehicule) {
        this.classe = classeVehicule;
    }

    public ClasseVehicule getClasse() {
        return classe;
    }
}
