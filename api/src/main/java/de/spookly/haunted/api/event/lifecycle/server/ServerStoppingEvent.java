package de.spookly.haunted.api.event.lifecycle.server;

import net.minecraft.server.MinecraftServer;
import org.jetbrains.annotations.NotNull;

public class ServerStoppingEvent extends ServerEvent {
    public ServerStoppingEvent(@NotNull MinecraftServer server) {
        super(server);
    }
}
