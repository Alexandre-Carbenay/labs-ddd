package com.zenika.ddd.domain.contratauto;

import com.zenika.ddd.domain.contratauto.ContratAuto;

public interface ContratAutoRepository {
    ContratAuto findById(String id);

    void save(ContratAuto contratAuto);
}
