package com.zenika.trainings.ddd.reservation;

import java.util.Optional;

public interface ReferentielImmobilier {

    Optional<Salle> trouveLaSalle(ReferenceSalle referenceSalle);

}
