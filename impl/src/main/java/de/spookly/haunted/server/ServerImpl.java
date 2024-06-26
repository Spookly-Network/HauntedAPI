package de.spookly.haunted.server;

import de.spookly.haunted.api.server.Server;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ServerLinks;

import java.util.List;

public class ServerImpl implements Server {

    private final MinecraftServer server;

    public ServerImpl(MinecraftServer server) {
        this.server = server;
    }

    @Override
    public MinecraftServer getNMSServer() {
        return server;
    }

    @Override
    public void setServerLinks(List<ServerLinks.Entry> links) {
        server.serverLinks().entries().clear();
        server.serverLinks().entries().addAll(links);
    }
}
