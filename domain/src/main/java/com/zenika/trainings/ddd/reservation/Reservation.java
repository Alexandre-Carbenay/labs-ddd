package com.zenika.trainings.ddd.reservation;

public class Reservation {

    public Reservation(IdentifiantReservation identifiant, Organisateur organisateur, Salle salle, CreneauHoraire creneauHoraire, EtatReservation etat) {
        this.identifiant = identifiant;
        this.organisateur = organisateur;
        this.salle = salle;
        this.creneauHoraire = creneauHoraire;
        this.etat = etat;
    }

    private IdentifiantReservation identifiant;

    private Organisateur organisateur;

    private Salle salle;

    private CreneauHoraire  creneauHoraire;

    private EtatReservation etat;

    public EtatReservation etat() {
        return etat;
    }

    public IdentifiantReservation identifiant() {
        return identifiant;
    }
}
