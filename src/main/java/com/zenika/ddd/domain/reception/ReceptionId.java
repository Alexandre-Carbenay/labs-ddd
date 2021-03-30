package com.zenika.ddd.domain.reception;

import java.util.concurrent.atomic.AtomicInteger;

public class ReceptionId {

    private static final AtomicInteger sequence = new AtomicInteger();

    private final int id;

    public ReceptionId(int id) {
        this.id = id;
    }

    public static ReceptionId newId() {
        return new ReceptionId(sequence.incrementAndGet());
    }
}
