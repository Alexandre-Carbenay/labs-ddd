package com.zenika.ddd.domain.contratauto;

import java.util.Objects;

public class Vehicule {

    private final ClasseVehicule classe;
    private final Immatriculation immatriculation;

    public Vehicule(Immatriculation immatriculation, ClasseVehicule classeVehicule) {
        this.immatriculation = immatriculation;
        this.classe = classeVehicule;
    }

    public ClasseVehicule getClasse() {
        return classe;
    }

    public Immatriculation getImmatriculation() {
        return immatriculation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicule vehicule = (Vehicule) o;
        return classe == vehicule.classe &&
                Objects.equals(immatriculation, vehicule.immatriculation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classe, immatriculation);
    }
}
