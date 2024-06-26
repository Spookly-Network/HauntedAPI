package de.spookly.haunted.mixin;

import de.spookly.haunted.HauntedImpl;
import de.spookly.haunted.api.Haunted;
import de.spookly.haunted.api.event.lifecycle.server.ServerStartingEvent;
import de.spookly.haunted.api.event.lifecycle.server.ServerStoppingEvent;
import de.spookly.haunted.server.ServerImpl;
import net.minecraft.server.MinecraftServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftServer.class)
public class MinecraftServerMixin {
    @Inject(at = @At(value = "INVOKE", target = "Lnet/minecraft/server/MinecraftServer;initServer()Z"), method = "runServer")
    private void beforeSetupServer(CallbackInfo info) { //Call event when server is starting
        ServerStartingEvent event = new ServerStartingEvent((MinecraftServer) (Object) this);
        Haunted.getEventExecuter().callEvent(event);
    }

    @Inject(at = @At(value = "HEAD"), method = "runServer")
    private void newServer(CallbackInfo info) { //Set Haunted-API-Server instance
        HauntedImpl.getInstance().setServerImplementation(new ServerImpl((MinecraftServer) (Object) this));
    }

    @Inject(at = @At(value = "HEAD"), method = "stopServer")
    private void onShutdownServer(CallbackInfo info) { //Call event when server if stopping
        ServerStoppingEvent event = new ServerStoppingEvent((MinecraftServer) (Object) this);
        Haunted.getEventExecuter().callEvent(event);
    }
}
