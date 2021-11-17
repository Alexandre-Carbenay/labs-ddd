package com.zenika.ddd.domain.colis.livraison;

import java.time.LocalDateTime;

public class DateDeLivraison {

    private final LocalDateTime date;

    public DateDeLivraison(LocalDateTime date) {
        if (date.isBefore(LocalDateTime.now())) {
            throw new IllegalArgumentException("La date de livraison doit être dans le futur");
        }
        this.date = date;
    }
}
