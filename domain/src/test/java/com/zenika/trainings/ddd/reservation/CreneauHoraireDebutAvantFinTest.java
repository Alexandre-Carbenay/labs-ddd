package com.zenika.trainings.ddd.reservation;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static java.time.LocalDateTime.now;
import static org.junit.jupiter.api.Assertions.assertThrows;

class CreneauHoraireDebutAvantFinTest {

    @Test
    void creneauHoraireDebutApresFin() {
        assertThrows(CreneauHoraireInvalideException.class, () -> new CreneauHoraire(now(), now().minusHours(1)));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10, 14})
    void creneauHoraireInferieurA15Minutes(int minutes) {
        assertThrows(CreneauHoraireInvalideException.class, () -> new CreneauHoraire(now(), now().plusMinutes(minutes)));
    }

    @Test
    void creneauHoraireSuperieurA15Minutes() {
        new CreneauHoraire(now(), now().plusMinutes(15));
    }

}
