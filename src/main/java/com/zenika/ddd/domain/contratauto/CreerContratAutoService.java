package com.zenika.ddd.domain.contratauto;

public class CreerContratAutoService {
    private final CouvertureAssurantielleGateway couvertureAssurantielleGateway;
    private final VehiculeGateway vehiculeGateway;
    private final ContratAutoRepository contratAutoRepository;

    public CreerContratAutoService(CouvertureAssurantielleGateway couvertureAssurantielleGateway, VehiculeGateway vehiculeGateway, ContratAutoRepository contratAutoRepository) {
        this.couvertureAssurantielleGateway = couvertureAssurantielleGateway;
        this.vehiculeGateway = vehiculeGateway;
        this.contratAutoRepository = contratAutoRepository;
    }

    public ContratAuto creerContrat(CouvertureAssurantielleId idCouvertureAssurantielle,
                                    Immatriculation immatriculation,
                                    ConducteurPrincipal conducteurPrincipal) {
        CouvertureAssurantielle couvertureAssurantielle = couvertureAssurantielleGateway.findById(idCouvertureAssurantielle);
        Vehicule vehicule = vehiculeGateway.findByImmatriculation(immatriculation);

        ContratAuto contratAuto = new ContratAuto(contratAutoRepository.generateId(), couvertureAssurantielle, vehicule, conducteurPrincipal);
        contratAutoRepository.save(contratAuto);
        return contratAuto;
    }
}
