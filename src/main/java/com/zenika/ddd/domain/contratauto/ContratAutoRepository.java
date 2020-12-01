package com.zenika.ddd.domain.contratauto;

import com.zenika.ddd.domain.contratauto.ContratAuto;

public interface ContratAutoRepository {
    ContratAutoId generateId();

    ContratAuto findById(ContratAutoId id);

    void save(ContratAuto contratAuto);
}
