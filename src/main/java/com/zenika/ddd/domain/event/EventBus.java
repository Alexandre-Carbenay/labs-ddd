package com.zenika.ddd.domain.event;

public interface EventBus {
    void emit(Event event);

    void subscribe(Subscriber subscriber, Class<? extends Event> eventClass);
}
