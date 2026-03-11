package dev.g1ax.mixin;

import dev.g1ax.optimizer.BowUseOptimizer;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.packet.s2c.play.EntityStatusS2CPacket;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin {
    
    @Inject(method = "onEntityStatus", at = @At("HEAD"), cancellable = true)
    private void onEntityStatus(EntityStatusS2CPacket packet, CallbackInfo ci) {
        MinecraftClient client = MinecraftClient.getInstance();
        if (client.player != null && packet.getEntity(client.world) == client.player) {
            if (BowUseOptimizer.isUsing() && BowUseOptimizer.isFullyCharged(BowUseOptimizer.getUseTicks())) {
                ci.cancel();
            }
        }
    }
}
