package com.zenika.ddd.domain.contratauto;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.zenika.ddd.domain.contratauto.ClasseVehicule.HAUT;
import static com.zenika.ddd.domain.contratauto.ClasseVehicule.MOYEN;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assumptions.assumeThat;

public class ContratAutoTest {

    private static final CouvertureAssurantielleId COUVERTURE_ASSURANTIELLE_ID = new CouvertureAssurantielleId("ca123");
    private static final Immatriculation IMMATRICULATION = new Immatriculation("aa-123-aa");
    private static final ContratAutoId CONTRAT_AUTO_ID = new ContratAutoId("123");

    @ParameterizedTest
    @MethodSource("calculCoefficients")
    void cotisationAttendueALaCreation(Montant montantForfaitaire,
                                       ClasseVehicule classeVehicule,
                                       Coefficient coefficientConducteurPrincipal,
                                       Montant cotisationAnnuelle) {
        CouvertureAssurantielle couvertureAssurantielle = new CouvertureAssurantielle(COUVERTURE_ASSURANTIELLE_ID, montantForfaitaire);
        Vehicule vehicule = new Vehicule(IMMATRICULATION, classeVehicule);
        ConducteurPrincipal conducteurPrincipal = new ConducteurPrincipal(coefficientConducteurPrincipal);

        ContratAuto contratAuto = new ContratAuto(CONTRAT_AUTO_ID, couvertureAssurantielle, vehicule, conducteurPrincipal);
        assertThat(contratAuto.getCotisationAnnuelle()).isEqualTo(cotisationAnnuelle);
    }

    static Stream<Arguments> calculCoefficients() {
        return Stream.of(
                Arguments.of(Montant.euros(100.0), MOYEN, Coefficient.of(0.5), Montant.euros(100.0)),
                Arguments.of(Montant.euros(100.0), HAUT,  Coefficient.of(1.5), Montant.euros(450.0)));
    }

    @ParameterizedTest
    @MethodSource("calculCoefficients")
    void cotisationAttendueApresMiseAJour(Montant nouveauMontantForfaitaire,
                                       ClasseVehicule nouvelleClasseVehicule,
                                       Coefficient nouveauCoefficientConducteurPrincipal,
                                       Montant nouvelleCotisationAnnuelle) {
        ContratAuto contratAuto = new ContratAuto(CONTRAT_AUTO_ID,
                new CouvertureAssurantielle(COUVERTURE_ASSURANTIELLE_ID, Montant.euros(100.0)),
                new Vehicule(IMMATRICULATION, MOYEN),
                new ConducteurPrincipal(Coefficient.of(0.5)));
        assumeThat(contratAuto.getCotisationAnnuelle()).isEqualTo(Montant.euros(100.0));

        CouvertureAssurantielle nouvelleCouvertureAssurantielle = new CouvertureAssurantielle(COUVERTURE_ASSURANTIELLE_ID, nouveauMontantForfaitaire);
        Vehicule nouveauVehicule = new Vehicule(IMMATRICULATION, nouvelleClasseVehicule);
        ConducteurPrincipal nouveauConducteurPrincipal = new ConducteurPrincipal(nouveauCoefficientConducteurPrincipal);

        contratAuto.miseAJour(nouvelleCouvertureAssurantielle, nouveauVehicule, nouveauConducteurPrincipal);
        assertThat(contratAuto.getCotisationAnnuelle()).isEqualTo(nouvelleCotisationAnnuelle);
    }

    void evenementCotisationMiseAJour() {
        ContratAuto contratAuto = new ContratAuto(CONTRAT_AUTO_ID,
                new CouvertureAssurantielle(COUVERTURE_ASSURANTIELLE_ID, Montant.euros(100.0)),
                new Vehicule(IMMATRICULATION, MOYEN),
                new ConducteurPrincipal(Coefficient.of(0.5)));
        assumeThat(contratAuto.getCotisationAnnuelle()).isEqualTo(Montant.euros(100.0));

        CouvertureAssurantielle nouvelleCouvertureAssurantielle = new CouvertureAssurantielle(COUVERTURE_ASSURANTIELLE_ID, Montant.euros(100.0));
        Vehicule nouveauVehicule = new Vehicule(IMMATRICULATION, HAUT);
        ConducteurPrincipal nouveauConducteurPrincipal = new ConducteurPrincipal(Coefficient.of(1.5));

        CotisationContratAutoMiseAJour evenement = contratAuto.miseAJour(nouvelleCouvertureAssurantielle, nouveauVehicule, nouveauConducteurPrincipal);
        SoftAssertions.assertSoftly(s -> {
            s.assertThat(evenement.getContratAutoId()).isEqualTo(CONTRAT_AUTO_ID);
            s.assertThat(evenement.getAncienneCotisation()).isEqualTo(Montant.euros(100.0));
            s.assertThat(evenement.getNouvelleCotisation()).isEqualTo(Montant.euros(450.0));
        });
    }

}
