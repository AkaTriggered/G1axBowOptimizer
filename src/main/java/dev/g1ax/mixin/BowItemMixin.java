package dev.g1ax.mixin;

import dev.g1ax.optimizer.BowUseOptimizer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BowItem.class)
public class BowItemMixin {
    
    @Inject(method = "onStoppedUsing", at = @At("HEAD"))
    private void onBowRelease(ItemStack stack, World world, LivingEntity user, int remainingUseTicks, CallbackInfo ci) {
        if (world.isClient() && user instanceof PlayerEntity) {
            BowUseOptimizer.stopUsing();
        }
    }
}
