package de.spookly.haunted.api.event.lifecycle.server;

import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;

public class ServerStartingEvent extends ServerEvent{

    public ServerStartingEvent(@NotNull MinecraftServer server) {
        super(server);
    }
}
