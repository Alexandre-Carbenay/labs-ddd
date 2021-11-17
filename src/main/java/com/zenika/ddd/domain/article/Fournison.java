package com.zenika.ddd.domain.article;

public class Fournison {

    private final Article article;
    private final Quantite quantite;
    private final DateDeDisponibilite dateDeDisponibilite;

    public Fournison(Article article, Quantite quantite, DateDeDisponibilite dateDeDisponibilite) {
        this.article = article;
        this.quantite = quantite;
        this.dateDeDisponibilite = dateDeDisponibilite;
    }

}
