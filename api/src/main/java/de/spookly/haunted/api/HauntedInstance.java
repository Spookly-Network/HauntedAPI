package de.spookly.haunted.api;

import de.spookly.haunted.api.event.executer.EventExecuter;
import de.spookly.haunted.api.server.Server;

public interface HauntedInstance {

    EventExecuter getEventExecuter();

    Server getServer();

}
