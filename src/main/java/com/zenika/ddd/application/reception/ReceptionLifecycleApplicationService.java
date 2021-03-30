package com.zenika.ddd.application.reception;

import com.zenika.ddd.domain.reception.*;

public class ReceptionLifecycleApplicationService {

    private CreerReceptionService creerReceptionService;

    public ReceptionLifecycleApplicationService(CreerReceptionService creerReceptionService) {
        this.creerReceptionService = creerReceptionService;
    }

    public void creerReception(IdExpedition idExpedition) {
        creerReceptionService.creerAPartirDe(idExpedition);
    }

}
