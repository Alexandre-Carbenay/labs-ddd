package com.zenika.ddd.domain.reception;

import com.zenika.ddd.domain.Event;

import java.time.LocalDateTime;

public class ReceptionCloturee implements Event {
    private final ReceptionId receptionId;
    private final LocalDateTime eventDate;

    public ReceptionCloturee(ReceptionId receptionId) {
        this.receptionId = receptionId;
        this.eventDate = LocalDateTime.now();
    }

    public ReceptionId getReceptionId() {
        return receptionId;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }
}
