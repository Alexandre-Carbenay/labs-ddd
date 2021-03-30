package com.zenika.ddd.domain.reception;

public class CreerReceptionService {

    private final AvisExpeditionGateway avisExpeditionGateway;
    private final ReceptionRepository receptionRepository;

    public CreerReceptionService(AvisExpeditionGateway avisExpeditionGateway, ReceptionRepository receptionRepository) {
        this.avisExpeditionGateway = avisExpeditionGateway;
        this.receptionRepository = receptionRepository;
    }

    public void creerAPartirDe(IdExpedition idExpedition) {
        var avisExpedition = avisExpeditionGateway.recupererAvisExpedition(idExpedition);
        var reception = new Reception(ReceptionId.newId(), avisExpedition);
        receptionRepository.save(reception);
    }

}
