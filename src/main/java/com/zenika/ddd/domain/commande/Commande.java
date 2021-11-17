package com.zenika.ddd.domain.commande;

import com.zenika.ddd.domain.garagiste.Garagiste;

import java.util.Collections;
import java.util.List;

public class Commande {

    private CommandeId id;
    private Garagiste garagiste;
    private ModeDeLivraison modeDeLivraison;
    private ModeDePackaging modeDePackaging;
    private List<LigneDeCommande> lignesDeCommande;

    public Garagiste getGaragiste() {
        return garagiste;
    }

    public ModeDeLivraison getModeDeLivraison() {
        return modeDeLivraison;
    }

    public List<LigneDeCommande> getLignesDeCommande() {
        return Collections.unmodifiableList(lignesDeCommande);
    }

    public Commande(CommandeId id, Garagiste garagiste, ModeDeLivraison modeDeLivraison, ModeDePackaging modeDePackaging, List<LigneDeCommande> lignesDeCommande) {
        if (lignesDeCommande.isEmpty()) {
            throw new IllegalArgumentException("Une commande doit avoir au moins une ligne");
        }
        this.id = id;
        this.garagiste = garagiste;
        this.modeDeLivraison = modeDeLivraison;
        this.modeDePackaging = modeDePackaging;
        this.lignesDeCommande = lignesDeCommande;
    }

}
