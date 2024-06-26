package de.spookly.haunted.api;

import de.spookly.haunted.api.event.executer.EventExecuter;
import de.spookly.haunted.api.server.Server;
import org.jetbrains.annotations.NotNull;

public class Haunted {

    private static HauntedInstance instance;

    public static void init(@NotNull final HauntedInstance server) {
        if (Haunted.instance != null) {
            throw new IllegalStateException("Haunted instance is already defined.");
        }
        Haunted.instance = server;
    }

    public static EventExecuter getEventExecuter() {
        return instance.getEventExecuter();
    }

    public static Server getServer() {
        return instance.getServer();
    }
}
