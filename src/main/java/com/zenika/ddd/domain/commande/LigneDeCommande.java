package com.zenika.ddd.domain.commande;

import com.zenika.ddd.domain.article.Article;
import com.zenika.ddd.domain.article.Quantite;
import com.zenika.ddd.domain.colis.LigneDeColis;

import java.util.Optional;

public class LigneDeCommande {

    private LigneDeCommandeId id;
    private Article article;
    private Quantite quantite;

    public LigneDeCommande(LigneDeCommandeId id, Article article, Quantite quantite) {
        this.id = id;
        this.article = article;
        this.quantite = quantite;
    }

    public Article getArticle() {
        return article;
    }

    public Quantite getQuantite() {
        return quantite;
    }

    public boolean aUneQuantiteSuffisante(Quantite quantiteDisponible) {
        return quantiteDisponible.estSuffisante(quantite);
    }

    public Optional<LigneDeColis> prevoirLigneDeColis(Quantite quantiteDisponible) {
        if (quantiteDisponible.nestPasSuffisante(quantite)) {
            // si la quantite n'est pas disponible, il faut prévoir une fournison
            if (quantiteDisponible.nonNulle()) {
                return Optional.of(new LigneDeColis(article, quantiteDisponible));
            }
        } else {
            // sinon, on essaie de regrouper les articles dans un même colis
            return Optional.of(new LigneDeColis(article, quantite));
        }
        return Optional.empty();
    }

}
