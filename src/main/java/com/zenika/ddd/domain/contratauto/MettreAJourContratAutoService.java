package com.zenika.ddd.domain.contratauto;

import com.zenika.ddd.domain.event.EventBus;
import org.springframework.stereotype.Service;

@Service
public class MettreAJourContratAutoService {

    private final CouvertureAssurantielleGateway couvertureAssurantielleGateway;
    private final VehiculeGateway vehiculeGateway;
    private final ContratAutoRepository contratAutoRepository;
    private final EventBus eventBus;

    public MettreAJourContratAutoService(
            CouvertureAssurantielleGateway couvertureAssurantielleGateway,
            VehiculeGateway vehiculeGateway,
            ContratAutoRepository contratAutoRepository,
            EventBus eventBus) {
        this.couvertureAssurantielleGateway = couvertureAssurantielleGateway;
        this.vehiculeGateway = vehiculeGateway;
        this.contratAutoRepository = contratAutoRepository;
        this.eventBus = eventBus;
    }

    public void mettreAJourContrat(ContratAutoId idContrat) {
        ContratAuto contrat = contratAutoRepository.findById(idContrat);
        CouvertureAssurantielle couvertureAssurantielle = couvertureAssurantielleGateway.findById(contrat.getCouvertureAssurantielle().getId());
        Vehicule vehicule = vehiculeGateway.findByImmatriculation(contrat.getVehicule().getImmatriculation());
        CotisationContratAutoMiseAJour evenement = contrat.miseAJour(couvertureAssurantielle, vehicule, contrat.getConducteurPrincipal());
        eventBus.emit(evenement);
    }

}
