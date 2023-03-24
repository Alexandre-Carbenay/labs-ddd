package com.zenika.trainings.ddd.reservation;

public class ReservationDeSalle {

    private final ReservationRepository repository;

    public ReservationDeSalle(ReservationRepository repository) {
        this.repository = repository;
    }

    public ReservationAcceptee reserverSalle(ReserverSalle reserverSalle) throws ReservationRefuseeException {
        var reservation = ReservationFactory.create(reserverSalle);
        var toutesLesReservations = repository.donneTout();
        if (toutesLesReservations.stream().anyMatch(reservation::estEnConflitAvec)) {
            throw new ReservationRefuseeException(reserverSalle);
        }
        repository.sauvegarder(reservation);
        return new ReservationAcceptee(reservation.identifiant());
    }
}
