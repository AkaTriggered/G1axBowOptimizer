package dev.g1ax.mixin;

import dev.g1ax.optimizer.BowUseOptimizer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.CrossbowItem;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(CrossbowItem.class)
public class CrossbowItemMixin {
    
    @Inject(method = "onStoppedUsing", at = @At("HEAD"))
    private void onCrossbowRelease(ItemStack stack, World world, LivingEntity user, int remainingUseTicks, CallbackInfo ci) {
        if (world.isClient() && user instanceof PlayerEntity) {
            BowUseOptimizer.stopUsing();
        }
    }

    @Inject(method = "usageTick", at = @At("HEAD"))
    private void onUsageTick(World world, LivingEntity user, ItemStack stack, int remainingUseTicks, CallbackInfo ci) {
        if (world.isClient() && user instanceof PlayerEntity) {
            if (!BowUseOptimizer.isUsing()) {
                BowUseOptimizer.startUsing();
            }
        }
    }
}
