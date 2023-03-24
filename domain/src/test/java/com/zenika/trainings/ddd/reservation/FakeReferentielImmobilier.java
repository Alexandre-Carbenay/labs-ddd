package com.zenika.trainings.ddd.reservation;

import java.util.Optional;

public class FakeReferentielImmobilier implements ReferentielImmobilier {

    private Salle salle;

    @Override
    public Optional<Salle> trouveLaSalle(ReferenceSalle referenceSalle) {
        return Optional.ofNullable(salle);
    }

    public void sauvegarder(Salle salle) {
        this.salle = salle;
    }
}
