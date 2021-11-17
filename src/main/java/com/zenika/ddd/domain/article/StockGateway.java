package com.zenika.ddd.domain.article;

import com.zenika.ddd.domain.commande.LigneDeCommande;

import java.util.List;

public interface StockGateway {

    List<Fournison> calculerFournisonsPour(LigneDeCommande ligneDeCommande);

}
