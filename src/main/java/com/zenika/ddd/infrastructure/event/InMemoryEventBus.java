package com.zenika.ddd.infrastructure.event;

import com.zenika.ddd.domain.event.Event;
import com.zenika.ddd.domain.event.EventBus;
import com.zenika.ddd.domain.event.Subscriber;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class InMemoryEventBus implements EventBus {

    Map<Class<? extends Event>, Set<Subscriber>> subscribersByEvent = new HashMap<>();

    @Override
    public void emit(Event event) {
        subscribersByEvent
                .getOrDefault(event.getClass(), Collections.emptySet())
                .forEach(subscriber -> subscriber.onEvent(event));
    }

    @Override
    public void subscribe(Subscriber subscriber, Class<? extends Event> clazz) {
        Set<Subscriber> subscribers = this.subscribersByEvent.get(clazz);
        if (subscribers == null) {
            subscribers = new HashSet<>();
            subscribersByEvent.put(clazz, subscribers);
        }
        subscribers.add(subscriber);
    }
}
