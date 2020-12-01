package com.zenika.ddd.domain.contratauto;

import com.zenika.ddd.infrastructure.contratauto.InMemoryContratAutoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

public class MettreAJourContratAutoServiceTest {

    @Test
    void testMettreAjourContrat() {
        String idCouvertureAssurantielle = "123";
        String immatriculation = "aa-123-aa";
        String idContrat = "1";

        CouvertureAssurantielleGateway couvertureAssurantielleGateway = Mockito.mock(CouvertureAssurantielleGateway.class);
        VehiculeGateway vehiculeGateway = Mockito.mock(VehiculeGateway.class);
        ContratAutoRepository contratAutoRepository = new InMemoryContratAutoRepository();

        contratAutoRepository.save(new ContratAuto(new CouvertureAssurantielle(idCouvertureAssurantielle, Montant.euros(100.0)),
                new Vehicule(immatriculation, ClasseVehicule.HAUT), new ConducteurPrincipal(Coefficient.of(0.5))));

        CouvertureAssurantielle couvertureAssurantielle = new CouvertureAssurantielle(idCouvertureAssurantielle, Montant.euros(120.0));
        given(couvertureAssurantielleGateway.findById(idCouvertureAssurantielle)).willReturn(couvertureAssurantielle);

        Vehicule vehicule = new Vehicule(immatriculation, ClasseVehicule.HAUT);
        given(vehiculeGateway.findByImmatriculation(immatriculation)).willReturn(vehicule);

        MettreAJourContratAutoService service = new MettreAJourContratAutoService(couvertureAssurantielleGateway, vehiculeGateway, contratAutoRepository);

        service.mettreAJourContrat(idContrat);

        assertThat(contratAutoRepository.findById(idContrat).getCotisationAnnuelle()).isEqualTo(Montant.euros(180.0));
    }
}
