package dev.g1ax.mixin;

import dev.g1ax.optimizer.BowUseOptimizer;
import net.minecraft.client.network.ClientPlayerInteractionManager;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ClientPlayerInteractionManager.class)
public class ClientPlayerInteractionManagerMixin {
    
    @Inject(method = "interactItem", at = @At("RETURN"))
    private void onItemUse(PlayerEntity player, Hand hand, CallbackInfoReturnable<ActionResult> cir) {
        ItemStack stack = player.getStackInHand(hand);
        if ((stack.getItem() instanceof BowItem || stack.getItem() instanceof CrossbowItem) 
            && cir.getReturnValue().isAccepted()) {
            BowUseOptimizer.startUsing();
        }
    }

    @Inject(method = "stopUsingItem", at = @At("HEAD"))
    private void onStopUsing(PlayerEntity player, CallbackInfo ci) {
        BowUseOptimizer.stopUsing();
    }
}

