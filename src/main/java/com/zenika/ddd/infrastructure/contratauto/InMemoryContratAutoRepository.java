package com.zenika.ddd.infrastructure.contratauto;

import com.zenika.ddd.domain.contratauto.ContratAuto;
import com.zenika.ddd.domain.contratauto.ContratAutoId;
import com.zenika.ddd.domain.contratauto.ContratAutoRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class InMemoryContratAutoRepository implements ContratAutoRepository {
    private final AtomicInteger idSequence = new AtomicInteger(0);
    private final Map<ContratAutoId, ContratAuto> database = new HashMap<>();

    @Override
    public ContratAutoId generateId() {
        return new ContratAutoId(Integer.toString(idSequence.incrementAndGet()));
    }

    @Override
    public ContratAuto findById(ContratAutoId id) {
        return database.get(id);
    }

    @Override
    public void save(ContratAuto contratAuto) {
        database.put(contratAuto.getId(), contratAuto);
    }
}
