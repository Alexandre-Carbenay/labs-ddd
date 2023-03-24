package com.zenika.trainings.ddd.reservation;

public class Reservation {

    public Reservation(IdentifiantReservation identifiant, Organisateur organisateur, ReferenceSalle referenceSalle, CreneauHoraire creneauHoraire, EtatReservation etat) {
        this.identifiant = identifiant;
        this.organisateur = organisateur;
        this.referenceSalle = referenceSalle;
        this.creneauHoraire = creneauHoraire;
        this.etat = etat;
    }

    private IdentifiantReservation identifiant;

    private Organisateur organisateur;

    private ReferenceSalle referenceSalle;

    private CreneauHoraire  creneauHoraire;

    private EtatReservation etat;

    public EtatReservation etat() {
        return etat;
    }

    public IdentifiantReservation identifiant() {
        return identifiant;
    }

    public boolean estEnConflitAvec(Reservation reservation) {
        return this.referenceSalle.equals(reservation.referenceSalle) && this.creneauHoraire.chevauche(reservation.creneauHoraire);
    }
}
