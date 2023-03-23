package com.zenika.trainings.ddd.reservation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;


class ReservationDeSalleTest {

    @Test
    public void verifierEvenementDeReservationAcceptee() {
        ReservationDeSalle reservationDeSalle = new ReservationDeSalle();

        var referenceSalle = new ReferenceSalle("toto");
        var organisateur = new Organisateur("tutu");
        var creneauHoraire = new CreneauHoraire(LocalDateTime.now(), LocalDateTime.now().plusMinutes(45));

        var reserverSalle = new ReserverSalle(referenceSalle, creneauHoraire,organisateur);

        var salleReservee = reservationDeSalle.reserverSalle(reserverSalle);

        Assertions.assertThat(salleReservee).isNotNull();
        Assertions.assertThat(salleReservee.identifiant()).isNotNull();
    }

}