package com.zenika.ddd.domain.contratauto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ContratAutoTest {

    @Test
    void cotisationAttendueALaCreation() {
        var contratAuto = new ContratAuto(new CouvertureAssurantielle("ca123", 100.0));
        assertThat(contratAuto.getCotisationAnnuelle()).isEqualTo(100.0);
    }

}
