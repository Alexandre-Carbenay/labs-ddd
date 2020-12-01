package com.zenika.ddd.domain.contratauto;

public class Vehicule {

    private final ClasseVehicule classe;
    private final String immatriculation;

    public Vehicule(String immatriculation, ClasseVehicule classeVehicule) {
        this.immatriculation = immatriculation;
        this.classe = classeVehicule;
    }

    public ClasseVehicule getClasse() {
        return classe;
    }

    public String getImmatriculation() {
        return immatriculation;
    }
}
