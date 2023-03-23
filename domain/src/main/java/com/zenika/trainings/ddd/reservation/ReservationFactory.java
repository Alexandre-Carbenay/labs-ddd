package com.zenika.trainings.ddd.reservation;

import java.util.UUID;

public class ReservationFactory {
    public static Reservation create(ReserverSalle reserverSalle) {
        return new Reservation(new IdentifiantReservation(UUID.randomUUID()), reserverSalle.organisateur(), reserverSalle.referenceSalle(), reserverSalle.creneauHoraire(), EtatReservation.ACCEPTEE);
    }
}
