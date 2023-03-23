package com.zenika.trainings.ddd.reservation;

import java.time.Duration;
import java.time.LocalDateTime;

public record CreneauHoraire(LocalDateTime debut, LocalDateTime fin) {

    public static final Duration DUREE_MINIMUM = Duration.ofMinutes(15);

    public CreneauHoraire {
        if (debut.plus(DUREE_MINIMUM).isAfter(fin)) {
            throw new CreneauHoraireInvalideException();
        }
    }

    public boolean chevauche(CreneauHoraire autre) {
        return this.fin.isAfter(autre.debut) && this.debut.isBefore(autre.fin);
    }

}
