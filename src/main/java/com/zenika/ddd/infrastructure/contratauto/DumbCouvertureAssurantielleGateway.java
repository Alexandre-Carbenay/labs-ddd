package com.zenika.ddd.infrastructure.contratauto;

import com.zenika.ddd.domain.contratauto.CouvertureAssurantielle;
import com.zenika.ddd.domain.contratauto.CouvertureAssurantielleGateway;
import com.zenika.ddd.domain.contratauto.CouvertureAssurantielleId;
import com.zenika.ddd.domain.contratauto.Montant;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DumbCouvertureAssurantielleGateway implements CouvertureAssurantielleGateway {

    private Random montantRandom = new Random();

    @Override
    public CouvertureAssurantielle findById(CouvertureAssurantielleId idCouvertureAssurantielle) {
        return new CouvertureAssurantielle(idCouvertureAssurantielle, Montant.euros(montantRandom.nextDouble() % 100 + 100));
    }

}
