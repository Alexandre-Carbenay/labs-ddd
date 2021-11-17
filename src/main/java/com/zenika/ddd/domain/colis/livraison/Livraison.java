package com.zenika.ddd.domain.colis.livraison;

import com.zenika.ddd.domain.garagiste.Garagiste;

import java.util.Objects;

public class Livraison {

    private final Garagiste garagiste;
    private final Livreur livreur;
    private final DateDeLivraison dateDeLivraison;

    public Livraison(Garagiste garagiste, Livreur livreur, DateDeLivraison dateDeLivraison) {
        this.garagiste = garagiste;
        this.livreur = livreur;
        this.dateDeLivraison = dateDeLivraison;
    }

    public Garagiste getGaragiste() {
        return garagiste;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Livraison livraison = (Livraison) o;
        return Objects.equals(garagiste, livraison.garagiste) && Objects.equals(livreur, livraison.livreur) && Objects.equals(dateDeLivraison, livraison.dateDeLivraison);
    }

    @Override
    public int hashCode() {
        return Objects.hash(garagiste, livreur, dateDeLivraison);
    }

}
