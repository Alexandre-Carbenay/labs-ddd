package com.zenika.trainings.ddd.reservation;

import java.util.ArrayList;
import java.util.List;

public class FakeReservationRepository implements ReservationRepository {

    private final List<Reservation> reservation = new ArrayList<>();

    @Override
    public void sauvegarder(Reservation reservation) {
        this.reservation.add(reservation);
    }

    public Reservation donne() {
        return this.reservation.get(this.reservation.size() - 1);
    }

    public List<Reservation> donneTout() {
        return List.copyOf(reservation);
    }
}
