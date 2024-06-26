package de.spookly.haunted.api.event.executer;


import de.spookly.haunted.api.event.Event;

public interface EventSubscriber<T extends Event> {

     void handle(T event);

}
