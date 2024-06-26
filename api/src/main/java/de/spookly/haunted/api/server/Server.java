package de.spookly.haunted.api.server;

import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ServerLinks;

import java.util.List;

public interface Server {
    MinecraftServer getNMSServer();
    void setServerLinks(List<ServerLinks.Entry> links);
}
