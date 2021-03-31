package com.zenika.ddd.domain.reception;

import com.zenika.ddd.domain.EventBus;

public class CreerReceptionService {

    private final AvisExpeditionGateway avisExpeditionGateway;
    private final ReceptionRepository receptionRepository;
    private final EventBus eventBus;

    public CreerReceptionService(AvisExpeditionGateway avisExpeditionGateway, ReceptionRepository receptionRepository, EventBus eventBus) {
        this.avisExpeditionGateway = avisExpeditionGateway;
        this.receptionRepository = receptionRepository;
        this.eventBus = eventBus;
    }

    public void creerAPartirDe(IdExpedition idExpedition) {
        var avisExpedition = avisExpeditionGateway.recupererAvisExpedition(idExpedition);
        var reception = new Reception(ReceptionId.newId(), avisExpedition);
        receptionRepository.save(reception);
        eventBus.emit(new ReceptionCreee(reception.getReceptionId()));
    }

}
