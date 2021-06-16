package com.zenika.ddd.pickingcommandeclient.application.cheminderamasse;

import com.zenika.ddd.pickingcommandeclient.domain.cheminderamasse.*;

import java.util.List;

@Transactional
public class CheminDeRamasseAppService {

    private CheminDeRamasseRepository repository;
    private CalculerCheminDeRamasse calculerCheminDeRamasse;

    public List<CheminDeRamasse> getCheminsDeRamasse() {
        return repository.findAll();
    }

    public Etape getEtapeSuivante(CheminDeRamasseId id) {
        CheminDeRamasse cheminDeRamasse = repository.find(id);
        return cheminDeRamasse.getEtapeSuivante();
    }

    public List<CheminDeRamasse> calculerCheminsDeRamasse(Commande commande) {
        return calculerCheminDeRamasse.invoquer(commande);
    }

}
