package com.zenika.ddd.domain.colis;

import com.zenika.ddd.domain.article.Article;
import com.zenika.ddd.domain.article.Quantite;

public class LigneDeColis {

    private final Article article;
    private final Quantite quantite;

    public LigneDeColis(Article article, Quantite quantite) {
        this.article = article;
        this.quantite = quantite;
    }

}
