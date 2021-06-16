package com.zenika.ddd.pickingcommandeclient.domain.cheminderamasse;

import java.util.List;

public interface CheminDeRamasseRepository {
    void save(List<CheminDeRamasse> cheminsDeRamasse);

    List<CheminDeRamasse> findAll();

    CheminDeRamasse find(CheminDeRamasseId id);
}
