package com.zenika.ddd.pickingcommandeclient.domain.cheminderamasse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CheminDeRamasse {

    private final CheminDeRamasseId id;
    private List<Etape> etapes = new ArrayList<>();

    public CheminDeRamasse(CheminDeRamasseId id, Commande commande, List<AdresseDeStockage> adresses) {
        this.id = id;
        etapes = adresses.stream()
                .map(adresse -> new Etape(1, commande, adresse))
                .collect(Collectors.toList());
    }

    public List<Etape> getEtapes() {
        return this.etapes;
    }

}
