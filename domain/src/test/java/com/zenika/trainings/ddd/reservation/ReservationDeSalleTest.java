package com.zenika.trainings.ddd.reservation;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertThrows;


class ReservationDeSalleTest {


    private ReservationDeSalle reservationDeSalle;
    private FakeReservationRepository fakeReservationRepository;

    @BeforeEach
    public void initialiserTests() {
        fakeReservationRepository = new FakeReservationRepository();
        reservationDeSalle = new ReservationDeSalle(fakeReservationRepository);
    }

    @Test
    public void verifierEvenementDeReservationAcceptee() throws ReservationRefuseeException {
        var referenceSalle = new ReferenceSalle("toto");
        var organisateur = new Organisateur("tutu");
        var creneauHoraire = new CreneauHoraire(LocalDateTime.now(), LocalDateTime.now().plusMinutes(45));

        var reserverSalle = new ReserverSalle(referenceSalle, creneauHoraire,organisateur);

        var salleReservee = reservationDeSalle.reserverSalle(reserverSalle);

        Assertions.assertThat(salleReservee).isNotNull();
        Assertions.assertThat(salleReservee.identifiant()).isNotNull();
        Assertions.assertThat(salleReservee.identifiant()).isEqualTo(fakeReservationRepository.donne().identifiant());
    }

    @Test
    public void verifierPasDeReservationSurLeCreneauHoraireDeLaSalleQueLonSouhaiteReserver() {
        var referenceSalle = new ReferenceSalle("toto");
        var organisateur = new Organisateur("tutu");
        var creneauHoraire = new CreneauHoraire(LocalDateTime.now(), LocalDateTime.now().plusMinutes(45));

        var reserverSalle = new ReserverSalle(referenceSalle, creneauHoraire,organisateur);
        var reservationExistante = ReservationFactory.create(reserverSalle);
        fakeReservationRepository.sauvegarder(reservationExistante);

        assertThrows(ReservationRefuseeException.class, () -> reservationDeSalle.reserverSalle(reserverSalle));
    }

    @Test
    public void verifierReservationPossibleMemeCreneauHoraireMaisSalleDifferent() throws ReservationRefuseeException {
        var referenceSalle = new ReferenceSalle("toto");
        var organisateur = new Organisateur("tutu");
        var creneauHoraire = new CreneauHoraire(LocalDateTime.now(), LocalDateTime.now().plusMinutes(45));
        var reserverSalle = new ReserverSalle(referenceSalle, creneauHoraire,organisateur);
        var reservationExistante = ReservationFactory.create(reserverSalle);
        fakeReservationRepository.sauvegarder(reservationExistante);

        var nouvelleReferenceSalle = new ReferenceSalle("bob");
        var nouvelReserverSalle = new ReserverSalle(nouvelleReferenceSalle, creneauHoraire, organisateur);
        var salleReservee = reservationDeSalle.reserverSalle(nouvelReserverSalle);

        Assertions.assertThat(salleReservee).isNotNull();
        Assertions.assertThat(salleReservee.identifiant()).isNotNull();
        Assertions.assertThat(salleReservee.identifiant()).isEqualTo(fakeReservationRepository.donne().identifiant());
    }

    //TODO:  Tester non existence d'une salle
}