package com.zenika.ddd.domain.contratauto;

public interface VehiculeGateway {
    Vehicule findByImmatriculation(Immatriculation immatriculation);
}
