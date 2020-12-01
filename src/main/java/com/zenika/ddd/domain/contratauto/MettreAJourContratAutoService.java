package com.zenika.ddd.domain.contratauto;

import org.springframework.stereotype.Service;

@Service
public class MettreAJourContratAutoService {

    private final CouvertureAssurantielleGateway couvertureAssurantielleGateway;
    private final VehiculeGateway vehiculeGateway;
    private final ContratAutoRepository contratAutoRepository;

    public MettreAJourContratAutoService(CouvertureAssurantielleGateway couvertureAssurantielleGateway, VehiculeGateway vehiculeGateway, ContratAutoRepository contratAutoRepository) {
        this.couvertureAssurantielleGateway = couvertureAssurantielleGateway;
        this.vehiculeGateway = vehiculeGateway;
        this.contratAutoRepository = contratAutoRepository;
    }

    public void mettreAJourContrat(ContratAutoId idContrat) {
        ContratAuto contrat = contratAutoRepository.findById(idContrat);
        CouvertureAssurantielle couvertureAssurantielle = couvertureAssurantielleGateway.findById(contrat.getCouvertureAssurantielle().getId());
        Vehicule vehicule = vehiculeGateway.findByImmatriculation(contrat.getVehicule().getImmatriculation());
        contrat.miseAJour(couvertureAssurantielle, vehicule, contrat.getConducteurPrincipal());
    }

}
