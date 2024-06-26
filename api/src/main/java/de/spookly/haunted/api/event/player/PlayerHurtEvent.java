package de.spookly.haunted.api.event.player;

import de.spookly.haunted.api.event.Cancellable;
import net.minecraft.server.level.ServerPlayer;

public class PlayerHurtEvent extends PlayerEvent implements Cancellable {

    private boolean cancelled;

    public PlayerHurtEvent(ServerPlayer player) {
        super(player);
    }

    @Override
    public boolean isCancelled() {
        return cancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancelled = cancel;
    }
}
