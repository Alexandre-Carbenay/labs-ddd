package com.zenika.ddd.infrastructure;

import com.zenika.ddd.domain.Event;
import com.zenika.ddd.domain.EventBus;
import com.zenika.ddd.domain.EventListener;

import java.util.*;

public class InMemoryEventBus implements EventBus {

    private Map<Class<? extends Event>, Set<EventListener>> listenersByEvent = new HashMap<>();

    @Override
    public void emit(Event event) {
        listenersByEvent.getOrDefault(event.getClass(), Collections.emptySet())
                .forEach(listener -> listener.onEvent(event));
    }

    @Override
    public void subscribe(EventListener listener, Class<? extends Event> eventClass) {
        Set<EventListener> listeners = this.listenersByEvent.get(eventClass);
        if (listeners == null) {
            listeners = new HashSet<>();
            listenersByEvent.put(eventClass, listeners);
        }
        listeners.add(listener);
    }
}
