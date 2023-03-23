package com.zenika.trainings.ddd.reservation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

public class ReservationFactoryTest {

    @Test
    public void reservationCorrectementInitialisee() {
        var salle = new Salle(new ReferenceSalle("toto"));
        var organisateur = new Organisateur("tutu");
        var creneauHoraire = new CreneauHoraire(LocalDateTime.now(), LocalDateTime.now().plusMinutes(45));
        var reservation = ReservationFactory.create(salle, organisateur, creneauHoraire);

        Assertions.assertThat(reservation.etat()).isEqualTo(EtatReservation.ACCEPTEE);
        Assertions.assertThat(reservation.identifiant()).isNotNull();
    }


}
