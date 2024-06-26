package de.spookly.haunted.api.event.executer;

import de.spookly.haunted.api.event.Event;
import org.jetbrains.annotations.NotNull;

public interface EventExecuter {

    public <T extends Event> void register(Class<T> aClass, @NotNull EventSubscriber<T> listener);
    public <T extends Event> void unregister(@NotNull EventSubscriber<T> listener);
    void callEvent(@NotNull Event event);

}
