package de.spookly.haunted.api.event.player;

import de.spookly.haunted.api.event.Event;
import lombok.AllArgsConstructor;
import lombok.Getter;
import net.minecraft.server.level.ServerPlayer;

@AllArgsConstructor @Getter
public abstract class PlayerEvent implements Event {
    private final ServerPlayer player;
}
