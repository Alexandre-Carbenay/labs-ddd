package com.zenika.trainings.ddd.reservation;

public class ReservationDeSalle {

    public ReservationAcceptee reserverSalle(ReserverSalle reserverSalle) {
        var reservation = ReservationFactory.create(reserverSalle);
        return new ReservationAcceptee(reservation.identifiant());
    }
}
