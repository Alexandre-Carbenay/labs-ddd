package com.zenika.trainings.ddd.reservation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

class ChevauchementCreneauHoraireTest {

    @Test
    void unCreneauHoraireEstInclusDansUnAutre() {
        var creneauHoraire = new CreneauHoraire(LocalDateTime.now(), LocalDateTime.now().plusMinutes(20));
        var creneauHoraireInclus = new CreneauHoraire(LocalDateTime.now(), LocalDateTime.now().plusMinutes(20));

        Assertions.assertThat(creneauHoraire.chevauche(creneauHoraireInclus)).isTrue();
        Assertions.assertThat(creneauHoraireInclus.chevauche(creneauHoraire)).isTrue();
    }

    @Test
    void unCreneauHoraireChevauchePartiellement() {
        var creneauHoraire = new CreneauHoraire(LocalDateTime.now(), LocalDateTime.now().plusMinutes(20));
        var creneauHorairePartiellementChevauche = new CreneauHoraire(LocalDateTime.now().minusMinutes(10), LocalDateTime.now().plusMinutes(10));

        Assertions.assertThat(creneauHoraire.chevauche(creneauHorairePartiellementChevauche)).isTrue();
        Assertions.assertThat(creneauHorairePartiellementChevauche.chevauche(creneauHoraire)).isTrue();
    }

    @Test
    void creneauxHoraireStrictementDisjoints() {
        var creneauHoraireA = new CreneauHoraire(LocalDateTime.now(), LocalDateTime.now().plusMinutes(20));
        var creneauHoraireB = new CreneauHoraire(LocalDateTime.now().minusMinutes(30), LocalDateTime.now().minusMinutes(10));

        Assertions.assertThat(creneauHoraireA.chevauche(creneauHoraireB)).isFalse();
        Assertions.assertThat(creneauHoraireB.chevauche(creneauHoraireA)).isFalse();
    }

    @Test
    void creneauxHorairesSeSuivent() {
        LocalDateTime now = LocalDateTime.now();
        var creneauHoraireA = new CreneauHoraire(now, now.plusMinutes(20));
        var creneauHoraireB = new CreneauHoraire(now.plusMinutes(20), now.plusMinutes(50));

        Assertions.assertThat(creneauHoraireA.chevauche(creneauHoraireB)).isFalse();
        Assertions.assertThat(creneauHoraireB.chevauche(creneauHoraireA)).isFalse();
    }
}
