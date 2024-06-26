package de.spookly.haunted.mixin;

import de.spookly.haunted.api.Haunted;
import de.spookly.haunted.api.event.player.PlayerHurtEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ServerPlayer.class)
public class ServerPlayerMixin {

    @Inject(method = "hurt", at = @At("HEAD"), cancellable = true)
    public void injectHurtMethod(DamageSource damageSource, float f, CallbackInfoReturnable<Boolean> cir) {
        PlayerHurtEvent event = new PlayerHurtEvent((ServerPlayer) (Object) this);
        Haunted.getEventExecuter().callEvent(event);
        if (event.isCancelled()) {
            cir.setReturnValue(false);
        }
    }

}
