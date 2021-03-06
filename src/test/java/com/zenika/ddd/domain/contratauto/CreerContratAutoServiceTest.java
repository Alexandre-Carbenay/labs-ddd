package com.zenika.ddd.domain.contratauto;

import com.zenika.ddd.infrastructure.contratauto.InMemoryContratAutoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

public class CreerContratAutoServiceTest {
    @Test
    void testCalculerCotisation() {
        CouvertureAssurantielleId idCouvertureAssurantielle = new CouvertureAssurantielleId("123");
        Immatriculation immatriculation = new Immatriculation("aa-123-aa");

        CouvertureAssurantielleGateway couvertureAssurantielleGateway = Mockito.mock(CouvertureAssurantielleGateway.class);
        VehiculeGateway vehiculeGateway = Mockito.mock(VehiculeGateway.class);
        ContratAutoRepository contratAutoRepository = new InMemoryContratAutoRepository();

        CouvertureAssurantielle couvertureAssurantielle = new CouvertureAssurantielle(idCouvertureAssurantielle, Montant.euros(100.0));
        given(couvertureAssurantielleGateway.findById(idCouvertureAssurantielle)).willReturn(couvertureAssurantielle);

        Vehicule vehicule = new Vehicule(immatriculation, ClasseVehicule.MOYEN);
        given(vehiculeGateway.findByImmatriculation(immatriculation)).willReturn(vehicule);

        CreerContratAutoService service = new CreerContratAutoService(couvertureAssurantielleGateway, vehiculeGateway, contratAutoRepository);
        ConducteurPrincipal conducteurPrincipal = new ConducteurPrincipal(Coefficient.of(0.5));

        ContratAuto contratAuto = service.creerContrat(idCouvertureAssurantielle, immatriculation, conducteurPrincipal);

        assertThat(contratAuto.getCotisationAnnuelle()).isEqualTo(Montant.euros(100.0));
        assertThat(contratAutoRepository.findById(contratAuto.getId())).isNotNull();
    }
}
