package com.zenika.ddd.domain.reception;

public class Reception {

    private final ReceptionId receptionId;
    private final AvisExpedition avisExpedition;
    private StatutReception statut;

    public Reception(ReceptionId receptionId, AvisExpedition avisExpedition) {
        this.receptionId = receptionId;
        this.avisExpedition = avisExpedition;
        this.statut = StatutReception.OUVERTE;
    }

    public AvisExpedition getAvisExpedition() {
        return avisExpedition;
    }

    public StatutReception getStatut() {
        return statut;
    }
}
