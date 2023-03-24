package com.zenika.trainings.ddd.reservation;

public class ReservationDeSalle {

    private final ReservationRepository repository;
    private final ReferentielImmobilier referentielImmobilier;

    public ReservationDeSalle(ReservationRepository repository, ReferentielImmobilier referentielImmobilier) {
        this.repository = repository;
        this.referentielImmobilier = referentielImmobilier;
    }

    public ReservationAcceptee reserverSalle(ReserverSalle reserverSalle) throws ReservationRefuseeException {
        var reservation = ReservationFactory.create(reserverSalle);
        verifierConflitDeReservation(reserverSalle, reservation);
        verifierExistenceDeLaSalle(reserverSalle);
        repository.sauvegarder(reservation);
        return new ReservationAcceptee(reservation.identifiant());
    }

    private void verifierConflitDeReservation(ReserverSalle reserverSalle, Reservation reservation) throws ReservationRefuseeException {
        var toutesLesReservations = repository.donneTout();
        if (toutesLesReservations.stream().anyMatch(reservation::estEnConflitAvec)) {
            throw new ReservationRefuseeException(reserverSalle);
        }
    }

    private void verifierExistenceDeLaSalle(ReserverSalle reserverSalle) throws ReservationRefuseeException {
        var laSalle = referentielImmobilier.trouveLaSalle(reserverSalle.referenceSalle());
        if (laSalle.isEmpty()) {
            throw new ReservationRefuseeException(reserverSalle);
        }
    }


}
