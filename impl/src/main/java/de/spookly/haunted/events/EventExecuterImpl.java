package de.spookly.haunted.events;

import de.spookly.haunted.api.event.Event;
import de.spookly.haunted.api.event.executer.EventExecuter;
import de.spookly.haunted.api.event.executer.EventSubscriber;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventExecuterImpl implements EventExecuter {

    private Map<Class<? extends Event>, List<EventSubscriber>> registeredEvents = new HashMap<>();

    @Override
    public <T extends Event> void register(@NotNull Class<T> aClass, @NotNull EventSubscriber<T> listener) {
        if (registeredEvents.containsKey(aClass)) {
            registeredEvents.get(aClass).add(listener);
        } else {
            List<EventSubscriber> subscribers = new ArrayList<>();
            subscribers.add(listener);
            registeredEvents.put(aClass, subscribers);
        }
    }

    @Override
    public <T extends Event> void unregister(@NotNull EventSubscriber<T> listener) {
        List<EventSubscriber> subscribers = registeredEvents.get(listener.getClass().componentType());
        if (subscribers != null) {
            subscribers.remove(listener);
            if (subscribers.isEmpty()) {
                registeredEvents.remove(listener.getClass());
            }
        }
    }

    @Override
    public void callEvent(Event event) {
        //Executing async is bonkers when event is called synced
        if (!registeredEvents.containsKey(event.getClass())) return;
        registeredEvents
                .get(event.getClass())
                .forEach(entry -> {
                    entry.handle(event);
                });
    }
}
