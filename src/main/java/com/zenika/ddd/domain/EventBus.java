package com.zenika.ddd.domain;

public interface EventBus {

    void emit(Event event);

    void subscribe(EventListener listener, Class<? extends Event> eventClass);

}
