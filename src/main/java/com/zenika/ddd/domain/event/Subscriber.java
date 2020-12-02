package com.zenika.ddd.domain.event;

public interface Subscriber {
    void onEvent(Event event);
}
