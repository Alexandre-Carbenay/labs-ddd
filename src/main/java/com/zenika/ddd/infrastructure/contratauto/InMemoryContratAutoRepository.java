package com.zenika.ddd.infrastructure.contratauto;

import com.zenika.ddd.domain.contratauto.ContratAuto;
import com.zenika.ddd.domain.contratauto.ContratAutoRepository;

import java.util.HashMap;
import java.util.Map;

public class InMemoryContratAutoRepository implements ContratAutoRepository {
    private final Map<String, ContratAuto> database = new HashMap<>();

    @Override
    public ContratAuto findById(String id) {
        return database.get(id);
    }

    @Override
    public void save(ContratAuto contratAuto) {
        database.put(contratAuto.getId(), contratAuto);
    }
}
