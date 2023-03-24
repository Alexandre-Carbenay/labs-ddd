package com.zenika.trainings.ddd.reservation;

import java.util.List;

public interface ReservationRepository {

    void sauvegarder(Reservation reservation);

    List<Reservation> donneTout();
}
