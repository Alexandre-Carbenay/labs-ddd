package com.zenika.ddd.domain.colis;

import com.zenika.ddd.domain.colis.livraison.Livraison;
import com.zenika.ddd.domain.garagiste.Garagiste;

import java.util.List;
import java.util.Objects;

public class Colis {

    private ColisId id;
    private List<LigneDeColis> lignesDeColis;
    private ColisStatut statut;
    private Livraison livraison;

    public Colis(ColisId id, List<LigneDeColis> lignesDeColis) {
        if (lignesDeColis.isEmpty()) {
            throw new IllegalArgumentException("Le colis doit avoir au moins 1 ligne");
        }
        this.id = id;
        this.lignesDeColis = lignesDeColis;
        statut = ColisStatut.EN_PREPARATION;
    }

    public void prevoirLivraisonDuColis(Livraison livraison) {
        this.livraison = livraison;
        statut = ColisStatut.LIVRAISON_PREVUE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colis colis = (Colis) o;
        return Objects.equals(id, colis.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
