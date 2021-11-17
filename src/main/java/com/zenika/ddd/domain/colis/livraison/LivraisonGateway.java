package com.zenika.ddd.domain.colis.livraison;

import com.zenika.ddd.domain.colis.Colis;
import com.zenika.ddd.domain.commande.ModeDeLivraison;
import com.zenika.ddd.domain.garagiste.Garagiste;

public interface LivraisonGateway {

    Livraison prevoirLivraisonPourUnColis(Colis colis, Garagiste garagiste, ModeDeLivraison modeDeLivraison);

}
