package com.zenika.ddd.domain.contratauto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.zenika.ddd.domain.contratauto.ClasseVehicule.HAUT;
import static com.zenika.ddd.domain.contratauto.ClasseVehicule.MOYEN;
import static org.assertj.core.api.Assertions.assertThat;

public class ContratAutoTest {

    @ParameterizedTest
    @MethodSource("calculCoefficients")
    void cotisationAttendueALaCreation(Montant montantForfaitaire,
                                       ClasseVehicule classeVehicule,
                                       Coefficient coefficientConducteurPrincipal,
                                       Montant cotisationAnnuelle) {

        var couvertureAssurantielle = new CouvertureAssurantielle("ca123", montantForfaitaire);

        Vehicule vehicule = new Vehicule(classeVehicule);
        ConducteurPrincipal conducteurPrincipal = new ConducteurPrincipal(coefficientConducteurPrincipal);

        var contratAuto = new ContratAuto(couvertureAssurantielle, vehicule, conducteurPrincipal);
        assertThat(contratAuto.getCotisationAnnuelle()).isEqualTo(cotisationAnnuelle);
    }

    static Stream<Arguments> calculCoefficients() {
        return Stream.of(
                Arguments.of(Montant.euros(100.0), MOYEN, Coefficient.of(0.5), Montant.euros(100.0)),
                Arguments.of(Montant.euros(100.0), HAUT,  Coefficient.of(1.5), Montant.euros(450.0)));
    }

}
