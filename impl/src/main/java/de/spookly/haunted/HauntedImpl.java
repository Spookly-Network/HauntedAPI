package de.spookly.haunted;

import de.spookly.haunted.api.Haunted;
import de.spookly.haunted.api.event.executer.EventExecuter;
import de.spookly.haunted.api.event.lifecycle.server.ServerStartingEvent;
import de.spookly.haunted.api.event.lifecycle.server.ServerStoppingEvent;
import de.spookly.haunted.api.event.player.PlayerHurtEvent;
import de.spookly.haunted.events.EventExecuterImpl;
import de.spookly.haunted.server.ServerImpl;
import lombok.Getter;
import lombok.Setter;
import net.fabricmc.api.ModInitializer;
import net.kyori.adventure.platform.fabric.FabricServerAudiences;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Getter @Setter
public class HauntedImpl implements ModInitializer {

    @Getter //Instance getter
    private static HauntedImpl instance;

    private EventExecuter executer;
    private volatile FabricServerAudiences adventure;

//    private static final Logger LOGGER = LoggerFactory.getLogger("Haunted-API");

    //
    private ServerImpl serverImplementation;

    public HauntedImpl() {
        instance = this;
        this.executer = new EventExecuterImpl();
    }

    public FabricServerAudiences adventure() {
        FabricServerAudiences ret = this.adventure;
        if(ret == null) {
            throw new IllegalStateException("Tried to access Adventure without a running server!");
        }
        return ret;
    }

    @Override
    public void onInitialize() {
        Haunted.init(new HauntedInstanceImpl(this));

        executer.register(PlayerHurtEvent.class, event -> {
            event.setCancelled(true);
        });


        // Register with the server lifecycle callbacks
        // This will ensure any platform data is cleared between game instances
        // This is important on the integrated server, where multiple server instances
        // can exist for one mod initialization.
        executer.register(ServerStartingEvent.class, event -> {
            this.adventure = FabricServerAudiences.of(event.getServer());
        });
        executer.register(ServerStoppingEvent.class, event -> {
            this.adventure = null;
        });
    }
}
