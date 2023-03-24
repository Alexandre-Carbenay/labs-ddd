package com.zenika.trainings.ddd.reservation;

public class ReservationRefuseeException extends Exception {

    private final ReserverSalle reserverSalle;

    public ReservationRefuseeException(ReserverSalle reserverSalle) {
        this.reserverSalle = reserverSalle;
    }

    public ReserverSalle getReserverSalle() {
        return reserverSalle;
    }
}
