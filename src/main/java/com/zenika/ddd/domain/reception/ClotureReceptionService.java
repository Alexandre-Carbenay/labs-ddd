package com.zenika.ddd.domain.reception;

public class ClotureReceptionService {

    private ReceptionRepository repository;
//    private InitieOrdreDePreparationService initieOrdreDePreparationService;

    public void cloture(ReceptionId receptionId) {
        Reception reception = repository.find(receptionId);
        reception.cloture();
//        initieOrdreDePreparationService.initieOrdreDePreparation();
    }

}
