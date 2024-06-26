package de.spookly.haunted.api.event.lifecycle.server;

import de.spookly.haunted.api.event.Event;
import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;

public abstract class ServerEvent implements Event {

    private final MinecraftServer server;

    public ServerEvent(@NotNull MinecraftServer server) {
        this.server = server;
    }

    @NotNull
    public final MinecraftServer getServer() {
        return server;
    }
}
