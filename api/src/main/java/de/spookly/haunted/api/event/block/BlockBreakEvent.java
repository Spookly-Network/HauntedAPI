package de.spookly.haunted.api.event.block;

import de.spookly.haunted.api.event.Cancellable;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

public class BlockBreakEvent extends BlockEvent implements Cancellable {

    private boolean cancel = false;

    public BlockBreakEvent(@NotNull Block block) {
        super(block);
    }

    @Override
    public boolean isCancelled() {
        return cancel;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.cancel = cancel;
    }
}
