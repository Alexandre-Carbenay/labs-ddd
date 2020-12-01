package com.zenika.ddd.domain.contratauto;

import org.junit.jupiter.api.Test;

import static com.zenika.ddd.domain.contratauto.ClasseVehicule.MOYEN;
import static org.assertj.core.api.Assertions.assertThat;

public class ContratAutoTest {

    @Test
    void cotisationAttendueALaCreation() {

        var couvertureAssurantielle = new CouvertureAssurantielle("ca123", 100.0);

        ClasseVehicule classeVehicule = MOYEN;
        Vehicule vehicule = new Vehicule(classeVehicule);

        var contratAuto = new ContratAuto(couvertureAssurantielle, vehicule);
        assertThat(contratAuto.getCotisationAnnuelle()).isEqualTo(200.0);
    }

}
