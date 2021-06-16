package com.zenika.ddd.pickingcommandeclient.domain.cheminderamasse;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CalculerCheminDeRamasse {

    private final AdresseDeStockageGateway adresseDeStockageGateway;
    private final CheminDeRamasseRepository cheminDeRamasseRepository;

    public CalculerCheminDeRamasse(AdresseDeStockageGateway adresseDeStockageGateway, CheminDeRamasseRepository cheminDeRamasseRepository) {
        this.adresseDeStockageGateway = adresseDeStockageGateway;
        this.cheminDeRamasseRepository = cheminDeRamasseRepository;
    }

    public List<CheminDeRamasse> invoquer(Commande commande) {
        List<AdresseDeStockage> adressesDeStockage = commande.getLignesDeCommande().stream()
                .map(ligneDeCommande -> adresseDeStockageGateway.getAdresseDuProduit(ligneDeCommande.getProduitId()))
                .collect(Collectors.toList());

        List<CheminDeRamasse> cheminsDeRamasse = new ArrayList<>();
        cheminsDeRamasse.add(new CheminDeRamasse(new CheminDeRamasseId(1), commande, adressesDeStockage));
        cheminDeRamasseRepository.save(cheminsDeRamasse);
        return cheminsDeRamasse;
    }

}
