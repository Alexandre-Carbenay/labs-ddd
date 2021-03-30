package com.zenika.ddd.domain.reception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Reception {

    private final ReceptionId receptionId;
    private final AvisExpedition avisExpedition;
    private StatutReception statut;
    private List<Marchandise> lignesReception;

    public Reception(ReceptionId receptionId, AvisExpedition avisExpedition) {
        this.receptionId = receptionId;
        this.avisExpedition = avisExpedition;
        this.statut = StatutReception.OUVERTE;
        this.lignesReception = new ArrayList<>();
    }

    public AvisExpedition getAvisExpedition() {
        return avisExpedition;
    }

    public StatutReception getStatut() {
        return statut;
    }

    public void ajouterLigne(Marchandise marchandise) {

        if (!this.avisExpedition.contientLigne(marchandise)) {
            throw new MarchandiseInconnue(marchandise.getSKU());
        }
        this.lignesReception.add(marchandise);
    }

    public List<Marchandise> getLignesReception() {
        return Collections.unmodifiableList(lignesReception);
    }

    public void cloture() {
        if (!lignesReception.containsAll(avisExpedition.getLignes()) ) {
            throw new EcartEnReception();
        }
        this.statut = StatutReception.CLOTURER;

    }
}
