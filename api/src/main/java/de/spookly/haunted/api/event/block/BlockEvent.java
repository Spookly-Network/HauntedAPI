package de.spookly.haunted.api.event.block;

import de.spookly.haunted.api.event.Event;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public abstract class BlockEvent implements Event {

    private final Block block;

    public BlockEvent(@NotNull final Block block) {
        this.block = block;
    }

    /**
     * Gets the block involved in this event.
     *
     * @return The Block which block is involved in this event
     */
    @NotNull
    public final Block getBlock() {
        return block;
    }
}
