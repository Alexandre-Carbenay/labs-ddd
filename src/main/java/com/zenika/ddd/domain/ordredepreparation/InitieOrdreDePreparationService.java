package com.zenika.ddd.domain.ordredepreparation;

import com.zenika.ddd.domain.Event;
import com.zenika.ddd.domain.EventBus;
import com.zenika.ddd.domain.EventListener;
import com.zenika.ddd.domain.reception.ReceptionCloturee;

public class InitieOrdreDePreparationService implements EventListener {

    public InitieOrdreDePreparationService(EventBus eventBus) {
        eventBus.subscribe(this, ReceptionCloturee.class);
    }

    @Override
    public void onEvent(Event event) {
        var receptionCloturee = (ReceptionCloturee) event;
        // initier un ordre de preparation à partir de la réception
    }
}
