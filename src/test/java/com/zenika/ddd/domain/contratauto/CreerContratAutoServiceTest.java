package com.zenika.ddd.domain.contratauto;

import com.zenika.ddd.infrastructure.contratauto.InMemoryContratAutoRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

public class CreerContratAutoServiceTest {
    @Test
    void testCalculerCotisation() {
        String idCouvertureAssurantielle = "123";
        String immatriculation = "aa-123-aa";

        var couvertureAssurantielleGateway = Mockito.mock(CouvertureAssurantielleGateway.class);
        var vehiculeGateway = Mockito.mock(VehiculeGateway.class);
        var contratAutoRepository = new InMemoryContratAutoRepository();

        var couvertureAssurantielle = new CouvertureAssurantielle(idCouvertureAssurantielle, Montant.euros(100.0));
        given(couvertureAssurantielleGateway.findById(idCouvertureAssurantielle)).willReturn(couvertureAssurantielle);

        var vehicule = new Vehicule(ClasseVehicule.MOYEN);
        given(vehiculeGateway.findByImmatriculation(immatriculation)).willReturn(vehicule);

        var service = new CreerContratAutoService(couvertureAssurantielleGateway, vehiculeGateway, contratAutoRepository);
        ConducteurPrincipal conducteurPrincipal = new ConducteurPrincipal(Coefficient.of(0.5));

        var contratAuto = service.creerContrat(idCouvertureAssurantielle, immatriculation, conducteurPrincipal);

        assertThat(contratAuto.getCotisationAnnuelle()).isEqualTo(Montant.euros(100.0));
        assertThat(contratAutoRepository.findById(contratAuto.getId())).isNotNull();
    }
}
