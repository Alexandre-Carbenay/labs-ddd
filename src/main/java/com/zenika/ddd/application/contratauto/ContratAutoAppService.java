package com.zenika.ddd.application.contratauto;

import com.zenika.ddd.domain.contratauto.*;
import org.springframework.stereotype.Service;

@Service
public class ContratAutoAppService {

    private final CreerContratAutoService creerContratAutoService;
    private final MettreAJourContratAutoService mettreAJourContratAutoService;

    public ContratAutoAppService(CreerContratAutoService creerContratAutoService, MettreAJourContratAutoService mettreAJourContratAutoService) {
        this.creerContratAutoService = creerContratAutoService;
        this.mettreAJourContratAutoService = mettreAJourContratAutoService;
    }

    public void creerContrat(CouvertureAssurantielleId idCouvertureAssurantielle,
                             Immatriculation immatriculation,
                             ConducteurPrincipal conducteurPrincipal) {
        creerContratAutoService.creerContrat(idCouvertureAssurantielle, immatriculation, conducteurPrincipal);
    }

    public void mettreAJourContrat(ContratAutoId idContrat) {
        mettreAJourContratAutoService.mettreAJourContrat(idContrat);
    }

}
