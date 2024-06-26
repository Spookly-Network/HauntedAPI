package de.spookly.haunted;

import de.spookly.haunted.api.HauntedInstance;
import de.spookly.haunted.api.event.executer.EventExecuter;
import de.spookly.haunted.api.server.Server;

public class HauntedInstanceImpl implements HauntedInstance {

    private HauntedImpl instance;

    protected HauntedInstanceImpl(HauntedImpl instance) {
        this.instance = instance;
    }

    @Override
    public EventExecuter getEventExecuter() {
        return instance.getExecuter();
    }

    @Override
    public Server getServer() {
        return instance.getServerImplementation();
    }


}
