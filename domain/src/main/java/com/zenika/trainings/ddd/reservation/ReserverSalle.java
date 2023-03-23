package com.zenika.trainings.ddd.reservation;

public record ReserverSalle(ReferenceSalle referenceSalle, CreneauHoraire creneauHoraire, Organisateur organisateur) {
}
