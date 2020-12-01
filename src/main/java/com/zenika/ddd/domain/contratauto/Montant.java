package com.zenika.ddd.domain.contratauto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Montant {
    private final double valeur;

    public double getValeur() {
        return valeur;
    }

    private final String devise;

    public String getDevise() {
        return devise;
    }

    private Montant(double valeur, String devise) {
        this.valeur = valeur;
        this.devise = devise;
    }

    public Montant appliqueCoefficient(EstUnCoefficient coefficient) {
        return new Montant(getValeur() * coefficient.getValeur(), getDevise());
    }

    public static Montant euros(double valeur) {
        return new Montant(valeur, "EUR");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        Montant montant = (Montant) o;

        return new EqualsBuilder()
                .append(valeur, montant.valeur)
                .append(devise, montant.devise)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(valeur)
                .append(devise)
                .toHashCode();
    }
}
