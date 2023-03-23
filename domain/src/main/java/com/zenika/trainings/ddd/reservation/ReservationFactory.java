package com.zenika.trainings.ddd.reservation;

import java.util.UUID;

public class ReservationFactory {
    public static Reservation create(Salle salle, Organisateur organisateur, CreneauHoraire creneauHoraire) {
        return new Reservation(new IdentifiantReservation(UUID.randomUUID()),  organisateur, salle,creneauHoraire, EtatReservation.ACCEPTEE);
    }
}
